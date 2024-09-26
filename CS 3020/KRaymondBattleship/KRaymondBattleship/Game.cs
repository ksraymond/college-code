using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KRaymondBattleship
{
    //runs all game logic
    class Game
    {
        Gameboard playerBoard = new Gameboard();
        Gameboard computerBoard = new Gameboard();

        public void Start()
        {
            bool valid = false;
            int playHacks;

            playerBoard.Clear();
            computerBoard.Clear();
            Generate();
            Console.WriteLine("Would you like to play with hacks? Input 1 for yes, 0 for no.");

            //check for valid input
            do
            {
                playHacks = Console.ReadLine()[0] - 48; //subtract 48 to accomodate for reading in a char
                if (playHacks == 1 || playHacks == 0)
                    valid = true;
                else
                    Console.WriteLine("Invalid input, try again.");
            } while (!valid);

            if(playHacks == 1)
                Hacks();

            Play();
        }

        public Ship[] GetShipArray()
        {
            Ship[] ships = new Ship[6];
            ships[0] = new Ship("Destroyer", 'D', 2);
            ships[1] = new Ship("Destroyer", 'd', 2);
            ships[2] = new Ship("Submarine", 'S', 3);
            ships[3] = new Ship("Submarine", 's', 3);
            ships[4] = new Ship("Battleship", 'B', 4);
            ships[5] = new Ship("Carrier", 'C', 5);

            return ships;
        }

        public void Generate()
        {
            int direction, randX, randY;
            bool horizontal, outOfBounds, intersect;
            int width = playerBoard.GetWidth();
            int height = playerBoard.GetHeight();
            Random rand = new Random();
            Ship[] ships = GetShipArray();

            //for every ship, make sure it doesn't intersect or go out of bounds
            for (int i = 0; i < ships.GetLength(0); i++)
            {
                outOfBounds = false;
                intersect = false;

                //random direction and starting coords
                direction = rand.Next(2);
                randX = rand.Next(width);
                randY = rand.Next(height);

                if (direction == 0)
                    horizontal = true;
                else
                    horizontal = false;

                //check if the opposite end of the ship will go out of bounds
                if (horizontal && (randX + ships[i].GetLength()) > playerBoard.GetWidth())
                    outOfBounds = true;
                else if (!horizontal && (randY + ships[i].GetLength()) > playerBoard.GetHeight())
                    outOfBounds = true;

                //if it won't go out of bounds, check if it intersects
                if (!outOfBounds && horizontal)
                {
                    for (int j = 0; j < ships[i].GetLength(); j++)
                    {
                        if (computerBoard.CheckIndex(randY, (randX + j)) != ' ')
                            intersect = true;
                    }
                }
                else if (!outOfBounds && !horizontal)
                {
                    for (int j = 0; j < ships[i].GetLength(); j++)
                    {
                        if (computerBoard.CheckIndex((randY + j), randX) != ' ')
                            intersect = true;
                    }
                }

                //if it isn't out of bounds, and won't intersect, place the ship
                if (!outOfBounds && !intersect)
                {
                    if (horizontal)
                    {
                        for (int j = 0; j < ships[i].GetLength(); j++)
                            computerBoard.SetIndex(randY, (randX + j), ships[i].GetID());
                    }
                    else
                    {
                        for (int j = 0; j < ships[i].GetLength(); j++)
                            computerBoard.SetIndex((randY + j), randX, ships[i].GetID());
                    }
                }

                //if it is out of bounds or intersects, reiterate through the loop with the same ship
                else
                    i--;
            }
        }

        public void Play()
        {
            while (!GameOver())
            {
                playerBoard.Display();
                Console.WriteLine();
                Console.WriteLine();

                int yCoord, xCoord;

                //check for valid coordinates
                bool valid = false;
                do
                {
                    Console.WriteLine("Enter the row you would like to target: ");
                    yCoord = Console.ReadLine()[0] - 65;
                    Console.WriteLine("Enter the column you would like to target: ");
                    xCoord = Convert.ToInt32(Console.ReadLine()) - 1;

                    if(yCoord < playerBoard.GetHeight() && yCoord >= 0 
                        && xCoord >= 0 && xCoord < playerBoard.GetWidth())
                        valid = true;
                    else
                        Console.WriteLine("Invalid coordinates, try again.\n");
                } while (!valid);

                //if at those coords there is anything but a space its a hit, otherwise miss
                if(computerBoard.CheckIndex(yCoord, xCoord) != ' ')
                {
                    playerBoard.Hit(yCoord, xCoord);
                    Console.WriteLine("HIT");

                    //check if the ship that was hit just got sunk
                    if(Sunk(yCoord, xCoord))
                    {
                        Console.WriteLine($"You sunk my {SunkShipType(yCoord, xCoord)}!");
                    }
                }
                else
                {
                    playerBoard.Miss(yCoord, xCoord);
                    Console.WriteLine("MISS");
                }
            }

            Console.WriteLine("Would you like to play again? 1 for yes, 0 for no: ");
            int playAgain = Convert.ToInt32(Console.ReadLine());

            if(playAgain == 1)
                Reset();

            else
                Console.WriteLine("Hope you enjoyed!");

        }

        //used for checking if the game is over
        public int GetTotalLength()
        {
            Ship[] ships = GetShipArray();

            int totalLength = 0;
            for (int i = 0; i < ships.GetLength(0); i++)
            {
                totalLength += ships[i].GetLength();
            }
            return totalLength;
        }

        public bool GameOver()
        {
            //check if the total number of hits is the same as the number of spaces taken by ships
            int hits = 0;
            for (int row = 0; row < playerBoard.GetHeight(); row++)
            {
                for (int col = 0; col < playerBoard.GetWidth(); col++)
                {
                    if (playerBoard.CheckIndex(row, col) == 'O')
                        hits++;
                }
            }

            //if the two are equal then the game is over
            if (hits == GetTotalLength())
                return true;
            else
                return false;
        }

        public void Hacks()
        {
            for (int row = 0; row < playerBoard.GetHeight(); row++)
            {
                for (int col = 0; col < playerBoard.GetWidth(); col++)
                {
                    //if the board w/ ships has a ship, show the player an S
                    if (computerBoard.CheckIndex(col, row) != ' ')
                        playerBoard.SetIndex(col, row, 'S');
                }
            }
        }

        public bool Sunk(int yCoord, int xCoord)
        {
            char shipID = computerBoard.CheckIndex(yCoord, xCoord);
            int shipLength = 0;
            int hitCount = 0;
            Ship[] ships = GetShipArray();

            //get the length of the ship that was hit
            for (int i = 0; i < ships.GetLength(0); i++)
            {
                if (shipID == ships[i].GetID())
                    shipLength = ships[i].GetLength();
            }

            //if the ship with that ID was hit, increment the hit count
            for (int row = 0; row < playerBoard.GetHeight(); row++)
            {
                for (int col = 0; col < playerBoard.GetWidth(); col++)
                {
                    if (playerBoard.CheckIndex(row, col) == 'O' && computerBoard.CheckIndex(row, col) == shipID)
                        hitCount++;
                }
            }

            //if the ship was hit in all spots, then the ship was sunk
            if (hitCount == shipLength)
                return true;
            else
                return false;
        }

        //used for telling player what ship they sunk
        public String SunkShipType(int yCoord, int xCoord)
        {
            char shipID = computerBoard.CheckIndex(yCoord, xCoord);
            String shipType = " ";
            Ship[] ships = GetShipArray();

            //match the ID of the hit ship to the type
            for (int i = 0; i < ships.GetLength(0); i++)
            {
                if (shipID == ships[i].GetID())
                    shipType = ships[i].GetShipType();
            }

            return shipType;
        }

        public void Reset()
        {
            playerBoard.Clear();
            computerBoard.Clear();

            Start();
        }
    }
}