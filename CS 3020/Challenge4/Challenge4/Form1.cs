using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Challenge4
{
    public partial class Form1 : Form
    {
        Color disabledColor;
        int countdownStart = 10;
        public Form1()
        {
            InitializeComponent();
            Countdown.Interval = 1000;
            //Countdown.Tick = Countdown.Interval;
            disabledColor = fireButton.BackColor;
            yCoord.TextChanged += CheckTextboxesHandler;
            xCoord.TextChanged += CheckTextboxesHandler;
            password.TextChanged += CheckTextboxesHandler;
        }

        public void CountdownTickHandler(object sender, EventArgs e)
        {
            countdownStart--;
        }

        public void CheckTextboxesHandler(object sender, EventArgs e)
        {
            ActivateFireBtn();
        }

        public void ActivateFireBtn()
        {
            if (IsLatValid() && IsLonValid() && IsAuthValid())
            {
                fireButton.Enabled = true;
                fireButton.BackColor = Color.Red;
            }
            else
            {
                fireButton.Enabled = false;
                fireButton.BackColor = disabledColor;
            }
        }

        public bool IsLatValid()
        {
            return yCoord.Text.Length > 6 ? true : false;
        }

        public bool IsLonValid()
        {
            return xCoord.Text.Length > 6 ? true : false;
        }

        public bool IsAuthValid()
        {
            return password.Text.Length > 8 ? true : false;
        }

        private void fireButton_Click(object sender, EventArgs e)
        {
            var result = MessageBox.Show($"Are you sure you want to nuke lat: " +
                $"{yCoord.Text} lon: {xCoord.Text}?", "Warning", 
                MessageBoxButtons.YesNo, MessageBoxIcon.Exclamation);

            if(result == DialogResult.Yes)
            {
                abortButton.Visible = true;
                //Timer.Start();
            }
        }
    }
}
