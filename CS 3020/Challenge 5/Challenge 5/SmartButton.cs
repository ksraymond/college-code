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
    //right click, add, instead of doing class do user control
    public partial class SmartButton : UserControl
    {
        Button myButton;
        int x;
        int y;

        public SmartButton()
        {
            InitializeComponent();
            this.Controls.Add(myButton);
        }

        public Button MyButton { get => myButton; set => myButton = value; }
        public int X { get => x; set => x = value; }
        public int Y { get => y; set => y = value; }
    }
}
