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

namespace MinesweeperMenuPractice
{
    public partial class Form1 : Form
    {
        int runtime = 0;
        public Form1()
        {
            InitializeComponent();
            timer.Interval = 1000;
            timer.Start(); //for minesweeper dont put it here, put it where they press start
            timer.Tick += OnTimerTick;
        }

        public void OnTimerTick(object sender, EventArgs e)
        {
            runtime++;
            TimerLbl.Text = $"Timer: {runtime}";
        }

        private void quitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void saveBtn_Click(object sender, EventArgs e)
        {
            StreamWriter writer = new StreamWriter("SaveData.txt");
            try
            {
                writer.WriteLine("it works!");
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
    }
}
