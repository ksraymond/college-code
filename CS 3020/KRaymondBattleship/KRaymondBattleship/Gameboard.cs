using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KRaymondBattleship
{
    //everything to do with the gameboard
    class Gameboard
    {
        char[,] gameBoard = new char[10, 10];

        public void Display()
        {
            //row and col labels
            char rowLetter = 'A';
            int colNumber = 1;

            //display formatted array
            DrawHorizontalLine();
            for (int row = 0; row < gameBoard.GetLength(0); row++)
            {
                Console.Write($"{rowLetter} ");
                Console.Write("|");
                for (int col = 0; col < gameBoard.GetLength(1); col++)
                {
                    Console.Write($" {gameBoard[row, col]} |");
                }
                DrawHorizontalLine();
                rowLetter++;
            }

            //display column numbers
            Console.Write(" ");
            for (int i = 0; i < gameBoard.GetLength(1); i++)
            {
                Console.Write($" {colNumber, 3}");
                colNumber++;
            }
        }

        public void Miss(int yCoord, int xCoord)
        {
            gameBoard[yCoord, xCoord] = 'X';
        }

        public void Hit(int yCoord, int xCoord)
        {
            gameBoard[yCoord, xCoord] = 'O';
        }

        public void Clear()
        {
            for (int row = 0; row < gameBoard.GetLength(0); row++)
            {
                for (int col = 0; col < gameBoard.GetLength(1); col++)
                {
                    gameBoard[row, col] = ' ';
                }
            }
        }

        public char CheckIndex(int yCoord, int xCoord)
        {
            return gameBoard[yCoord, xCoord];
        }

        public void SetIndex(int yCoord, int xCoord, char ID)
        {
            gameBoard[yCoord, xCoord] = ID;
        }

        public int GetWidth()
        {
            return gameBoard.GetLength(1);
        }

        public int GetHeight()
        {
            return gameBoard.GetLength(0);
        }

        public void DrawHorizontalLine()
        {
            Console.WriteLine();
            Console.Write("  -");
            for (int i = 0; i < gameBoard.GetLength(1); i++)
            {
                Console.Write("----");
            }
            Console.WriteLine();
        }
    }
}
