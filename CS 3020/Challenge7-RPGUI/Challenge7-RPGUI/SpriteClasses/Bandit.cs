using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge7_RPGUI
{
    public class Bandit : Sprites
    {
        int speed = 15;
        int skillPoints = 4;
        int maxHealth = 20;
        int healthLeft = 20;
        int intelligence = 1;
        int strength = 5;
        Moves[] moveSet = new Moves[2];
        bool playerControl = false;
        string name = "Bandit";
        Image spriteImage = Properties.Resources.Bandit;
        

        public override int Speed { get => speed; set => speed = value; }
        public override string Name { get => name; set => name = value; }
        public override int SkillPoints { get => skillPoints; set => skillPoints = value; }
        public override int MaxHealth { get => maxHealth; set => maxHealth = value; }
        public override int HealthLeft { get => healthLeft; set => healthLeft = value; }
        public override int Intelligence { get => intelligence; set => intelligence = value; }
        public override int Strength { get => strength; set => strength = value; }
        public override Moves[] MoveSet { get => moveSet; }
        public override bool PlayerControl { get => playerControl; }
        public override Image SpriteImage { get => spriteImage; set => spriteImage = value; }

        public override void SetMoves()
        {
            moveSet[0] = new Moves("basic attack", strength+intelligence, "attack opposing hero");
            moveSet[1] = new Moves("special attack", strength + skillPoints, "special attack with more damage");
        }
    }
}
