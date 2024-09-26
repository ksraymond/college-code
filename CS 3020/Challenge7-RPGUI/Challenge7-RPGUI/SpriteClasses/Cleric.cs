﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge7_RPGUI
{
    public class Cleric : Sprites
    {
        int speed = 8;
        int skillPoints = 12;
        int maxHealth = 40;
        int healthLeft = 40;
        int intelligence = 6;
        int strength = 7;
        Moves[] moveSet = new Moves[3];
        bool playerControl = true;
        string name = "Cleric";
        Image spriteImage = Properties.Resources.Cleric;

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
            moveSet[1] = new Moves("Heal", skillPoints, "Heal one of your teammates");
            moveSet[2] = new Moves("Divine Arrow", strength + skillPoints, "Shoot opposing enemy with a divine arrow dealing ranged damage.");
        }
    }
}
