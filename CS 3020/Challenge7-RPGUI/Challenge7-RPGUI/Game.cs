using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge7_RPGUI
{
    /// <summary>
    /// Keaton Raymond
    /// CS 3020
    /// (the file is named this because I started writing it during challenge 7, then just didn't stop and can't figure out how to properly rename it)
    /// </summary>
    public class Game
    {
        /// <summary>
        /// eventhandlers, global lists and variables for this class
        /// </summary>
        public event EventHandler PlayerTurn;
        public event EventHandler SpriteDead;
        public event EventHandler EnemyTurn;
        public event EventHandler GameOver;
        List<Sprites> moveOrder = new List<Sprites>();
        List<Sprites> enemyOrder = new List<Sprites>();
        List<Sprites> heroOrder = new List<Sprites>();
        Sprites selectedSprite;
        int currentTurn = -1;
        int roundsWon = 0;
        int highScore;
        bool isWin;

        #region Getters/Setters
        public List<Sprites> MoveOrder { get => moveOrder; set => moveOrder = value; }
        public List<Sprites> EnemyOrder { get => enemyOrder; set => enemyOrder = value; }
        public List<Sprites> HeroOrder { get => heroOrder; set => heroOrder = value; }
        public int CurrentTurn { get => currentTurn; set => currentTurn = value; }
        public Sprites SelectedSprite { get => selectedSprite; set => selectedSprite = value; }
        public bool IsWin { get => isWin; set => isWin = value; }
        public int RoundsWon { get => roundsWon; set => roundsWon = value; }
        public int HighScore { get => highScore; set => highScore = value; }
        #endregion

        #region sprite methods
        /// <summary>
        /// if the game is starting over, make new hero sprites,
        /// otherwise use the current sprites, add the random enemies
        /// </summary>
        public void InitializeSprites()
        {
            List<Sprites> spritesUsed = new List<Sprites>();

            if (roundsWon == 0)
                spritesUsed.AddRange(SetHeros());
            else
                spritesUsed.AddRange(heroOrder);

            spritesUsed.AddRange(RandomEnemies());

            SetMoveOrder(spritesUsed);
        }

        /// <summary>
        /// generates 3 random enemies at the beginning of each round
        /// </summary>
        public List<Sprites> RandomEnemies()
        {
            List<Sprites> enemiesUsed = new List<Sprites>();
            Random rand = new Random();

            for (int i = 0; i < 3; i++)
            {
                int randEnemy = rand.Next(0, 3);
                if (randEnemy == 0)
                    enemiesUsed.Add(new Bandit());
                else if (randEnemy == 1)
                    enemiesUsed.Add(new Dragon());
                else if (randEnemy == 2)
                    enemiesUsed.Add(new Ogre());
            }
            foreach (var enemy in enemiesUsed)
                enemy.SetMoves();

            return enemiesUsed;
        }

        /// <summary>
        /// create and return one of each hero sprite
        /// </summary>
        public List<Sprites> SetHeros()
        {
            List<Sprites> herosUsed = new List<Sprites>();
            herosUsed.Add(new Fighter());
            herosUsed.Add(new Cleric());
            herosUsed.Add(new Mage());
            foreach (var hero in herosUsed)
                hero.SetMoves();

            return herosUsed;
        }
        #endregion

        #region set lists
        /// <summary>
        /// linq query to order the sprites by their speed for their move order
        /// </summary>
        public void SetMoveOrder(List<Sprites> spritesUsed)
        {
            var order =
                from sprite in spritesUsed
                orderby sprite.Speed descending
                select sprite;

            foreach (var sprite in order)
                moveOrder.Add(sprite);
        }

        /// <summary>
        /// divide the move order into a hero and enemy order
        /// </summary>
        public void SetHeroEnemyOrder()
        {
            foreach(var sprite in MoveOrder)
            {
                if (sprite.PlayerControl)
                {
                    if(roundsWon == 0)
                    {
                        heroOrder.Add(sprite);
                    }
                }
                else
                    EnemyOrder.Add(sprite);
            }
        }
        #endregion

        #region turn methods
        /// <summary>
        /// index the current turn to move to the next sprite, check if the sprite is dead, and finally check if it is game over
        /// </summary>
        public void PlayTurn()
        {
            if (currentTurn < moveOrder.Count - 1)
                currentTurn++;
            else
                currentTurn = 0;

            //if sprite is dead, remove the sprite from everything
            if (selectedSprite != null && selectedSprite.IsDead())
            {
                OnSpriteDeath();
                moveOrder.Remove(selectedSprite);
                if (selectedSprite.PlayerControl)
                    HeroOrder.Remove(SelectedSprite);
                else
                    EnemyOrder.Remove(selectedSprite);

                if (currentTurn >= moveOrder.Count)
                    currentTurn = moveOrder.Count - 1;
            }

            if (!IsGameOver())
            {
                    if (moveOrder[currentTurn].PlayerControl)
                    {
                        OnPlayerTurn();
                    }
                    else
                    {
                        PlayEnemyTurn();
                        OnEnemyTurn();
                        PlayTurn();
                    }
                
            }
            else
            {
                OnGameOver();
            }
            
        }

        /// <summary>
        /// if it is an enemy turn, select a random hero and a random attack and perform said attack
        /// if it is the dragon's special move selected, then attack all
        /// </summary>
        public void PlayEnemyTurn()
        {
            Random rand = new Random();
            int randHeroIndex = rand.Next(0, heroOrder.Count);
            int randAttackIndex = rand.Next(0, 2);

            selectedSprite = heroOrder[randHeroIndex];
            moveOrder[CurrentTurn].SelectedMove = moveOrder[CurrentTurn].MoveSet[randAttackIndex];

            if(moveOrder[currentTurn].SelectedMove.Name == "breathe fire")
            {
                foreach(var hero in heroOrder)
                    PerformMove(moveOrder[currentTurn], hero);
            }
            else
                PerformMove(moveOrder[CurrentTurn], selectedSprite);
        }
        #endregion

        /// <summary>
        /// if the sprite performing the move is healing, heal the selected character, otherwise attack
        /// </summary>
        public void PerformMove(Sprites attacker, Sprites attacked)
        {
            if(attacker.SelectedMove.Name != "Heal")
                attacked.HealthLeft -= attacker.SelectedMove.Attack;
            else
            {
                if (attacked.HealthLeft + attacker.SelectedMove.Attack <= attacked.MaxHealth)
                    attacked.HealthLeft += attacker.SelectedMove.Attack;
                else
                    attacked.HealthLeft = attacked.MaxHealth;
            }
        }

        /// <summary>
        /// check if the game is over, if it is check if the player won or lost
        /// </summary>
        private bool IsGameOver()
        {
            if (enemyOrder.Count == 0)
            {
                isWin = true;
                roundsWon++;
                CheckHighScore();
                return true;
            }
            else if (HeroOrder.Count == 0)
            {
                isWin = false;
                roundsWon = 0;
                return true;
            }
            else
                return false;
        }

        #region high score methods
        /// <summary>
        /// if the current score is higher than the high score, that is the new high score and write that to the file
        /// </summary>
        private void CheckHighScore()
        {
            if(roundsWon > highScore)
                highScore = roundsWon;
            WriteHighScore();
        }

        /// <summary>
        /// when the program is first ran, read in the high score from the file
        /// </summary>
        public void ReadHighScore()
        {
            StreamReader reader = new StreamReader("HighScore.txt");
            try
            {
                highScore = int.Parse(reader.ReadLine());
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                reader.Close();
            }
        }

        /// <summary>
        /// write the new high score to the file
        /// </summary>
        public void WriteHighScore()
        {
            StreamWriter writer = new StreamWriter("HighScore.txt");
            try
            {
                writer.WriteLine(highScore);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                writer.Close();
            }
        }
        #endregion

        #region Event Handlers
        private void OnPlayerTurn()
        {
            if(PlayerTurn != null)
                PlayerTurn(this, EventArgs.Empty);
        }

        private void OnSpriteDeath()
        {
            if(SpriteDead != null)
                SpriteDead(this, EventArgs.Empty);
        }

        private void OnEnemyTurn()
        {
            if (EnemyTurn != null)
                EnemyTurn(this, EventArgs.Empty);
        }

        private void OnGameOver()
        {
            if (GameOver != null)
                GameOver(this, EventArgs.Empty);
        }
        #endregion
    }
}