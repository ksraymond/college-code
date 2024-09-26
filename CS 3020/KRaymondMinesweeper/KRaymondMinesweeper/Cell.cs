using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KRaymondMinesweeper
{
    public partial class Cell : UserControl
    {
        public EventHandler OnCellClick;
        public MouseEventHandler OnCellRightClick;

        Image minesweeper1 = new Bitmap("Minesweeper1.png");
        Image minesweeper2 = new Bitmap("Minesweeper2.png");
        Image minesweeper3 = new Bitmap("Minesweeper3.png");
        Image minesweeper4 = new Bitmap("Minesweeper4.png");
        Image minesweeper5 = new Bitmap("Minesweeper5.png");
        Image minesweeper6 = new Bitmap("Minesweeper6.png");
        Image minesweeper7 = new Bitmap("Minesweeper7.png");
        Image minesweeper8 = new Bitmap("Minesweeper8.png");
        Image minesweeperFlag = new Bitmap("MinesweeperFlag.png");
        Image minesweeperBomb = new Bitmap("MinesweeperBomb.png");
        Image minesweeperEmpty = new Bitmap("MinesweeperEmpty.png");

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
        public Button MyButton { get => myButton; }
        public Panel MyPanel { get => myPanel; }

        private void SetButton()
        {
            myButton = new Button();
            myButton.Size = this.Size;
            myButton.Location = this.Location; //making sure the button is on the panel in the right spot
            myButton.BackColor = DefaultBackColor;
            this.Controls.Add(myButton);
            myButton.Click += OnButtonClick;
            myButton.MouseUp += OnButtonRightClick;
        }

        private void SetPanel()
        {
            myPanel = new Panel();
            myPanel.Size = this.Size;
            myPanel.Location = this.Location;
            this.Controls.Add(myPanel);
        }

        #region left/right click handlers
        public void OnButtonClick(object sender, EventArgs e)
        {
            if(((Button)sender).BackgroundImage != minesweeperFlag)
                ((Button)sender).Visible = false;
            if (OnCellClick != null)
                OnCellClick(this, EventArgs.Empty);
        }
        public void OnButtonRightClick(object sender, MouseEventArgs e)
        {
            if (OnCellRightClick != null)
                OnCellRightClick(this, e);
        }
        #endregion

        #region set back images
        public void SetMinesweeperNum(int num)
        {
            myPanel.BackgroundImage = new Bitmap($"Minesweeper{num}.png");
        }

        public void SetFlag()
        {
            myButton.BackgroundImage = minesweeperFlag;
        }

        public void UnFlag()
        {
            myButton.BackgroundImage = default;
        }

        public void SetBomb()
        {
            myPanel.BackgroundImage = minesweeperBomb;
        }

        public void SetEmpty()
        {
            myPanel.BackgroundImage = minesweeperEmpty;
        }
        #endregion

        #region check back images
        public bool IsBomb()
        {
            if (myPanel.BackgroundImage == minesweeperBomb)
                return true;
            else
                return false;
        }
        
        public bool IsEmpty()
        {
            if (myPanel.BackgroundImage == minesweeperEmpty)
                return true;
            else
                return false;
        }

        public bool IsFlag()
        {
            if (myButton.BackgroundImage == minesweeperFlag)
                return true;
            else
                return false;
        }
        #endregion
    }
}
