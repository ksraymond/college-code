using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InClassPracticeArrays
{
    /// <summary>
    /// Act as a container for a gameboard
    /// </summary>
    class Board
    {
        //field
        //declare 2D array
        char[,] gameBoard = new char[10, 10];

        public void FillBoard(char newChar)
        {
            for (int row = 0; row < gameBoard.GetLength(0); row++)
            {
                for (int col = 0; col < gameBoard.GetLength(1); col++)
                {
                    gameBoard[row, col] = newChar;
                }
            }
        }

        public void Checkerboard(char input1, char input2)
        {
            for (int row = 0; row < gameBoard.GetLength(0); row++)
            {
                for (int col = 0; col < gameBoard.GetLength(1); col++)
                {
                    if (row % 2 == 1) //if odd row, print input 1 then 2
                    {
                        gameBoard[row, col] = input1;
                        col++;
                        gameBoard[row, col] = input2;
                    }
                    else //if even row, print input 2 then 1
                    {
                        gameBoard[row, col] = input2;
                        col++;
                        gameBoard[row, col] = input1;
                    }
                }
            }
        }

        //prompt user for character, fill board with the character
        public void Exercise1()
        {
            Console.Write("Input a character to fill the board: ");
            char input = Console.ReadLine()[0]; ;
            FillBoard(input);

            Display();
        }

        //prompt user for 2 characters, fill board in a checkerboard
        public void Exercise2()
        {
            Console.Write("Input the first character to fill the board in a checkerboard: ");
            char input1 = Console.ReadLine()[0];
            Console.Write("Input the second character to fill the board in a checkerboard: ");
            char input2 = Console.ReadLine()[0];

            Checkerboard(input1, input2);

            Display();
        }

        //generate a board of random characters and numbers
        public void Exercise3()
        {
            Random rand = new Random();
            string characters = "abcdefghijklmnopqrstuvwxyz1234567890";

            for (int row = 0; row < gameBoard.GetLength(0); row++)
            {
                for (int col = 0; col < gameBoard.GetLength(1); col++)
                {
                    gameBoard[row, col] = characters[rand.Next(0,36)];
                }
            }

            Display();
        }

        //search and replace a user given character from the random array
        public void Exercise4()
        {
            int counter = 0;
            Console.Write("What character would you like to replace: ");
            char replaceMe = Console.ReadLine()[0];
            Console.Write("What would you like to replace it with? ");
            char replaceWith = Console.ReadLine()[0];

                for (int row = 0; row < gameBoard.GetLength(0); row++)
                {
                    for (int col = 0; col < gameBoard.GetLength(1); col++)
                    {
                        if(gameBoard[row, col] == replaceMe)
                        {
                            gameBoard[row, col] = replaceWith;
                            counter++;
                        }
                    }
                }

            if (counter == 0)
                Console.WriteLine("That character is not in the array");
            else
                Display();
        }

        public void Reset()
        {
            FillBoard(' ');
        }

        public void Display()
        {
            DrawHorizontalLine();
            //type "fo" tab tab and get an instant for loop
            for (int row = 0; row < gameBoard.GetLength(0); row++)
            {
                Console.Write("|");
                for (int col = 0; col < gameBoard.GetLength(1); col++)
                {
                    Console.Write($" {gameBoard[row, col]} |"); //put a $ outside of any string you want to format, variables in curly braces
                }
                DrawHorizontalLine();
            }
        }

        public void DrawHorizontalLine()
        {
            Console.WriteLine();
            Console.Write("-");
            for (int i = 0; i < gameBoard.GetLength(1); i++)
            {
                Console.Write("----");
            }
            Console.WriteLine();
        }
    } //end class
}