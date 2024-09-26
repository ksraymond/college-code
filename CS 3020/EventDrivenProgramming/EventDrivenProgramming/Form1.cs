using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EventDrivenProgramming
{
    public partial class Form1 : Form
    {

        Random rand = new Random();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //display message on button click
            MessageBox.Show("You clicked the button");
            //change location of the window
            this.Location = new Point(rand.Next(0, this.Location.X + 300), 
                                      rand.Next(0, this.Location.Y + 300));
        }

        private void button1_MouseEnter(object sender, EventArgs e)
        {
        //    this.Location = new Point(rand.Next(0, this.Location.X + 300),
        //                              rand.Next(0, this.Location.Y + 300));
        }
    }
}
