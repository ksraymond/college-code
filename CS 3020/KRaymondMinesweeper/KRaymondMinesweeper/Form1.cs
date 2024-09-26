using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KRaymondMinesweeper
{
    public partial class Form1 : Form
    {
        int bombs = 0;
        Random rand = new Random();
        bool firstClick = true;
        int wins = 0;
        int losses = 0;
        int runtime = 0;
        int totalTime = 0; //used to compute average time
        Cell[,] grid;

        public Form1()
        {
            InitializeComponent();
            grid = new Cell[10, 10]; //default to easy settings
            bombs = 10;
            timer.Interval = 1000;
            timer.Tick += OnTimerTick;
            InitializeGrid();
            AutoSizeWindow();
            ReadStats();
            bombsLeftLbl.Text = $"Bombs Left: {bombs}";
        }

        #region board/window functions
        //load in the grid of buttons
        private void InitializeGrid()
        {
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    Cell temp = new Cell();
                    temp.Location = new Point(col * temp.Size.Width, (row * temp.Size.Height)+50);
                    temp.Col = col;
                    temp.Row = row;
                    temp.OnCellClick += OnCellClick;
                    temp.OnCellRightClick += OnCellRightClick;
                    this.Controls.Add(temp);
                    temp.SetEmpty();
                    grid[col, row] = temp;
                }
            }
        }

        //place the set amount of bombs on the board, check to make sure there isn't already a bomb there
        private void PlaceBombs(int col, int row)
        {
            for (int i = 0; i < bombs; i++)
            {
                int randRow = rand.Next(grid.GetLength(1));
                int randCol = rand.Next(grid.GetLength(0));

                if (!grid[randCol, randRow].IsBomb() && grid[randCol, randRow] != grid[col, row])
                    grid[randCol, randRow].SetBomb();
                else
                    i--;
            }
            PlaceNumbers();
        }

        //check every cell on the board, if there are bombs surrounding it make that a number
        private void PlaceNumbers()
        {
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    int bombCount = 0;

                    //check right
                    if (col < grid.GetLength(0) - 1 && !grid[col, row].IsBomb())
                    {
                        if (grid[col + 1, row].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check left
                    if (col > 0 && !grid[col, row].IsBomb())
                    {
                        if (grid[col - 1, row].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check bottom
                    if (row < grid.GetLength(1) - 1 && !grid[col, row].IsBomb())
                    {
                        if (grid[col, row + 1].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check top
                    if (row > 0 && !grid[col, row].IsBomb())
                    {
                        if (grid[col, row - 1].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check bottom right diag
                    if (col < grid.GetLength(0) - 1 && row < grid.GetLength(1) - 1 && !grid[col, row].IsBomb())
                    {
                        if (grid[col + 1, row + 1].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check top right diag
                    if (col < grid.GetLength(0) - 1 && row > 0 && !grid[col, row].IsBomb())
                    {
                        if (grid[col + 1, row - 1].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check bottom left diag
                    if (col > 0 && row < grid.GetLength(1) - 1 && !grid[col, row].IsBomb())
                    {
                        if (grid[col - 1, row + 1].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    //check top left diag
                    if (col > 0 && row > 0 && !grid[col, row].IsBomb())
                    {
                        if (grid[col - 1, row - 1].IsBomb())
                        {
                            bombCount++;
                        }
                    }

                    if (bombCount != 0)
                    {
                        grid[col, row].SetMinesweeperNum(bombCount);
                    }
                }
            }
        }

        //change the size of the window automatically (for changing difficulty)
        private void AutoSizeWindow()
        {
            int width = grid.GetLength(0)*40;
            int height = (grid.GetLength(1)*40)+125;
            this.Size = new Size(width, height);
        }

        //run when changing difficulty or restarting to reset all cells and variables
        private void ResetBoard()
        {
            //reset variables
            firstClick = true;
            timer.Stop();
            runtime = 0;
            timerLbl.Text = $"Timer: {runtime}";
            bombsLeftLbl.Text = $"Bombs Left: {bombs}";

            //reset buttons
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    grid[col, row].MyButton.Visible = true;
                    grid[col, row].SetEmpty();
                    grid[col, row].MyButton.Enabled = true;
                    grid[col, row].UnFlag();
                }
            }
        }
        #endregion

        #region handlers
        //handler for timer tick
        public void OnTimerTick(object sender, EventArgs e)
        {
            runtime++;
            timerLbl.Text = $"Timer: {runtime}";
        }

        //handler for when cell is clicked
        public void OnCellClick(object sender, EventArgs e)
        {
            int row = ((Cell)sender).Row;
            int col = ((Cell)sender).Col;

            if (firstClick && !grid[col, row].IsFlag())
            {
                firstClick = false;
                PlaceBombs(col, row);
                timer.Start();
            }

            if(grid[col, row].IsEmpty() && !grid[col, row].IsFlag())
            {
                CascadeEmpty(col, row);
            }

            if (IsWin(col, row) && !grid[col, row].IsFlag())
            {
                wins++;
                MessageBox.Show("You win!");
                GameOver();
            }
            
            if (IsLoss(col, row) && !grid[col, row].IsFlag())
            {
                losses++;
                MessageBox.Show("You lost.\nBetter luck next time!");
                GameOver();
            }
            
        }

        //handler for right click flag event
        public void OnCellRightClick(object sender, MouseEventArgs e)
        {
            int col = ((Cell)sender).Col;
            int row = ((Cell)sender).Row;
            if(e.Button == MouseButtons.Right)
            {
                if (!grid[col, row].IsFlag())
                    grid[col, row].SetFlag();
                else
                    grid[col, row].UnFlag();
            }
            UpdateBombsLeft();
        }
        #endregion

        #region game functions
        //run when user either wins or loses
        public void GameOver()
        {
            DisableBoard();
            timer.Stop();
            totalTime += runtime;
            WriteStats();
        }

        //check to see if the user won
        private bool IsWin(int cellCol, int cellRow)
        {
            bool isClear = false;
            int cellsLeft = 0;

            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    if (grid[col, row].MyButton.Visible)
                        cellsLeft++;
                }
            }

            if (cellsLeft == bombs)
                isClear = true;

            if (!grid[cellCol, cellRow].IsBomb() && isClear)
                return true;
            else
                return false;
        }

        //check to see if the user lost
        private bool IsLoss(int col, int row)
        {
            if (grid[col, row].IsBomb())
                return true;
            else
                return false;
        }

        //when player lost or won disable the buttons
        private void DisableBoard()
        {
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    grid[col, row].MyButton.Enabled = false;
                }
            }
        }

        //get the cascade effect when the user clicks an empty cell
        private void CascadeEmpty(int col, int row)
        {
            //click right
            if(col < grid.GetLength(0) - 1)
                grid[col + 1, row].MyButton.PerformClick();

            //click left
            if(col > 0)
                grid[col - 1, row].MyButton.PerformClick();

            //click bottom
            if(row < grid.GetLength(1) - 1)
                grid[col, row + 1].MyButton.PerformClick();

            //click top
            if (row > 0)
                grid[col, row - 1].MyButton.PerformClick();

            //click bottom right diag
            if (col < grid.GetLength(0) - 1 && row < grid.GetLength(1) - 1)
                grid[col + 1, row + 1].MyButton.PerformClick();

            //click top right diag
            if (col < grid.GetLength(0) - 1 && row > 0)
                grid[col + 1, row - 1].MyButton.PerformClick();

            //click bottom left diag
            if (col > 0 && row < grid.GetLength(1) - 1)
                grid[col - 1, row + 1].MyButton.PerformClick();

            //click top left diag
            if (col > 0 && row > 0)
                grid[col - 1, row - 1].MyButton.PerformClick();
        }

        //update the label on the status strip telling user how many bombs are left
        private void UpdateBombsLeft()
        {
            int bombsLeft = bombs;
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    if (grid[col, row].IsFlag())
                        bombsLeft--;
                }
            }
            bombsLeftLbl.Text = $"Bombs Left: {bombsLeft}";
        }
        #endregion

        #region read/write stats
        //each time program is opened, read in the stats
        private void ReadStats()
        {
            StreamReader reader = new StreamReader("SaveData.txt");
            try
            {
                wins = int.Parse(reader.ReadLine());
                losses = int.Parse(reader.ReadLine());
                totalTime = int.Parse(reader.ReadLine());
            } 
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                reader.Close();
            }
            
        }

        //write the new stats
        private void WriteStats()
        {
            StreamWriter writer = new StreamWriter("SaveData.txt");
            try
            {
                writer.WriteLine(wins);
                writer.WriteLine(losses);
                writer.WriteLine(totalTime);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                writer.Close();
            }
        }
        #endregion

        #region changing difficulty
        private void beginnerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //given beginner parameters
            bombs = 10;
            ChangeDifficulty(10, 10);
        }

        private void intermediateToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //standard parameters for intermediate
            bombs = 40;
            ChangeDifficulty(16, 16);
        }

        private void expertToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //standard parameters for expert
            bombs = 99;
            ChangeDifficulty(30, 16);
        }

        private void ChangeDifficulty(int width, int height)
        {
            ResetBoard();

            //erase all buttons from controls and handlers
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    Cell temp = grid[col, row];
                    temp.OnCellClick -= OnCellClick;
                    temp.OnCellRightClick -= OnCellRightClick;
                    this.Controls.Remove(temp);
                }
            }

            grid = new Cell[width, height];
            InitializeGrid();
            AutoSizeWindow();
        }
        #endregion

        #region game buttons
        private void restartToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ResetBoard();
        }
        
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        //view lifetime stats
        private void viewStatisticsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            int averageTime = 0;
            double winLossRatio = 0;
            int gamesPlayed = wins + losses;

            if (gamesPlayed > 0)
                averageTime = totalTime / gamesPlayed;

            if (losses == 0)
                winLossRatio = wins;
            else
                winLossRatio = (double)wins / (double)losses;

            MessageBox.Show($"Wins: {wins}" +
                $"\nLosses: {losses}" +
                $"\nWin/Loss Ratio: {Math.Round(winLossRatio, 2)}" +
                $"\nAverage Time Per Game: {averageTime}");
        }

        //reset lifetime stats
        private void resetStatisticsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            wins = losses = totalTime = 0;
            WriteStats();
        }
        #endregion

        #region help buttons
        private void instructionsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("-Click on any box to start" +
                "\n-The number in the box represents the number of mines surrounding that box" +
                "\n-If you have found a cell that contains a bomb, you can right click to flag it" +
                "\n-Flagged bombs cannot be clicked, but you can right click again to unflag the cell" +
                "\n-There is a counter on the bottom that will tell you how many bombs still remain to be found" +
                "\n-The goal of the game is to uncover all of the cells EXCEPT the mines");
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Coded By: Keaton Raymond" +
                "\n Submitted on: November 5th, 2021" +
                "\n For: CS 3020");
        }
        #endregion
    }
}
