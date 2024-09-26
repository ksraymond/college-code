using System;

namespace KRaymondBattleship
{
    class Program
    {
        /// <summary>
        /// program to play a 1 sided game of battleship
        /// Author: Keaton Raymond
        /// </summary>
        static void Main(string[] args)
        {
            Game game = new Game();
            game.Start();
        }
    }
}
