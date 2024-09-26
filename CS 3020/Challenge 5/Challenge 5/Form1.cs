using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Challenge_5
{
    //Keaton Raymond
    //CS 3020
    public partial class Form1 : Form
    {
        Random rand = new Random();
        int buttonSize = 64;
        Button[,] buttons = new Button[10, 10];
        public Form1()
        {
            InitializeComponent();
            LoadButtons();
        }

        private void LoadButtons()
        {
            for (int row = 0; row < buttons.GetLength(0); row++)
            {
                for (int col = 0; col < buttons.GetLength(1); col++)
                {
                    Button temp = new Button();
                    temp.Size = new Size(buttonSize, buttonSize);
                    temp.Location = new Point(col*buttonSize, row*buttonSize);
                    temp.BackColor = ((row+col)%2==0)?Color.CornflowerBlue:Color.Fuchsia;
                    temp.FlatStyle = FlatStyle.Flat;
                    temp.Click += SpecialOnClickHandler;
                    this.Controls.Add(temp);
                    buttons[col, row] = temp;
                }
            }
        }

        public void OnClickHandler(object sender, EventArgs e)
        {
            Button clickedBtn = (Button)sender;
            Color targetColor = clickedBtn.BackColor;
            Color newColor = Color.FromArgb(rand.Next(256), rand.Next(256), rand.Next(256));

            for (int row = 0; row < buttons.GetLength(0); row++)
            {
                for (int col = 0; col < buttons.GetLength(1); col++)
                {
                    if(buttons[col, row].BackColor == targetColor)
                    {
                        buttons[col, row].BackColor = newColor;
                    }
                }
            }
        }

        public void SpecialOnClickHandler(object sender, EventArgs e)
        {
            Button clickedBtn = (Button)sender;
            Color targetColor = clickedBtn.BackColor;
            Color newColor = Color.FromArgb(rand.Next(256), rand.Next(256), rand.Next(256));
            clickedBtn.BackColor = newColor;

            for (int row = 0; row < buttons.GetLength(0); row++)
            {
                for (int col = 0; col < buttons.GetLength(1); col++)
                {
                    if (buttons[col, row].BackColor == targetColor)
                    {
                        buttons[col, row].PerformClick();
                    }
                }
            }
        }
    }
}
