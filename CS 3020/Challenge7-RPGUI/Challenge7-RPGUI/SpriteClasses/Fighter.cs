using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge7_RPGUI
{
    public class Fighter : Sprites
    {
        int speed = 13;
        int skillPoints = 8;
        int maxHealth = 50;
        int healthLeft = 50;
        int intelligence = 3;
        int strength = 10;
        Moves[] moveSet = new Moves[3];
        bool playerControl = true;
        string name = "Fighter";
        Image spriteImage = Properties.Resources.Fighter;

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
            moveSet[0] = new Moves("Basic Attack", strength + intelligence, "Attack opposing enemy dealing physical damage.");
            moveSet[1] = new Moves("Charge Punch", strength + skillPoints, "Attack opposing enemy with a charged punch dealing physical damage");
            moveSet[2] = new Moves("Throw Rocks", intelligence, 
                                    "Pick up some rocks and throw them at the enemy. Deals low physical damage but irritates them.");
        }
    }
}
