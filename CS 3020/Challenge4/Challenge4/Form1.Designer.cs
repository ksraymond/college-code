
namespace Challenge4
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.yCoord = new System.Windows.Forms.TextBox();
            this.CoordsGroup = new System.Windows.Forms.GroupBox();
            this.Latitude = new System.Windows.Forms.Label();
            this.Longitude = new System.Windows.Forms.Label();
            this.xCoord = new System.Windows.Forms.TextBox();
            this.passwordBox = new System.Windows.Forms.GroupBox();
            this.password = new System.Windows.Forms.TextBox();
            this.fireButton = new System.Windows.Forms.Button();
            this.Countdown = new System.Windows.Forms.Timer(this.components);
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.Timer = new System.Windows.Forms.ToolStripStatusLabel();
            this.abortButton = new System.Windows.Forms.Button();
            this.CoordsGroup.SuspendLayout();
            this.passwordBox.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // yCoord
            // 
            this.yCoord.Location = new System.Drawing.Point(113, 37);
            this.yCoord.Name = "yCoord";
            this.yCoord.Size = new System.Drawing.Size(159, 26);
            this.yCoord.TabIndex = 0;
            // 
            // CoordsGroup
            // 
            this.CoordsGroup.Controls.Add(this.xCoord);
            this.CoordsGroup.Controls.Add(this.Longitude);
            this.CoordsGroup.Controls.Add(this.Latitude);
            this.CoordsGroup.Controls.Add(this.yCoord);
            this.CoordsGroup.Location = new System.Drawing.Point(12, 12);
            this.CoordsGroup.Name = "CoordsGroup";
            this.CoordsGroup.Size = new System.Drawing.Size(298, 144);
            this.CoordsGroup.TabIndex = 1;
            this.CoordsGroup.TabStop = false;
            this.CoordsGroup.Text = "Target Coordinates";
            // 
            // Latitude
            // 
            this.Latitude.AutoSize = true;
            this.Latitude.Location = new System.Drawing.Point(19, 37);
            this.Latitude.Name = "Latitude";
            this.Latitude.Size = new System.Drawing.Size(67, 20);
            this.Latitude.TabIndex = 1;
            this.Latitude.Text = "Latitude";
            // 
            // Longitude
            // 
            this.Longitude.AutoSize = true;
            this.Longitude.Location = new System.Drawing.Point(23, 87);
            this.Longitude.Name = "Longitude";
            this.Longitude.Size = new System.Drawing.Size(80, 20);
            this.Longitude.TabIndex = 2;
            this.Longitude.Text = "Longitude";
            // 
            // xCoord
            // 
            this.xCoord.Location = new System.Drawing.Point(113, 87);
            this.xCoord.Name = "xCoord";
            this.xCoord.Size = new System.Drawing.Size(159, 26);
            this.xCoord.TabIndex = 3;
            // 
            // passwordBox
            // 
            this.passwordBox.Controls.Add(this.password);
            this.passwordBox.Location = new System.Drawing.Point(12, 172);
            this.passwordBox.Name = "passwordBox";
            this.passwordBox.Size = new System.Drawing.Size(298, 85);
            this.passwordBox.TabIndex = 4;
            this.passwordBox.TabStop = false;
            this.passwordBox.Text = "Authorization Code";
            // 
            // password
            // 
            this.password.Location = new System.Drawing.Point(6, 42);
            this.password.Name = "password";
            this.password.PasswordChar = '*';
            this.password.Size = new System.Drawing.Size(286, 26);
            this.password.TabIndex = 0;
            // 
            // fireButton
            // 
            this.fireButton.BackColor = System.Drawing.Color.Transparent;
            this.fireButton.Enabled = false;
            this.fireButton.Location = new System.Drawing.Point(395, 23);
            this.fireButton.Name = "fireButton";
            this.fireButton.Size = new System.Drawing.Size(329, 217);
            this.fireButton.TabIndex = 5;
            this.fireButton.Text = "Fire";
            this.fireButton.UseVisualStyleBackColor = false;
            this.fireButton.Click += new System.EventHandler(this.fireButton_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.Timer});
            this.statusStrip1.Location = new System.Drawing.Point(0, 372);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(800, 32);
            this.statusStrip1.TabIndex = 6;
            this.statusStrip1.Text = "Timer";
            // 
            // Timer
            // 
            this.Timer.Name = "Timer";
            this.Timer.Size = new System.Drawing.Size(56, 25);
            this.Timer.Text = "Timer";
            // 
            // abortButton
            // 
            this.abortButton.Enabled = false;
            this.abortButton.Location = new System.Drawing.Point(395, 268);
            this.abortButton.Name = "abortButton";
            this.abortButton.Size = new System.Drawing.Size(329, 93);
            this.abortButton.TabIndex = 7;
            this.abortButton.Text = "Abort";
            this.abortButton.UseVisualStyleBackColor = true;
            this.abortButton.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 404);
            this.Controls.Add(this.abortButton);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.fireButton);
            this.Controls.Add(this.passwordBox);
            this.Controls.Add(this.CoordsGroup);
            this.Name = "Form1";
            this.Text = "Form1";
            this.CoordsGroup.ResumeLayout(false);
            this.CoordsGroup.PerformLayout();
            this.passwordBox.ResumeLayout(false);
            this.passwordBox.PerformLayout();
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox yCoord;
        private System.Windows.Forms.GroupBox CoordsGroup;
        private System.Windows.Forms.Label Longitude;
        private System.Windows.Forms.Label Latitude;
        private System.Windows.Forms.TextBox xCoord;
        private System.Windows.Forms.GroupBox passwordBox;
        private System.Windows.Forms.TextBox password;
        private System.Windows.Forms.Button fireButton;
        private System.Windows.Forms.Timer Countdown;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel Timer;
        private System.Windows.Forms.Button abortButton;
    }
}

