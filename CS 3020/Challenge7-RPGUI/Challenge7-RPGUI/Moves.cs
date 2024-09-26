using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge7_RPGUI
{
    /// <summary>
    /// an object class for the moves
    /// </summary>
    public class Moves
    {
        string name;
        int attack;
        string description;

        public Moves(string name, int attack, string description)
        {
            this.name = name;
            this.attack = attack;
            this.description = description;
        }

        public string Name { get => name; set => name = value; }
        public int Attack { get => attack; set => attack = value; }
        public string Description { get => description; set => description = value; }
    }
}
