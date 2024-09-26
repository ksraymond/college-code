using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge7_RPGUI
{
    /// <summary>
    /// parent class of all 6 different sprites
    /// the combat, sprite stats, and move attack math are all abysmally balanced but all of the functionality is there
    /// </summary>
    public class Sprites
    {
        int speed;
        int skillPoints;
        int maxHealth;
        int healthLeft;
        int intelligence;
        int strength;
        int labelIndex;
        Moves[] moveSet;
        Moves selectedMove;
        bool playerControl;
        string name;
        Image spriteImage;

        public virtual int Speed { get => speed; set => speed = value; }
        public virtual string Name { get => name; set => name = value; }
        public virtual int SkillPoints { get => skillPoints; set => skillPoints = value; }
        public virtual int MaxHealth { get => maxHealth; set => maxHealth = value; }
        public virtual int HealthLeft { get => healthLeft; set => healthLeft = value; }
        public virtual int Intelligence { get => intelligence; set => intelligence = value; }
        public virtual int Strength { get => strength; set => strength = value; }
        public virtual Moves[] MoveSet { get => moveSet; }
        public virtual bool PlayerControl { get => playerControl; set => playerControl = value; }
        public Moves SelectedMove { get => selectedMove; set => selectedMove = value; }
        public virtual Image SpriteImage { get => spriteImage; set => spriteImage = value; }
        public int LabelIndex { get => labelIndex; set => labelIndex = value; }

        public virtual void SetMoves(){}

        public bool IsDead()
        {
            if (this.HealthLeft <= 0)
                return true;
            else
                return false;
        }
    }
}
