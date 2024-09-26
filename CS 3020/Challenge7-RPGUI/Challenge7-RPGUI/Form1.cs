using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Challenge7_RPGUI
{
    /// <summary>
    /// class to run all visual and form based aspects of the game
    /// </summary>
    public partial class Form1 : Form
    {
        /// <summary>
        /// create global game object and all global lists
        /// </summary>
        Game game = new Game();
        List<PictureBox> heroPictureBoxes = new List<PictureBox>();
        List<PictureBox> enemyPictureBoxes = new List<PictureBox>();
        List<Label> heroHealthLabels = new List<Label>();
        List<Label> heroNameLabels = new List<Label>();
        List<Label> enemyHealthLabels = new List<Label>();
        List<Label> enemyNameLabels = new List<Label>();
        List<Button> spriteButtons = new List<Button>();

        public Form1()
        {
            InitializeComponent();
            StartGame();
        }

        /// <summary>
        /// call all methods and subscribe all events to initially start game
        /// </summary>
        private void StartGame()
        {
            game.PlayerTurn += OnPlayerTurn;
            game.EnemyTurn += OnEnemyTurn;
            game.SpriteDead += OnSpriteDeath;
            game.GameOver += OnGameOver;
            SetTextLists();
            game.ReadHighScore();
            NewRound();
        }

        /// <summary>
        /// call all methods and start everything that needs to be done at the beginning of each new round
        /// </summary>
        private void NewRound()
        {
            game.CurrentTurn = -1;
            game.InitializeSprites();
            PrintMoveOrder();
            game.SetHeroEnemyOrder();
            SetPictureLists();
            SetLabelIndices();
            BlankLabels();
            SetNameText();
            SetSpriteImages();
            sprite1Btn.Enabled = false;
            sprite2Btn.Enabled = false;
            sprite3Btn.Enabled = false;
            game.PlayTurn();
        }

        #region print/text modification methods
        /// <summary>
        /// at beginning of each new round, tell user the move order
        /// </summary>
        private void PrintMoveOrder()
        {
            BattleLog.AppendText("Move Order\r\n");
            foreach (var sprite in game.MoveOrder)
            {
                BattleLog.AppendText(sprite.Name + "\r\n");
            }
        }

        /// <summary>
        /// resets all name text in the form at the beginning of each round
        /// </summary>
        private void SetNameText()
        {
            for (int i = 0; i < game.HeroOrder.Count; i++)
            {
                heroNameLabels[game.HeroOrder[i].LabelIndex].Text = game.HeroOrder[i].Name;
            }
            for(int i = 0; i < game.EnemyOrder.Count; i++)
            {
                enemyNameLabels[game.EnemyOrder[i].LabelIndex].Text = game.EnemyOrder[i].Name;
                spriteButtons[game.EnemyOrder[i].LabelIndex].Text = game.EnemyOrder[i].Name;
            }
            SetHealthText();
        }

        /// <summary>
        /// resets all health text after each move
        /// </summary>
        private void SetHealthText()
        {
            for (int i = 0; i < game.HeroOrder.Count; i++)
            {
                heroHealthLabels[game.HeroOrder[i].LabelIndex].Text = $"{game.HeroOrder[i].HealthLeft}/{game.HeroOrder[i].MaxHealth}";
            }
            for (int i = 0; i < game.EnemyOrder.Count; i++)
            {
                enemyHealthLabels[game.EnemyOrder[i].LabelIndex].Text = $"{game.EnemyOrder[i].HealthLeft}/{game.EnemyOrder[i].MaxHealth}";
            }
        }

        /// <summary>
        /// used for after each round, if there are 1 or 2 heros left, it ensures that there are only that number of labels
        /// so that the old labels dont stick around
        /// </summary>
        private void BlankLabels()
        {
            for (int i = 0; i < 3; i++)
            {
                heroHealthLabels[i].Text = "";
                heroNameLabels[i].Text = "";
                enemyHealthLabels[i].Text = "";
                enemyNameLabels[i].Text = "";
                spriteButtons[i].Text = "";
            }
        }

        /// <summary>
        /// change moves to be the moves of the current sprite whose turn it is
        /// </summary>
        private void UpdateMovesBox(Sprites currentSprite)
        {
            heroMovesLbl.Text = $"{currentSprite.Name}'s moveset";
            move1Btn.Text = currentSprite.MoveSet[0].Name;
            move2Btn.Text = currentSprite.MoveSet[1].Name;
            move3Btn.Text = currentSprite.MoveSet[2].Name;
        }
        #endregion

        #region 'set' methods
        /// <summary>
        /// at beginning of each new round, reset the picture box lists, which have been modified
        /// </summary>
        private void SetPictureLists()
        {
            heroPictureBoxes.Add(hero1Pic);
            heroPictureBoxes.Add(hero2Pic);
            heroPictureBoxes.Add(hero3Pic);
            enemyPictureBoxes.Add(enemy1Pic);
            enemyPictureBoxes.Add(enemy2Pic);
            enemyPictureBoxes.Add(enemy3Pic);
        }

        /// <summary>
        /// at beginning of game, create all of the text lists used throughout the program
        /// </summary>
        private void SetTextLists()
        {
            //name label list
            heroNameLabels.Add(hero1Name);
            heroNameLabels.Add(hero2Name);
            heroNameLabels.Add(hero3Name);
            enemyNameLabels.Add(enemy1Name);
            enemyNameLabels.Add(enemy2Name);
            enemyNameLabels.Add(enemy3Name);

            //health label list
            heroHealthLabels.Add(hero1HealthLbl);
            heroHealthLabels.Add(hero2HealthLbl);
            heroHealthLabels.Add(hero3HealthLbl);
            enemyHealthLabels.Add(enemy1HealthLbl);
            enemyHealthLabels.Add(enemy2HealthLbl);
            enemyHealthLabels.Add(enemy3HealthLbl);

            //enemy button list
            spriteButtons.Add(sprite1Btn);
            spriteButtons.Add(sprite2Btn);
            spriteButtons.Add(sprite3Btn);
        }

        /// <summary>
        /// change the sprite images to match the sprites being used
        /// </summary>
        private void SetSpriteImages()
        {
            for (int i = 0; i < game.HeroOrder.Count; i++)
            {
                heroPictureBoxes[i].Image = game.HeroOrder[i].SpriteImage;

            }
            for (int i = 0; i < game.EnemyOrder.Count; i++)
            {
                enemyPictureBoxes[i].Image = game.EnemyOrder[i].SpriteImage;
            }
        }

        /// <summary>
        /// at beginning of each round, assign each sprite an index
        /// used for ensuring that the correct sprite indexes to the correct label
        /// </summary>
        private void SetLabelIndices()
        {
            for (int i = 0; i < game.HeroOrder.Count; i++)
                game.HeroOrder[i].LabelIndex = i;

            for (int i = 0; i < game.EnemyOrder.Count; i++)
                game.EnemyOrder[i].LabelIndex = i;
        }
        #endregion

        #region button modification
        /// <summary>
        /// turn on and off the move buttons to ensure no input when it is not the player's turn
        /// </summary>
        private void ToggleMoveButtons(bool toggle)
        {
            move1Btn.Enabled = toggle;
            move2Btn.Enabled = toggle;
            move3Btn.Enabled = toggle;
        }

        /// <summary>
        /// if the move selected is heal, ensure that the user is selecting a hero not enemy to use move on
        /// </summary>
        private void ChangeSpriteBtns()
        {
            if (game.MoveOrder[game.CurrentTurn].SelectedMove.Name == "Heal")
            {
                for (int i = 0; i < heroNameLabels.Count; i++)
                {
                    spriteButtons[i].Text = heroNameLabels[i].Text;
                }
                foreach (var hero in game.HeroOrder)
                {
                    spriteButtons[hero.LabelIndex].Enabled = true; //only enable buttons corresponding to the alive heros
                }
            }
            else
            {
                for (int i = 0; i < enemyNameLabels.Count; i++)
                    spriteButtons[i].Text = enemyNameLabels[i].Text;
                foreach (var enemy in game.EnemyOrder)
                    spriteButtons[enemy.LabelIndex].Enabled = true;
            }
        }

        private void DisableSpriteBtns()
        {
            foreach (var button in spriteButtons)
                button.Enabled = false;
        }
        #endregion

        /// <summary>
        /// do the player's move, reset everything turned on, and print the correct move message, then play the next turn
        /// </summary>
        private void DoPlayerTurn()
        {
            ToggleMoveButtons(false);
            spriteSelectionBox.Visible = false;
            game.PerformMove(game.MoveOrder[game.CurrentTurn], game.SelectedSprite);

            if(game.MoveOrder[game.CurrentTurn].SelectedMove.Name != "Heal")
            {
                BattleLog.AppendText($"{game.MoveOrder[game.CurrentTurn].Name} attacked {game.SelectedSprite.Name} dealing " +
                                $"{game.MoveOrder[game.CurrentTurn].SelectedMove.Attack} damage\r\n");
            }
            else
            {
                BattleLog.AppendText($"{game.MoveOrder[game.CurrentTurn].Name} healed {game.MoveOrder[game.CurrentTurn].SelectedMove.Attack} " +
                                    $"health points to {game.SelectedSprite.Name}\r\n");
            }

            moveDescriptionBox.Text = "";
            game.PlayTurn();
        }

        /// <summary>
        /// checks if the user healed, and if they did the selected sprite is a hero otherwise the enemy
        /// </summary>
        private void SelectHeroEnemy(int index)
        {
            if (game.MoveOrder[game.CurrentTurn].SelectedMove.Name == "Heal")
            {
                foreach (var hero in game.HeroOrder)
                {
                    if (hero.LabelIndex == index)
                        game.SelectedSprite = hero;
                }
            }
            else
            {
                foreach (var enemy in game.EnemyOrder)
                {
                    if (enemy.LabelIndex == index)
                        game.SelectedSprite = enemy;
                }
            }
            DisableSpriteBtns();
            DoPlayerTurn();
        }

        #region event handlers
        /// <summary>
        /// if it is the players turn, turn on move buttons and update the box
        /// </summary>
        private void OnPlayerTurn(object sender, EventArgs e)
        {
            ToggleMoveButtons(true);

            UpdateMovesBox(game.MoveOrder[game.CurrentTurn]);
            SetHealthText();
        }

        /// <summary>
        /// when sprite dies, check if it is player controlled to send the correct message and remove correct picture box
        /// </summary>
        private void OnSpriteDeath(object sender, EventArgs e)
        {
            SetHealthText();
            if (game.SelectedSprite.PlayerControl)
            {
                for (int i = 0; i < game.HeroOrder.Count; i++)
                {
                    if(game.SelectedSprite == game.HeroOrder[i] && game.HeroOrder[i] != null)
                    {
                        heroPictureBoxes[i].Image = null;
                        BattleLog.AppendText($"{game.HeroOrder[i].Name} was defeated.\r\n");
                        heroPictureBoxes.Remove(heroPictureBoxes[i]);
                    }
                }
            }
            else
            {
                for (int i = 0; i < game.EnemyOrder.Count; i++)
                {
                    if (game.SelectedSprite == game.EnemyOrder[i] && game.EnemyOrder[i] != null)
                    {
                        enemyPictureBoxes[i].Image = null;
                        BattleLog.AppendText($"{game.EnemyOrder[i].Name} was defeated.\r\n");
                        enemyPictureBoxes.Remove(enemyPictureBoxes[i]);
                    }
                }
            }
        }

        /// <summary>
        /// check if player won, display correct message, ask if they would like to play again, clear necessary lists
        /// </summary>
        private void OnGameOver(object sender, EventArgs e)
        {
            if (game.IsWin)
            {
                if(MessageBox.Show("You Won! Keep Playing?", "You Won!", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    game.MoveOrder.Clear();
                    heroPictureBoxes.Clear();
                    enemyPictureBoxes.Clear();
                    BattleLog.Clear();
                    NewRound();
                }
                else
                {
                    Application.Exit();
                }
            }
            else
            {
                if(MessageBox.Show("You Lost :(. Would you like to play again?", "You Lost.", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    game.MoveOrder.Clear();
                    game.EnemyOrder.Clear();
                    heroPictureBoxes.Clear();
                    enemyPictureBoxes.Clear();
                    BattleLog.Clear();
                    NewRound();
                }
                else
                {
                    Application.Exit();
                }
            }
        }

        /// <summary>
        /// check if dragon used breathe fire and display correct message
        /// </summary>
        private void OnEnemyTurn(object sender, EventArgs e)
        {
            if (game.MoveOrder[game.CurrentTurn].SelectedMove.Name == "breathe fire")
            {
                BattleLog.AppendText($"{ game.MoveOrder[game.CurrentTurn].Name} attacked all heroes dealing " +
                    $"{game.MoveOrder[game.CurrentTurn].SelectedMove.Attack} damage to each\r\n");
            }
            else
            {
                BattleLog.AppendText($"{game.MoveOrder[game.CurrentTurn].Name} attacked {game.SelectedSprite.Name} dealing " +
                    $"{game.MoveOrder[game.CurrentTurn].SelectedMove.Attack} damage\r\n");
            }
            SetHealthText();
        }
        
        /// <summary>
        /// set the move selected move to be the one at the index the user selected, show proper description
        /// same for move 2 and 3 buttons
        /// </summary>
        private void move1Btn_Click(object sender, EventArgs e)
        {
            game.MoveOrder[game.CurrentTurn].SelectedMove = game.MoveOrder[game.CurrentTurn].MoveSet[0];
            ChangeSpriteBtns();
            spriteSelectionBox.Visible = true;
            moveDescriptionBox.Text = game.MoveOrder[game.CurrentTurn].MoveSet[0].Description;
        }

        private void move2Btn_Click(object sender, EventArgs e)
        {
            game.MoveOrder[game.CurrentTurn].SelectedMove = game.MoveOrder[game.CurrentTurn].MoveSet[1];
            ChangeSpriteBtns();
            spriteSelectionBox.Visible = true;
            moveDescriptionBox.Text = game.MoveOrder[game.CurrentTurn].MoveSet[1].Description;
        }

        private void move3Btn_Click(object sender, EventArgs e)
        {
            game.MoveOrder[game.CurrentTurn].SelectedMove = game.MoveOrder[game.CurrentTurn].MoveSet[2];
            ChangeSpriteBtns();
            spriteSelectionBox.Visible = true;
            moveDescriptionBox.Text = game.MoveOrder[game.CurrentTurn].MoveSet[2].Description;
        }


        private void sprite1Btn_Click(object sender, EventArgs e)
        {
            SelectHeroEnemy(0);
        }

        private void sprite2Btn_Click(object sender, EventArgs e)
        {
            SelectHeroEnemy(1);
        }

        private void sprite3Btn_Click(object sender, EventArgs e)
        {
            SelectHeroEnemy(2);
        }

        /// <summary>
        /// if user resets, reset the rounds, clear lists, and start a new round
        /// </summary>
        private void restartToolStripMenuItem_Click(object sender, EventArgs e)
        {
            game.RoundsWon = 0;
            game.MoveOrder.Clear();
            game.EnemyOrder.Clear();
            game.HeroOrder.Clear();
            heroPictureBoxes.Clear();
            enemyPictureBoxes.Clear();
            BattleLog.Clear();
            spriteSelectionBox.Visible = false;
            NewRound();
        }

        private void quitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void viewHighScoreToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show($"Current High Score: {game.HighScore}" +
                $"\nCurrent Score: {game.RoundsWon}");
        }

        private void resetHighScoreToolStripMenuItem_Click(object sender, EventArgs e)
        {
            game.HighScore = 0;
            game.WriteHighScore();
            MessageBox.Show("High Score was reset.");
        }
        #endregion
    }
}