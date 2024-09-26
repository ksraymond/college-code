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
    public partial class Cell : UserControl
    {

        public EventHandler OnCellClick;

        Panel myPanel;
        Button myButton;
        Size cellSize = new Size(35, 35);
        int row;
        int col;

        public Cell()
        {
            InitializeComponent();
            this.Size = cellSize;
            this.Padding = new Padding(0);
            SetButton();
            SetPanel();
        }

        public int Col { get => col; set => col = value; }
        public int Row { get => row; set => row = value; }

        public Color CellColor { get => myPanel.BackColor; set => myPanel.BackColor = value; }
        public Button MyButton { get => myButton; }

        private void SetButton()
        {
            myButton = new Button();
            myButton.Size = this.Size;
            myButton.Location = this.Location; //making sure the button is on the panel in the right spot
            myButton.BackColor = DefaultBackColor;
            this.Controls.Add(myButton);
            myButton.Click += OnButtonClick;
        }

        private void SetPanel()
        {
            myPanel = new Panel();
            myPanel.Size = this.Size;
            myPanel.Location = this.Location;
            myPanel.BackColor = Color.Cyan;
            this.Controls.Add(myPanel);
        }

        public void OnButtonClick(object sender, EventArgs e)
        {
            ((Button)sender).Visible = false;
            if(OnCellClick != null)
            {
                OnCellClick(this, EventArgs.Empty);
            }
        }
    }
}
