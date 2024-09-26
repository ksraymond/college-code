using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MoreMinesweeperPractice
{
    public partial class Form1 : Form
    {
        Cell[,] grid = new Cell[30, 16];
        Random rand = new Random();

        public Form1()
        {
            InitializeComponent();
            InitializeGrid();
            ChangeSize();
        }

        //use this method to change the size of the window dynamically
        //so that the timer is always shown
        //make sure that autosize is turned off
        public void ChangeSize()
        {
            this.Size = new Size(40, 1100);
        }

        private void InitializeGrid()
        {
            for (int row = 0; row < grid.GetLength(1); row++)
            {
                for (int col = 0; col < grid.GetLength(0); col++)
                {
                    Cell temp = new Cell();
                    temp.Location = new Point(col * temp.Size.Width, row * temp.Size.Height);
                    temp.Col = col;
                    temp.Row = row;
                    temp.CellColor = (rand.Next(2) % 2 == 0) ? Color.MediumOrchid : Color.Wheat;
                    temp.OnCellClick += OnCellClick;
                    this.Controls.Add(temp);
                    grid[col, row] = temp;
                }
            }
        }

        public void OnCellClick(object sender, EventArgs e)
        {
            Color targetColor = ((Cell)sender).CellColor;
            int row = ((Cell)sender).Row;
            int col = ((Cell)sender).Col;
            CheckLeft(targetColor, row, col);
            CheckRight(targetColor, row, col);
        }

        private void CheckRight(Color targetColor, int row, int col)
        {
            if (col < grid.GetLength(0) - 1)
            {
                if (grid[col + 1, row].CellColor == targetColor)
                {
                    grid[col + 1, row].MyButton.PerformClick();
                }
            }
        }

        private void CheckLeft(Color targetColor, int row, int col)
        {
            if (col > 0)
            {
                if (grid[col - 1, row].CellColor == targetColor)
                {
                    grid[col - 1, row].MyButton.PerformClick();
                }
            }
        }
    }
}
