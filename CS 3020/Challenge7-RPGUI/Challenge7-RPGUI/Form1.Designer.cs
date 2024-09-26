
namespace Challenge7_RPGUI
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.hero1Pic = new System.Windows.Forms.PictureBox();
            this.background = new System.Windows.Forms.Panel();
            this.enemy2Pic = new System.Windows.Forms.PictureBox();
            this.enemy1Pic = new System.Windows.Forms.PictureBox();
            this.hero2Pic = new System.Windows.Forms.PictureBox();
            this.hero3Pic = new System.Windows.Forms.PictureBox();
            this.enemy3Pic = new System.Windows.Forms.PictureBox();
            this.BattleLog = new System.Windows.Forms.TextBox();
            this.heroLabel = new System.Windows.Forms.Label();
            this.hero2Name = new System.Windows.Forms.Label();
            this.hero3Name = new System.Windows.Forms.Label();
            this.hero1Name = new System.Windows.Forms.Label();
            this.hero3HealthLbl = new System.Windows.Forms.Label();
            this.enemy1Name = new System.Windows.Forms.Label();
            this.hero2HealthLbl = new System.Windows.Forms.Label();
            this.hero1HealthLbl = new System.Windows.Forms.Label();
            this.enemy1HealthLbl = new System.Windows.Forms.Label();
            this.enemy3Name = new System.Windows.Forms.Label();
            this.enemy2HealthLbl = new System.Windows.Forms.Label();
            this.enemy3HealthLbl = new System.Windows.Forms.Label();
            this.enemyHealthLabel = new System.Windows.Forms.Label();
            this.enemyLabel = new System.Windows.Forms.Label();
            this.heroHealthLabel = new System.Windows.Forms.Label();
            this.enemy2Name = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.heroMovesLbl = new System.Windows.Forms.Label();
            this.moveDescriptionBox = new System.Windows.Forms.TextBox();
            this.move2Btn = new System.Windows.Forms.Button();
            this.move3Btn = new System.Windows.Forms.Button();
            this.move1Btn = new System.Windows.Forms.Button();
            this.spriteSelectionBox = new System.Windows.Forms.GroupBox();
            this.label17 = new System.Windows.Forms.Label();
            this.sprite3Btn = new System.Windows.Forms.Button();
            this.sprite2Btn = new System.Windows.Forms.Button();
            this.sprite1Btn = new System.Windows.Forms.Button();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.viewHighScoreToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.restartToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.resetHighScoreToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.quitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            ((System.ComponentModel.ISupportInitialize)(this.hero1Pic)).BeginInit();
            this.background.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.enemy2Pic)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.enemy1Pic)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.hero2Pic)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.hero3Pic)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.enemy3Pic)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.spriteSelectionBox.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // hero1Pic
            // 
            this.hero1Pic.BackColor = System.Drawing.Color.Transparent;
            this.hero1Pic.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.hero1Pic.Image = global::Challenge7_RPGUI.Properties.Resources.Fighter;
            this.hero1Pic.Location = new System.Drawing.Point(510, 242);
            this.hero1Pic.Name = "hero1Pic";
            this.hero1Pic.Size = new System.Drawing.Size(128, 128);
            this.hero1Pic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.hero1Pic.TabIndex = 0;
            this.hero1Pic.TabStop = false;
            // 
            // background
            // 
            this.background.BackColor = System.Drawing.SystemColors.ControlDark;
            this.background.BackgroundImage = global::Challenge7_RPGUI.Properties.Resources.NightField;
            this.background.Controls.Add(this.enemy2Pic);
            this.background.Controls.Add(this.enemy1Pic);
            this.background.Controls.Add(this.hero2Pic);
            this.background.Controls.Add(this.hero3Pic);
            this.background.Controls.Add(this.enemy3Pic);
            this.background.Controls.Add(this.hero1Pic);
            this.background.Location = new System.Drawing.Point(12, 54);
            this.background.Name = "background";
            this.background.Size = new System.Drawing.Size(1450, 450);
            this.background.TabIndex = 1;
            // 
            // enemy2Pic
            // 
            this.enemy2Pic.BackColor = System.Drawing.Color.Transparent;
            this.enemy2Pic.ErrorImage = null;
            this.enemy2Pic.Image = global::Challenge7_RPGUI.Properties.Resources.Dragon;
            this.enemy2Pic.Location = new System.Drawing.Point(947, 242);
            this.enemy2Pic.Name = "enemy2Pic";
            this.enemy2Pic.Size = new System.Drawing.Size(128, 128);
            this.enemy2Pic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.enemy2Pic.TabIndex = 3;
            this.enemy2Pic.TabStop = false;
            // 
            // enemy1Pic
            // 
            this.enemy1Pic.BackColor = System.Drawing.Color.Transparent;
            this.enemy1Pic.Image = global::Challenge7_RPGUI.Properties.Resources.Bandit;
            this.enemy1Pic.Location = new System.Drawing.Point(813, 242);
            this.enemy1Pic.Name = "enemy1Pic";
            this.enemy1Pic.Size = new System.Drawing.Size(128, 128);
            this.enemy1Pic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.enemy1Pic.TabIndex = 4;
            this.enemy1Pic.TabStop = false;
            // 
            // hero2Pic
            // 
            this.hero2Pic.BackColor = System.Drawing.Color.Transparent;
            this.hero2Pic.ErrorImage = null;
            this.hero2Pic.Image = global::Challenge7_RPGUI.Properties.Resources.Mage;
            this.hero2Pic.Location = new System.Drawing.Point(376, 242);
            this.hero2Pic.Name = "hero2Pic";
            this.hero2Pic.Size = new System.Drawing.Size(128, 128);
            this.hero2Pic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.hero2Pic.TabIndex = 3;
            this.hero2Pic.TabStop = false;
            // 
            // hero3Pic
            // 
            this.hero3Pic.BackColor = System.Drawing.Color.Transparent;
            this.hero3Pic.Image = global::Challenge7_RPGUI.Properties.Resources.Cleric;
            this.hero3Pic.Location = new System.Drawing.Point(242, 242);
            this.hero3Pic.Name = "hero3Pic";
            this.hero3Pic.Size = new System.Drawing.Size(128, 128);
            this.hero3Pic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.hero3Pic.TabIndex = 2;
            this.hero3Pic.TabStop = false;
            // 
            // enemy3Pic
            // 
            this.enemy3Pic.BackColor = System.Drawing.Color.Transparent;
            this.enemy3Pic.ErrorImage = null;
            this.enemy3Pic.Image = global::Challenge7_RPGUI.Properties.Resources.Ogre;
            this.enemy3Pic.Location = new System.Drawing.Point(1081, 242);
            this.enemy3Pic.Name = "enemy3Pic";
            this.enemy3Pic.Size = new System.Drawing.Size(128, 128);
            this.enemy3Pic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.enemy3Pic.TabIndex = 1;
            this.enemy3Pic.TabStop = false;
            // 
            // BattleLog
            // 
            this.BattleLog.BackColor = System.Drawing.Color.Gainsboro;
            this.BattleLog.Location = new System.Drawing.Point(979, 510);
            this.BattleLog.Multiline = true;
            this.BattleLog.Name = "BattleLog";
            this.BattleLog.ReadOnly = true;
            this.BattleLog.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.BattleLog.Size = new System.Drawing.Size(483, 449);
            this.BattleLog.TabIndex = 2;
            // 
            // heroLabel
            // 
            this.heroLabel.AutoSize = true;
            this.heroLabel.Location = new System.Drawing.Point(57, 28);
            this.heroLabel.Name = "heroLabel";
            this.heroLabel.Size = new System.Drawing.Size(76, 32);
            this.heroLabel.TabIndex = 3;
            this.heroLabel.Text = "Heros";
            // 
            // hero2Name
            // 
            this.hero2Name.AutoSize = true;
            this.hero2Name.Location = new System.Drawing.Point(57, 134);
            this.hero2Name.Name = "hero2Name";
            this.hero2Name.Size = new System.Drawing.Size(75, 32);
            this.hero2Name.TabIndex = 4;
            this.hero2Name.Text = "Mage";
            // 
            // hero3Name
            // 
            this.hero3Name.AutoSize = true;
            this.hero3Name.Location = new System.Drawing.Point(57, 190);
            this.hero3Name.Name = "hero3Name";
            this.hero3Name.Size = new System.Drawing.Size(73, 32);
            this.hero3Name.TabIndex = 5;
            this.hero3Name.Text = "Cleric";
            // 
            // hero1Name
            // 
            this.hero1Name.AutoSize = true;
            this.hero1Name.Location = new System.Drawing.Point(57, 86);
            this.hero1Name.Name = "hero1Name";
            this.hero1Name.Size = new System.Drawing.Size(89, 32);
            this.hero1Name.TabIndex = 6;
            this.hero1Name.Text = "Fighter";
            // 
            // hero3HealthLbl
            // 
            this.hero3HealthLbl.AutoSize = true;
            this.hero3HealthLbl.Location = new System.Drawing.Point(207, 190);
            this.hero3HealthLbl.Name = "hero3HealthLbl";
            this.hero3HealthLbl.Size = new System.Drawing.Size(75, 32);
            this.hero3HealthLbl.TabIndex = 7;
            this.hero3HealthLbl.Text = "12/12";
            // 
            // enemy1Name
            // 
            this.enemy1Name.AutoSize = true;
            this.enemy1Name.Location = new System.Drawing.Point(57, 306);
            this.enemy1Name.Name = "enemy1Name";
            this.enemy1Name.Size = new System.Drawing.Size(82, 32);
            this.enemy1Name.TabIndex = 8;
            this.enemy1Name.Text = "Bandit";
            // 
            // hero2HealthLbl
            // 
            this.hero2HealthLbl.AutoSize = true;
            this.hero2HealthLbl.Location = new System.Drawing.Point(207, 134);
            this.hero2HealthLbl.Name = "hero2HealthLbl";
            this.hero2HealthLbl.Size = new System.Drawing.Size(75, 32);
            this.hero2HealthLbl.TabIndex = 9;
            this.hero2HealthLbl.Text = "10/10";
            // 
            // hero1HealthLbl
            // 
            this.hero1HealthLbl.AutoSize = true;
            this.hero1HealthLbl.Location = new System.Drawing.Point(207, 86);
            this.hero1HealthLbl.Name = "hero1HealthLbl";
            this.hero1HealthLbl.Size = new System.Drawing.Size(75, 32);
            this.hero1HealthLbl.TabIndex = 10;
            this.hero1HealthLbl.Text = "15/15";
            // 
            // enemy1HealthLbl
            // 
            this.enemy1HealthLbl.AutoSize = true;
            this.enemy1HealthLbl.Location = new System.Drawing.Point(207, 306);
            this.enemy1HealthLbl.Name = "enemy1HealthLbl";
            this.enemy1HealthLbl.Size = new System.Drawing.Size(49, 32);
            this.enemy1HealthLbl.TabIndex = 11;
            this.enemy1HealthLbl.Text = "9/9";
            // 
            // enemy3Name
            // 
            this.enemy3Name.AutoSize = true;
            this.enemy3Name.Location = new System.Drawing.Point(57, 402);
            this.enemy3Name.Name = "enemy3Name";
            this.enemy3Name.Size = new System.Drawing.Size(67, 32);
            this.enemy3Name.TabIndex = 12;
            this.enemy3Name.Text = "Ogre";
            // 
            // enemy2HealthLbl
            // 
            this.enemy2HealthLbl.AutoSize = true;
            this.enemy2HealthLbl.Location = new System.Drawing.Point(207, 356);
            this.enemy2HealthLbl.Name = "enemy2HealthLbl";
            this.enemy2HealthLbl.Size = new System.Drawing.Size(75, 32);
            this.enemy2HealthLbl.TabIndex = 13;
            this.enemy2HealthLbl.Text = "20/20";
            // 
            // enemy3HealthLbl
            // 
            this.enemy3HealthLbl.AutoSize = true;
            this.enemy3HealthLbl.Location = new System.Drawing.Point(207, 402);
            this.enemy3HealthLbl.Name = "enemy3HealthLbl";
            this.enemy3HealthLbl.Size = new System.Drawing.Size(75, 32);
            this.enemy3HealthLbl.TabIndex = 14;
            this.enemy3HealthLbl.Text = "18/18";
            // 
            // enemyHealthLabel
            // 
            this.enemyHealthLabel.AutoSize = true;
            this.enemyHealthLabel.Location = new System.Drawing.Point(207, 256);
            this.enemyHealthLabel.Name = "enemyHealthLabel";
            this.enemyHealthLabel.Size = new System.Drawing.Size(84, 32);
            this.enemyHealthLabel.TabIndex = 15;
            this.enemyHealthLabel.Text = "Health";
            // 
            // enemyLabel
            // 
            this.enemyLabel.AutoSize = true;
            this.enemyLabel.Location = new System.Drawing.Point(57, 256);
            this.enemyLabel.Name = "enemyLabel";
            this.enemyLabel.Size = new System.Drawing.Size(103, 32);
            this.enemyLabel.TabIndex = 16;
            this.enemyLabel.Text = "Enemies";
            // 
            // heroHealthLabel
            // 
            this.heroHealthLabel.AutoSize = true;
            this.heroHealthLabel.Location = new System.Drawing.Point(207, 28);
            this.heroHealthLabel.Name = "heroHealthLabel";
            this.heroHealthLabel.Size = new System.Drawing.Size(84, 32);
            this.heroHealthLabel.TabIndex = 17;
            this.heroHealthLabel.Text = "Health";
            // 
            // enemy2Name
            // 
            this.enemy2Name.AutoSize = true;
            this.enemy2Name.Location = new System.Drawing.Point(57, 356);
            this.enemy2Name.Name = "enemy2Name";
            this.enemy2Name.Size = new System.Drawing.Size(93, 32);
            this.enemy2Name.TabIndex = 18;
            this.enemy2Name.Text = "Dragon";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Controls.Add(this.hero3Name);
            this.groupBox1.Controls.Add(this.heroLabel);
            this.groupBox1.Controls.Add(this.enemy2Name);
            this.groupBox1.Controls.Add(this.hero2Name);
            this.groupBox1.Controls.Add(this.heroHealthLabel);
            this.groupBox1.Controls.Add(this.hero1Name);
            this.groupBox1.Controls.Add(this.enemyLabel);
            this.groupBox1.Controls.Add(this.hero3HealthLbl);
            this.groupBox1.Controls.Add(this.enemyHealthLabel);
            this.groupBox1.Controls.Add(this.enemy1Name);
            this.groupBox1.Controls.Add(this.enemy3HealthLbl);
            this.groupBox1.Controls.Add(this.hero2HealthLbl);
            this.groupBox1.Controls.Add(this.enemy2HealthLbl);
            this.groupBox1.Controls.Add(this.hero1HealthLbl);
            this.groupBox1.Controls.Add(this.enemy3Name);
            this.groupBox1.Controls.Add(this.enemy1HealthLbl);
            this.groupBox1.Location = new System.Drawing.Point(12, 510);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(340, 449);
            this.groupBox1.TabIndex = 19;
            this.groupBox1.TabStop = false;
            // 
            // groupBox2
            // 
            this.groupBox2.Location = new System.Drawing.Point(346, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(400, 200);
            this.groupBox2.TabIndex = 20;
            this.groupBox2.TabStop = false;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.heroMovesLbl);
            this.groupBox3.Controls.Add(this.moveDescriptionBox);
            this.groupBox3.Controls.Add(this.move2Btn);
            this.groupBox3.Controls.Add(this.move3Btn);
            this.groupBox3.Controls.Add(this.move1Btn);
            this.groupBox3.Location = new System.Drawing.Point(399, 510);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(554, 330);
            this.groupBox3.TabIndex = 20;
            this.groupBox3.TabStop = false;
            // 
            // heroMovesLbl
            // 
            this.heroMovesLbl.AutoSize = true;
            this.heroMovesLbl.Location = new System.Drawing.Point(53, 28);
            this.heroMovesLbl.Name = "heroMovesLbl";
            this.heroMovesLbl.Size = new System.Drawing.Size(204, 32);
            this.heroMovesLbl.TabIndex = 22;
            this.heroMovesLbl.Text = "Fighter\'s Moveset";
            // 
            // moveDescriptionBox
            // 
            this.moveDescriptionBox.Location = new System.Drawing.Point(274, 79);
            this.moveDescriptionBox.Multiline = true;
            this.moveDescriptionBox.Name = "moveDescriptionBox";
            this.moveDescriptionBox.Size = new System.Drawing.Size(252, 209);
            this.moveDescriptionBox.TabIndex = 4;
            // 
            // move2Btn
            // 
            this.move2Btn.Enabled = false;
            this.move2Btn.Location = new System.Drawing.Point(25, 160);
            this.move2Btn.Name = "move2Btn";
            this.move2Btn.Size = new System.Drawing.Size(226, 46);
            this.move2Btn.TabIndex = 2;
            this.move2Btn.Text = "move 2";
            this.move2Btn.UseVisualStyleBackColor = true;
            this.move2Btn.Click += new System.EventHandler(this.move2Btn_Click);
            // 
            // move3Btn
            // 
            this.move3Btn.Enabled = false;
            this.move3Btn.Location = new System.Drawing.Point(25, 242);
            this.move3Btn.Name = "move3Btn";
            this.move3Btn.Size = new System.Drawing.Size(226, 46);
            this.move3Btn.TabIndex = 1;
            this.move3Btn.Text = "move 3";
            this.move3Btn.UseVisualStyleBackColor = true;
            this.move3Btn.Click += new System.EventHandler(this.move3Btn_Click);
            // 
            // move1Btn
            // 
            this.move1Btn.Enabled = false;
            this.move1Btn.Location = new System.Drawing.Point(25, 79);
            this.move1Btn.Name = "move1Btn";
            this.move1Btn.Size = new System.Drawing.Size(226, 46);
            this.move1Btn.TabIndex = 0;
            this.move1Btn.Text = "move 1";
            this.move1Btn.UseVisualStyleBackColor = true;
            this.move1Btn.Click += new System.EventHandler(this.move1Btn_Click);
            // 
            // spriteSelectionBox
            // 
            this.spriteSelectionBox.Controls.Add(this.label17);
            this.spriteSelectionBox.Controls.Add(this.sprite3Btn);
            this.spriteSelectionBox.Controls.Add(this.sprite2Btn);
            this.spriteSelectionBox.Controls.Add(this.sprite1Btn);
            this.spriteSelectionBox.Location = new System.Drawing.Point(399, 816);
            this.spriteSelectionBox.Name = "spriteSelectionBox";
            this.spriteSelectionBox.Size = new System.Drawing.Size(554, 152);
            this.spriteSelectionBox.TabIndex = 4;
            this.spriteSelectionBox.TabStop = false;
            this.spriteSelectionBox.Visible = false;
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(25, 27);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(455, 32);
            this.label17.TabIndex = 21;
            this.label17.Text = "Who would you like to use the move on?";
            // 
            // sprite3Btn
            // 
            this.sprite3Btn.Enabled = false;
            this.sprite3Btn.Location = new System.Drawing.Point(376, 82);
            this.sprite3Btn.Name = "sprite3Btn";
            this.sprite3Btn.Size = new System.Drawing.Size(150, 46);
            this.sprite3Btn.TabIndex = 4;
            this.sprite3Btn.Text = "button6";
            this.sprite3Btn.UseVisualStyleBackColor = true;
            this.sprite3Btn.Click += new System.EventHandler(this.sprite3Btn_Click);
            // 
            // sprite2Btn
            // 
            this.sprite2Btn.Enabled = false;
            this.sprite2Btn.Location = new System.Drawing.Point(200, 83);
            this.sprite2Btn.Name = "sprite2Btn";
            this.sprite2Btn.Size = new System.Drawing.Size(150, 46);
            this.sprite2Btn.TabIndex = 5;
            this.sprite2Btn.Text = "button7";
            this.sprite2Btn.UseVisualStyleBackColor = true;
            this.sprite2Btn.Click += new System.EventHandler(this.sprite2Btn_Click);
            // 
            // sprite1Btn
            // 
            this.sprite1Btn.Enabled = false;
            this.sprite1Btn.Location = new System.Drawing.Point(25, 82);
            this.sprite1Btn.Name = "sprite1Btn";
            this.sprite1Btn.Size = new System.Drawing.Size(150, 46);
            this.sprite1Btn.TabIndex = 0;
            this.sprite1Btn.Text = "button5";
            this.sprite1Btn.UseVisualStyleBackColor = true;
            this.sprite1Btn.Click += new System.EventHandler(this.sprite1Btn_Click);
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(32, 32);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.viewHighScoreToolStripMenuItem,
            this.restartToolStripMenuItem,
            this.resetHighScoreToolStripMenuItem,
            this.quitToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1474, 40);
            this.menuStrip1.TabIndex = 21;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // viewHighScoreToolStripMenuItem
            // 
            this.viewHighScoreToolStripMenuItem.Name = "viewHighScoreToolStripMenuItem";
            this.viewHighScoreToolStripMenuItem.Size = new System.Drawing.Size(151, 36);
            this.viewHighScoreToolStripMenuItem.Text = "View Score";
            this.viewHighScoreToolStripMenuItem.Click += new System.EventHandler(this.viewHighScoreToolStripMenuItem_Click);
            // 
            // restartToolStripMenuItem
            // 
            this.restartToolStripMenuItem.Name = "restartToolStripMenuItem";
            this.restartToolStripMenuItem.Size = new System.Drawing.Size(106, 36);
            this.restartToolStripMenuItem.Text = "Restart";
            this.restartToolStripMenuItem.Click += new System.EventHandler(this.restartToolStripMenuItem_Click);
            // 
            // resetHighScoreToolStripMenuItem
            // 
            this.resetHighScoreToolStripMenuItem.Name = "resetHighScoreToolStripMenuItem";
            this.resetHighScoreToolStripMenuItem.Size = new System.Drawing.Size(215, 36);
            this.resetHighScoreToolStripMenuItem.Text = "Reset High Score";
            this.resetHighScoreToolStripMenuItem.Click += new System.EventHandler(this.resetHighScoreToolStripMenuItem_Click);
            // 
            // quitToolStripMenuItem
            // 
            this.quitToolStripMenuItem.Name = "quitToolStripMenuItem";
            this.quitToolStripMenuItem.Size = new System.Drawing.Size(80, 36);
            this.quitToolStripMenuItem.Text = "Quit";
            this.quitToolStripMenuItem.Click += new System.EventHandler(this.quitToolStripMenuItem_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(13F, 32F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1474, 985);
            this.Controls.Add(this.spriteSelectionBox);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.BattleLog);
            this.Controls.Add(this.background);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.hero1Pic)).EndInit();
            this.background.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.enemy2Pic)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.enemy1Pic)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.hero2Pic)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.hero3Pic)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.enemy3Pic)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.spriteSelectionBox.ResumeLayout(false);
            this.spriteSelectionBox.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox hero1Pic;
        private System.Windows.Forms.Panel background;
        private System.Windows.Forms.TextBox BattleLog;
        private System.Windows.Forms.PictureBox enemy3Pic;
        private System.Windows.Forms.PictureBox enemy2Pic;
        private System.Windows.Forms.PictureBox enemy1Pic;
        private System.Windows.Forms.PictureBox hero2Pic;
        private System.Windows.Forms.PictureBox hero3Pic;
        private System.Windows.Forms.Label heroLabel;
        private System.Windows.Forms.Label hero2Name;
        private System.Windows.Forms.Label hero3Name;
        private System.Windows.Forms.Label hero1Name;
        private System.Windows.Forms.Label hero3HealthLbl;
        private System.Windows.Forms.Label enemy1Name;
        private System.Windows.Forms.Label hero2HealthLbl;
        private System.Windows.Forms.Label hero1HealthLbl;
        private System.Windows.Forms.Label enemy1HealthLbl;
        private System.Windows.Forms.Label enemy3Name;
        private System.Windows.Forms.Label enemy2HealthLbl;
        private System.Windows.Forms.Label enemy3HealthLbl;
        private System.Windows.Forms.Label enemyHealthLabel;
        private System.Windows.Forms.Label enemyLabel;
        private System.Windows.Forms.Label heroHealthLabel;
        private System.Windows.Forms.Label enemy2Name;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button move2Btn;
        private System.Windows.Forms.Button move3Btn;
        private System.Windows.Forms.Button move1Btn;
        private System.Windows.Forms.GroupBox spriteSelectionBox;
        private System.Windows.Forms.Button sprite3Btn;
        private System.Windows.Forms.Button sprite2Btn;
        private System.Windows.Forms.Button sprite1Btn;
        private System.Windows.Forms.Label heroMovesLbl;
        private System.Windows.Forms.TextBox moveDescriptionBox;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem viewHighScoreToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem restartToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem quitToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem resetHighScoreToolStripMenuItem;
    }
}

