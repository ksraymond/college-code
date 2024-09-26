using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KRaymondBattleship
{
    //act as the template for all ships
    class Ship
    {
        private String type;
        private int length;
        private char ID;

        public Ship(String type, char ID, int length)
        {
            this.type = type;
            this.length = length;
            this.ID = ID;
        }

        public int GetLength()
        {
            return length;
        }

        public String GetShipType()
        {
            return type;
        }

        public char GetID()
        {
            return ID;
        }
    }
}