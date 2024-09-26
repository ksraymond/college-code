
namespace RaymondKA2
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.orderBox = new System.Windows.Forms.GroupBox();
            this.descendingButton = new System.Windows.Forms.RadioButton();
            this.ascendingButton = new System.Windows.Forms.RadioButton();
            this.filterBox = new System.Windows.Forms.GroupBox();
            this.ratingFilter = new System.Windows.Forms.RadioButton();
            this.cupsFilter = new System.Windows.Forms.RadioButton();
            this.vitaminFilter = new System.Windows.Forms.RadioButton();
            this.weightFilter = new System.Windows.Forms.RadioButton();
            this.fiberFilter = new System.Windows.Forms.RadioButton();
            this.shelfLifeFilter = new System.Windows.Forms.RadioButton();
            this.potassFilter = new System.Windows.Forms.RadioButton();
            this.sodiumFilter = new System.Windows.Forms.RadioButton();
            this.fatFilter = new System.Windows.Forms.RadioButton();
            this.proteinFilter = new System.Windows.Forms.RadioButton();
            this.caloriesFilter = new System.Windows.Forms.RadioButton();
            this.sugarFilter = new System.Windows.Forms.RadioButton();
            this.typeFilter = new System.Windows.Forms.RadioButton();
            this.mfrFilter = new System.Windows.Forms.RadioButton();
            this.carbFilter = new System.Windows.Forms.RadioButton();
            this.nameFilter = new System.Windows.Forms.RadioButton();
            this.customSearchBox = new System.Windows.Forms.GroupBox();
            this.searchButton = new System.Windows.Forms.Button();
            this.ratingLabel = new System.Windows.Forms.Label();
            this.cupsLabel = new System.Windows.Forms.Label();
            this.weightLabel = new System.Windows.Forms.Label();
            this.shelfLifeLabel = new System.Windows.Forms.Label();
            this.vitaminLabel = new System.Windows.Forms.Label();
            this.potassLabel = new System.Windows.Forms.Label();
            this.sugarLabel = new System.Windows.Forms.Label();
            this.carbsLabel = new System.Windows.Forms.Label();
            this.fiberLabel = new System.Windows.Forms.Label();
            this.ratingMax = new System.Windows.Forms.TextBox();
            this.sodiumLabel = new System.Windows.Forms.Label();
            this.cupsMax = new System.Windows.Forms.TextBox();
            this.weightMax = new System.Windows.Forms.TextBox();
            this.proteinLabel = new System.Windows.Forms.Label();
            this.fatLabel = new System.Windows.Forms.Label();
            this.shelfLifeMax = new System.Windows.Forms.TextBox();
            this.vitaminsMax = new System.Windows.Forms.TextBox();
            this.potassMax = new System.Windows.Forms.TextBox();
            this.sugarMax = new System.Windows.Forms.TextBox();
            this.carbsMax = new System.Windows.Forms.TextBox();
            this.ratingMin = new System.Windows.Forms.TextBox();
            this.cupsMin = new System.Windows.Forms.TextBox();
            this.weightMin = new System.Windows.Forms.TextBox();
            this.shelfLifeMin = new System.Windows.Forms.TextBox();
            this.vitaminsMin = new System.Windows.Forms.TextBox();
            this.potassMin = new System.Windows.Forms.TextBox();
            this.sugarMin = new System.Windows.Forms.TextBox();
            this.carbsMin = new System.Windows.Forms.TextBox();
            this.fiberMax = new System.Windows.Forms.TextBox();
            this.fiberMin = new System.Windows.Forms.TextBox();
            this.sodiumMax = new System.Windows.Forms.TextBox();
            this.sodiumMin = new System.Windows.Forms.TextBox();
            this.fatMax = new System.Windows.Forms.TextBox();
            this.fatMin = new System.Windows.Forms.TextBox();
            this.proteinMin = new System.Windows.Forms.TextBox();
            this.caloriesMax = new System.Windows.Forms.TextBox();
            this.caloriesMin = new System.Windows.Forms.TextBox();
            this.caloriesLabel = new System.Windows.Forms.Label();
            this.maxLabel = new System.Windows.Forms.Label();
            this.minLabel = new System.Windows.Forms.Label();
            this.proteinMax = new System.Windows.Forms.TextBox();
            this.typeLabel = new System.Windows.Forms.Label();
            this.typeInput = new System.Windows.Forms.TextBox();
            this.mfrLabel = new System.Windows.Forms.Label();
            this.mfrInput = new System.Windows.Forms.TextBox();
            this.nameLabel = new System.Windows.Forms.Label();
            this.nameInput = new System.Windows.Forms.TextBox();
            this.resetButton = new System.Windows.Forms.Button();
            this.cerealTable = new System.Windows.Forms.DataGridView();
            this.toggleSortFilter = new System.Windows.Forms.RadioButton();
            this.toggleCustomSearch = new System.Windows.Forms.RadioButton();
            this.toggleBox = new System.Windows.Forms.GroupBox();
            this.titleLabel = new System.Windows.Forms.Label();
            this.descriptionLabel = new System.Windows.Forms.Label();
            this.orderBox.SuspendLayout();
            this.filterBox.SuspendLayout();
            this.customSearchBox.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cerealTable)).BeginInit();
            this.toggleBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // orderBox
            // 
            this.orderBox.BackColor = System.Drawing.Color.LightSlateGray;
            this.orderBox.Controls.Add(this.descendingButton);
            this.orderBox.Controls.Add(this.ascendingButton);
            this.orderBox.Enabled = false;
            this.orderBox.Location = new System.Drawing.Point(36, 281);
            this.orderBox.Name = "orderBox";
            this.orderBox.Size = new System.Drawing.Size(200, 100);
            this.orderBox.TabIndex = 0;
            this.orderBox.TabStop = false;
            this.orderBox.Text = "Order By:";
            // 
            // descendingButton
            // 
            this.descendingButton.AutoSize = true;
            this.descendingButton.Location = new System.Drawing.Point(6, 55);
            this.descendingButton.Name = "descendingButton";
            this.descendingButton.Size = new System.Drawing.Size(119, 24);
            this.descendingButton.TabIndex = 1;
            this.descendingButton.TabStop = true;
            this.descendingButton.Text = "Descending";
            this.descendingButton.UseVisualStyleBackColor = true;
            // 
            // ascendingButton
            // 
            this.ascendingButton.AutoSize = true;
            this.ascendingButton.Location = new System.Drawing.Point(6, 25);
            this.ascendingButton.Name = "ascendingButton";
            this.ascendingButton.Size = new System.Drawing.Size(109, 24);
            this.ascendingButton.TabIndex = 0;
            this.ascendingButton.TabStop = true;
            this.ascendingButton.Text = "Ascending";
            this.ascendingButton.UseVisualStyleBackColor = true;
            // 
            // filterBox
            // 
            this.filterBox.BackColor = System.Drawing.Color.LightSlateGray;
            this.filterBox.Controls.Add(this.ratingFilter);
            this.filterBox.Controls.Add(this.cupsFilter);
            this.filterBox.Controls.Add(this.vitaminFilter);
            this.filterBox.Controls.Add(this.weightFilter);
            this.filterBox.Controls.Add(this.fiberFilter);
            this.filterBox.Controls.Add(this.shelfLifeFilter);
            this.filterBox.Controls.Add(this.potassFilter);
            this.filterBox.Controls.Add(this.sodiumFilter);
            this.filterBox.Controls.Add(this.fatFilter);
            this.filterBox.Controls.Add(this.proteinFilter);
            this.filterBox.Controls.Add(this.caloriesFilter);
            this.filterBox.Controls.Add(this.sugarFilter);
            this.filterBox.Controls.Add(this.typeFilter);
            this.filterBox.Controls.Add(this.mfrFilter);
            this.filterBox.Controls.Add(this.carbFilter);
            this.filterBox.Controls.Add(this.nameFilter);
            this.filterBox.Enabled = false;
            this.filterBox.Location = new System.Drawing.Point(36, 387);
            this.filterBox.Name = "filterBox";
            this.filterBox.Size = new System.Drawing.Size(200, 538);
            this.filterBox.TabIndex = 1;
            this.filterBox.TabStop = false;
            this.filterBox.Text = "Sort By:";
            // 
            // ratingFilter
            // 
            this.ratingFilter.AutoSize = true;
            this.ratingFilter.Location = new System.Drawing.Point(6, 486);
            this.ratingFilter.Name = "ratingFilter";
            this.ratingFilter.Size = new System.Drawing.Size(81, 24);
            this.ratingFilter.TabIndex = 11;
            this.ratingFilter.TabStop = true;
            this.ratingFilter.Text = "Rating";
            this.ratingFilter.UseVisualStyleBackColor = true;
            // 
            // cupsFilter
            // 
            this.cupsFilter.AutoSize = true;
            this.cupsFilter.Location = new System.Drawing.Point(6, 456);
            this.cupsFilter.Name = "cupsFilter";
            this.cupsFilter.Size = new System.Drawing.Size(71, 24);
            this.cupsFilter.TabIndex = 15;
            this.cupsFilter.TabStop = true;
            this.cupsFilter.Text = "Cups";
            this.cupsFilter.UseVisualStyleBackColor = true;
            // 
            // vitaminFilter
            // 
            this.vitaminFilter.AutoSize = true;
            this.vitaminFilter.Location = new System.Drawing.Point(6, 366);
            this.vitaminFilter.Name = "vitaminFilter";
            this.vitaminFilter.Size = new System.Drawing.Size(95, 24);
            this.vitaminFilter.TabIndex = 17;
            this.vitaminFilter.TabStop = true;
            this.vitaminFilter.Text = "Vitamins";
            this.vitaminFilter.UseVisualStyleBackColor = true;
            // 
            // weightFilter
            // 
            this.weightFilter.AutoSize = true;
            this.weightFilter.Location = new System.Drawing.Point(6, 426);
            this.weightFilter.Name = "weightFilter";
            this.weightFilter.Size = new System.Drawing.Size(84, 24);
            this.weightFilter.TabIndex = 14;
            this.weightFilter.TabStop = true;
            this.weightFilter.Text = "Weight";
            this.weightFilter.UseVisualStyleBackColor = true;
            // 
            // fiberFilter
            // 
            this.fiberFilter.AutoSize = true;
            this.fiberFilter.Location = new System.Drawing.Point(6, 246);
            this.fiberFilter.Name = "fiberFilter";
            this.fiberFilter.Size = new System.Drawing.Size(70, 24);
            this.fiberFilter.TabIndex = 9;
            this.fiberFilter.TabStop = true;
            this.fiberFilter.Text = "Fiber";
            this.fiberFilter.UseVisualStyleBackColor = true;
            // 
            // shelfLifeFilter
            // 
            this.shelfLifeFilter.AutoSize = true;
            this.shelfLifeFilter.Location = new System.Drawing.Point(6, 396);
            this.shelfLifeFilter.Name = "shelfLifeFilter";
            this.shelfLifeFilter.Size = new System.Drawing.Size(101, 24);
            this.shelfLifeFilter.TabIndex = 13;
            this.shelfLifeFilter.TabStop = true;
            this.shelfLifeFilter.Text = "Shelf Life";
            this.shelfLifeFilter.UseVisualStyleBackColor = true;
            // 
            // potassFilter
            // 
            this.potassFilter.AutoSize = true;
            this.potassFilter.Location = new System.Drawing.Point(6, 336);
            this.potassFilter.Name = "potassFilter";
            this.potassFilter.Size = new System.Drawing.Size(108, 24);
            this.potassFilter.TabIndex = 16;
            this.potassFilter.TabStop = true;
            this.potassFilter.Text = "Potassium";
            this.potassFilter.UseVisualStyleBackColor = true;
            // 
            // sodiumFilter
            // 
            this.sodiumFilter.AutoSize = true;
            this.sodiumFilter.Location = new System.Drawing.Point(6, 216);
            this.sodiumFilter.Name = "sodiumFilter";
            this.sodiumFilter.Size = new System.Drawing.Size(88, 24);
            this.sodiumFilter.TabIndex = 8;
            this.sodiumFilter.TabStop = true;
            this.sodiumFilter.Text = "Sodium";
            this.sodiumFilter.UseVisualStyleBackColor = true;
            // 
            // fatFilter
            // 
            this.fatFilter.AutoSize = true;
            this.fatFilter.Location = new System.Drawing.Point(6, 186);
            this.fatFilter.Name = "fatFilter";
            this.fatFilter.Size = new System.Drawing.Size(58, 24);
            this.fatFilter.TabIndex = 7;
            this.fatFilter.TabStop = true;
            this.fatFilter.Text = "Fat";
            this.fatFilter.UseVisualStyleBackColor = true;
            // 
            // proteinFilter
            // 
            this.proteinFilter.AutoSize = true;
            this.proteinFilter.Location = new System.Drawing.Point(6, 156);
            this.proteinFilter.Name = "proteinFilter";
            this.proteinFilter.Size = new System.Drawing.Size(84, 24);
            this.proteinFilter.TabIndex = 6;
            this.proteinFilter.TabStop = true;
            this.proteinFilter.Text = "Protein";
            this.proteinFilter.UseVisualStyleBackColor = true;
            // 
            // caloriesFilter
            // 
            this.caloriesFilter.AutoSize = true;
            this.caloriesFilter.Location = new System.Drawing.Point(6, 126);
            this.caloriesFilter.Name = "caloriesFilter";
            this.caloriesFilter.Size = new System.Drawing.Size(91, 24);
            this.caloriesFilter.TabIndex = 5;
            this.caloriesFilter.TabStop = true;
            this.caloriesFilter.Text = "Calories";
            this.caloriesFilter.UseVisualStyleBackColor = true;
            // 
            // sugarFilter
            // 
            this.sugarFilter.AutoSize = true;
            this.sugarFilter.Location = new System.Drawing.Point(6, 306);
            this.sugarFilter.Name = "sugarFilter";
            this.sugarFilter.Size = new System.Drawing.Size(77, 24);
            this.sugarFilter.TabIndex = 12;
            this.sugarFilter.TabStop = true;
            this.sugarFilter.Text = "Sugar";
            this.sugarFilter.UseVisualStyleBackColor = true;
            // 
            // typeFilter
            // 
            this.typeFilter.AutoSize = true;
            this.typeFilter.Location = new System.Drawing.Point(6, 96);
            this.typeFilter.Name = "typeFilter";
            this.typeFilter.Size = new System.Drawing.Size(96, 24);
            this.typeFilter.TabIndex = 4;
            this.typeFilter.TabStop = true;
            this.typeFilter.Text = "Cold/Hot";
            this.typeFilter.UseVisualStyleBackColor = true;
            // 
            // mfrFilter
            // 
            this.mfrFilter.AutoSize = true;
            this.mfrFilter.Location = new System.Drawing.Point(6, 66);
            this.mfrFilter.Name = "mfrFilter";
            this.mfrFilter.Size = new System.Drawing.Size(129, 24);
            this.mfrFilter.TabIndex = 3;
            this.mfrFilter.TabStop = true;
            this.mfrFilter.Text = "Manufacturer";
            this.mfrFilter.UseVisualStyleBackColor = true;
            // 
            // carbFilter
            // 
            this.carbFilter.AutoSize = true;
            this.carbFilter.Location = new System.Drawing.Point(6, 276);
            this.carbFilter.Name = "carbFilter";
            this.carbFilter.Size = new System.Drawing.Size(76, 24);
            this.carbFilter.TabIndex = 10;
            this.carbFilter.TabStop = true;
            this.carbFilter.Text = "Carbs";
            this.carbFilter.UseVisualStyleBackColor = true;
            // 
            // nameFilter
            // 
            this.nameFilter.AutoSize = true;
            this.nameFilter.Location = new System.Drawing.Point(6, 36);
            this.nameFilter.Name = "nameFilter";
            this.nameFilter.Size = new System.Drawing.Size(76, 24);
            this.nameFilter.TabIndex = 2;
            this.nameFilter.TabStop = true;
            this.nameFilter.Text = "Name";
            this.nameFilter.UseVisualStyleBackColor = true;
            // 
            // customSearchBox
            // 
            this.customSearchBox.BackColor = System.Drawing.Color.LightSlateGray;
            this.customSearchBox.Controls.Add(this.searchButton);
            this.customSearchBox.Controls.Add(this.ratingLabel);
            this.customSearchBox.Controls.Add(this.cupsLabel);
            this.customSearchBox.Controls.Add(this.weightLabel);
            this.customSearchBox.Controls.Add(this.shelfLifeLabel);
            this.customSearchBox.Controls.Add(this.vitaminLabel);
            this.customSearchBox.Controls.Add(this.potassLabel);
            this.customSearchBox.Controls.Add(this.sugarLabel);
            this.customSearchBox.Controls.Add(this.carbsLabel);
            this.customSearchBox.Controls.Add(this.fiberLabel);
            this.customSearchBox.Controls.Add(this.ratingMax);
            this.customSearchBox.Controls.Add(this.sodiumLabel);
            this.customSearchBox.Controls.Add(this.cupsMax);
            this.customSearchBox.Controls.Add(this.weightMax);
            this.customSearchBox.Controls.Add(this.proteinLabel);
            this.customSearchBox.Controls.Add(this.fatLabel);
            this.customSearchBox.Controls.Add(this.shelfLifeMax);
            this.customSearchBox.Controls.Add(this.vitaminsMax);
            this.customSearchBox.Controls.Add(this.potassMax);
            this.customSearchBox.Controls.Add(this.sugarMax);
            this.customSearchBox.Controls.Add(this.carbsMax);
            this.customSearchBox.Controls.Add(this.ratingMin);
            this.customSearchBox.Controls.Add(this.cupsMin);
            this.customSearchBox.Controls.Add(this.weightMin);
            this.customSearchBox.Controls.Add(this.shelfLifeMin);
            this.customSearchBox.Controls.Add(this.vitaminsMin);
            this.customSearchBox.Controls.Add(this.potassMin);
            this.customSearchBox.Controls.Add(this.sugarMin);
            this.customSearchBox.Controls.Add(this.carbsMin);
            this.customSearchBox.Controls.Add(this.fiberMax);
            this.customSearchBox.Controls.Add(this.fiberMin);
            this.customSearchBox.Controls.Add(this.sodiumMax);
            this.customSearchBox.Controls.Add(this.sodiumMin);
            this.customSearchBox.Controls.Add(this.fatMax);
            this.customSearchBox.Controls.Add(this.fatMin);
            this.customSearchBox.Controls.Add(this.proteinMin);
            this.customSearchBox.Controls.Add(this.caloriesMax);
            this.customSearchBox.Controls.Add(this.caloriesMin);
            this.customSearchBox.Controls.Add(this.caloriesLabel);
            this.customSearchBox.Controls.Add(this.maxLabel);
            this.customSearchBox.Controls.Add(this.minLabel);
            this.customSearchBox.Controls.Add(this.proteinMax);
            this.customSearchBox.Controls.Add(this.typeLabel);
            this.customSearchBox.Controls.Add(this.typeInput);
            this.customSearchBox.Controls.Add(this.mfrLabel);
            this.customSearchBox.Controls.Add(this.mfrInput);
            this.customSearchBox.Enabled = false;
            this.customSearchBox.Location = new System.Drawing.Point(259, 281);
            this.customSearchBox.Name = "customSearchBox";
            this.customSearchBox.Size = new System.Drawing.Size(287, 644);
            this.customSearchBox.TabIndex = 0;
            this.customSearchBox.TabStop = false;
            this.customSearchBox.Text = "Custom Search:";
            // 
            // searchButton
            // 
            this.searchButton.Location = new System.Drawing.Point(6, 579);
            this.searchButton.Name = "searchButton";
            this.searchButton.Size = new System.Drawing.Size(258, 37);
            this.searchButton.TabIndex = 55;
            this.searchButton.Text = "Search";
            this.searchButton.UseVisualStyleBackColor = true;
            this.searchButton.Click += new System.EventHandler(this.searchButton_Click);
            // 
            // ratingLabel
            // 
            this.ratingLabel.AutoSize = true;
            this.ratingLabel.Location = new System.Drawing.Point(102, 543);
            this.ratingLabel.Name = "ratingLabel";
            this.ratingLabel.Size = new System.Drawing.Size(56, 20);
            this.ratingLabel.TabIndex = 2;
            this.ratingLabel.Text = "Rating";
            // 
            // cupsLabel
            // 
            this.cupsLabel.AutoSize = true;
            this.cupsLabel.Location = new System.Drawing.Point(102, 511);
            this.cupsLabel.Name = "cupsLabel";
            this.cupsLabel.Size = new System.Drawing.Size(46, 20);
            this.cupsLabel.TabIndex = 3;
            this.cupsLabel.Text = "Cups";
            // 
            // weightLabel
            // 
            this.weightLabel.AutoSize = true;
            this.weightLabel.Location = new System.Drawing.Point(102, 479);
            this.weightLabel.Name = "weightLabel";
            this.weightLabel.Size = new System.Drawing.Size(59, 20);
            this.weightLabel.TabIndex = 4;
            this.weightLabel.Text = "Weight";
            // 
            // shelfLifeLabel
            // 
            this.shelfLifeLabel.AutoSize = true;
            this.shelfLifeLabel.Location = new System.Drawing.Point(102, 447);
            this.shelfLifeLabel.Name = "shelfLifeLabel";
            this.shelfLifeLabel.Size = new System.Drawing.Size(76, 20);
            this.shelfLifeLabel.TabIndex = 5;
            this.shelfLifeLabel.Text = "Shelf Life";
            // 
            // vitaminLabel
            // 
            this.vitaminLabel.AutoSize = true;
            this.vitaminLabel.Location = new System.Drawing.Point(102, 415);
            this.vitaminLabel.Name = "vitaminLabel";
            this.vitaminLabel.Size = new System.Drawing.Size(70, 20);
            this.vitaminLabel.TabIndex = 6;
            this.vitaminLabel.Text = "Vitamins";
            // 
            // potassLabel
            // 
            this.potassLabel.AutoSize = true;
            this.potassLabel.Location = new System.Drawing.Point(102, 383);
            this.potassLabel.Name = "potassLabel";
            this.potassLabel.Size = new System.Drawing.Size(83, 20);
            this.potassLabel.TabIndex = 7;
            this.potassLabel.Text = "Potassium";
            // 
            // sugarLabel
            // 
            this.sugarLabel.AutoSize = true;
            this.sugarLabel.Location = new System.Drawing.Point(102, 351);
            this.sugarLabel.Name = "sugarLabel";
            this.sugarLabel.Size = new System.Drawing.Size(52, 20);
            this.sugarLabel.TabIndex = 8;
            this.sugarLabel.Text = "Sugar";
            // 
            // carbsLabel
            // 
            this.carbsLabel.AutoSize = true;
            this.carbsLabel.Location = new System.Drawing.Point(102, 319);
            this.carbsLabel.Name = "carbsLabel";
            this.carbsLabel.Size = new System.Drawing.Size(51, 20);
            this.carbsLabel.TabIndex = 9;
            this.carbsLabel.Text = "Carbs";
            // 
            // fiberLabel
            // 
            this.fiberLabel.AutoSize = true;
            this.fiberLabel.Location = new System.Drawing.Point(102, 287);
            this.fiberLabel.Name = "fiberLabel";
            this.fiberLabel.Size = new System.Drawing.Size(45, 20);
            this.fiberLabel.TabIndex = 10;
            this.fiberLabel.Text = "Fiber";
            // 
            // ratingMax
            // 
            this.ratingMax.Location = new System.Drawing.Point(184, 540);
            this.ratingMax.Name = "ratingMax";
            this.ratingMax.Size = new System.Drawing.Size(79, 26);
            this.ratingMax.TabIndex = 21;
            // 
            // sodiumLabel
            // 
            this.sodiumLabel.AutoSize = true;
            this.sodiumLabel.Location = new System.Drawing.Point(102, 255);
            this.sodiumLabel.Name = "sodiumLabel";
            this.sodiumLabel.Size = new System.Drawing.Size(63, 20);
            this.sodiumLabel.TabIndex = 11;
            this.sodiumLabel.Text = "Sodium";
            // 
            // cupsMax
            // 
            this.cupsMax.Location = new System.Drawing.Point(185, 508);
            this.cupsMax.Name = "cupsMax";
            this.cupsMax.Size = new System.Drawing.Size(79, 26);
            this.cupsMax.TabIndex = 22;
            // 
            // weightMax
            // 
            this.weightMax.Location = new System.Drawing.Point(185, 476);
            this.weightMax.Name = "weightMax";
            this.weightMax.Size = new System.Drawing.Size(79, 26);
            this.weightMax.TabIndex = 23;
            // 
            // proteinLabel
            // 
            this.proteinLabel.AutoSize = true;
            this.proteinLabel.Location = new System.Drawing.Point(102, 191);
            this.proteinLabel.Name = "proteinLabel";
            this.proteinLabel.Size = new System.Drawing.Size(59, 20);
            this.proteinLabel.TabIndex = 12;
            this.proteinLabel.Text = "Protein";
            // 
            // fatLabel
            // 
            this.fatLabel.AutoSize = true;
            this.fatLabel.Location = new System.Drawing.Point(102, 223);
            this.fatLabel.Name = "fatLabel";
            this.fatLabel.Size = new System.Drawing.Size(33, 20);
            this.fatLabel.TabIndex = 13;
            this.fatLabel.Text = "Fat";
            // 
            // shelfLifeMax
            // 
            this.shelfLifeMax.Location = new System.Drawing.Point(184, 444);
            this.shelfLifeMax.Name = "shelfLifeMax";
            this.shelfLifeMax.Size = new System.Drawing.Size(79, 26);
            this.shelfLifeMax.TabIndex = 24;
            // 
            // vitaminsMax
            // 
            this.vitaminsMax.Location = new System.Drawing.Point(185, 412);
            this.vitaminsMax.Name = "vitaminsMax";
            this.vitaminsMax.Size = new System.Drawing.Size(79, 26);
            this.vitaminsMax.TabIndex = 25;
            // 
            // potassMax
            // 
            this.potassMax.Location = new System.Drawing.Point(185, 380);
            this.potassMax.Name = "potassMax";
            this.potassMax.Size = new System.Drawing.Size(79, 26);
            this.potassMax.TabIndex = 26;
            // 
            // sugarMax
            // 
            this.sugarMax.Location = new System.Drawing.Point(185, 348);
            this.sugarMax.Name = "sugarMax";
            this.sugarMax.Size = new System.Drawing.Size(79, 26);
            this.sugarMax.TabIndex = 28;
            // 
            // carbsMax
            // 
            this.carbsMax.Location = new System.Drawing.Point(185, 316);
            this.carbsMax.Name = "carbsMax";
            this.carbsMax.Size = new System.Drawing.Size(79, 26);
            this.carbsMax.TabIndex = 29;
            // 
            // ratingMin
            // 
            this.ratingMin.Location = new System.Drawing.Point(6, 540);
            this.ratingMin.Name = "ratingMin";
            this.ratingMin.Size = new System.Drawing.Size(79, 26);
            this.ratingMin.TabIndex = 30;
            // 
            // cupsMin
            // 
            this.cupsMin.Location = new System.Drawing.Point(6, 508);
            this.cupsMin.Name = "cupsMin";
            this.cupsMin.Size = new System.Drawing.Size(79, 26);
            this.cupsMin.TabIndex = 31;
            // 
            // weightMin
            // 
            this.weightMin.Location = new System.Drawing.Point(6, 476);
            this.weightMin.Name = "weightMin";
            this.weightMin.Size = new System.Drawing.Size(79, 26);
            this.weightMin.TabIndex = 32;
            // 
            // shelfLifeMin
            // 
            this.shelfLifeMin.Location = new System.Drawing.Point(6, 444);
            this.shelfLifeMin.Name = "shelfLifeMin";
            this.shelfLifeMin.Size = new System.Drawing.Size(79, 26);
            this.shelfLifeMin.TabIndex = 33;
            // 
            // vitaminsMin
            // 
            this.vitaminsMin.Location = new System.Drawing.Point(6, 412);
            this.vitaminsMin.Name = "vitaminsMin";
            this.vitaminsMin.Size = new System.Drawing.Size(79, 26);
            this.vitaminsMin.TabIndex = 34;
            // 
            // potassMin
            // 
            this.potassMin.Location = new System.Drawing.Point(6, 380);
            this.potassMin.Name = "potassMin";
            this.potassMin.Size = new System.Drawing.Size(79, 26);
            this.potassMin.TabIndex = 35;
            // 
            // sugarMin
            // 
            this.sugarMin.Location = new System.Drawing.Point(6, 348);
            this.sugarMin.Name = "sugarMin";
            this.sugarMin.Size = new System.Drawing.Size(79, 26);
            this.sugarMin.TabIndex = 36;
            // 
            // carbsMin
            // 
            this.carbsMin.Location = new System.Drawing.Point(6, 316);
            this.carbsMin.Name = "carbsMin";
            this.carbsMin.Size = new System.Drawing.Size(79, 26);
            this.carbsMin.TabIndex = 37;
            // 
            // fiberMax
            // 
            this.fiberMax.Location = new System.Drawing.Point(185, 284);
            this.fiberMax.Name = "fiberMax";
            this.fiberMax.Size = new System.Drawing.Size(79, 26);
            this.fiberMax.TabIndex = 39;
            // 
            // fiberMin
            // 
            this.fiberMin.Location = new System.Drawing.Point(6, 284);
            this.fiberMin.Name = "fiberMin";
            this.fiberMin.Size = new System.Drawing.Size(79, 26);
            this.fiberMin.TabIndex = 40;
            // 
            // sodiumMax
            // 
            this.sodiumMax.Location = new System.Drawing.Point(185, 252);
            this.sodiumMax.Name = "sodiumMax";
            this.sodiumMax.Size = new System.Drawing.Size(79, 26);
            this.sodiumMax.TabIndex = 41;
            // 
            // sodiumMin
            // 
            this.sodiumMin.Location = new System.Drawing.Point(6, 252);
            this.sodiumMin.Name = "sodiumMin";
            this.sodiumMin.Size = new System.Drawing.Size(79, 26);
            this.sodiumMin.TabIndex = 42;
            // 
            // fatMax
            // 
            this.fatMax.Location = new System.Drawing.Point(185, 220);
            this.fatMax.Name = "fatMax";
            this.fatMax.Size = new System.Drawing.Size(79, 26);
            this.fatMax.TabIndex = 43;
            // 
            // fatMin
            // 
            this.fatMin.Location = new System.Drawing.Point(6, 220);
            this.fatMin.Name = "fatMin";
            this.fatMin.Size = new System.Drawing.Size(79, 26);
            this.fatMin.TabIndex = 44;
            // 
            // proteinMin
            // 
            this.proteinMin.Location = new System.Drawing.Point(6, 188);
            this.proteinMin.Name = "proteinMin";
            this.proteinMin.Size = new System.Drawing.Size(79, 26);
            this.proteinMin.TabIndex = 45;
            // 
            // caloriesMax
            // 
            this.caloriesMax.Location = new System.Drawing.Point(185, 156);
            this.caloriesMax.Name = "caloriesMax";
            this.caloriesMax.Size = new System.Drawing.Size(79, 26);
            this.caloriesMax.TabIndex = 46;
            // 
            // caloriesMin
            // 
            this.caloriesMin.Location = new System.Drawing.Point(6, 156);
            this.caloriesMin.Name = "caloriesMin";
            this.caloriesMin.Size = new System.Drawing.Size(79, 26);
            this.caloriesMin.TabIndex = 47;
            // 
            // caloriesLabel
            // 
            this.caloriesLabel.AutoSize = true;
            this.caloriesLabel.Location = new System.Drawing.Point(102, 159);
            this.caloriesLabel.Name = "caloriesLabel";
            this.caloriesLabel.Size = new System.Drawing.Size(66, 20);
            this.caloriesLabel.TabIndex = 14;
            this.caloriesLabel.Text = "Calories";
            // 
            // maxLabel
            // 
            this.maxLabel.AutoSize = true;
            this.maxLabel.Location = new System.Drawing.Point(181, 125);
            this.maxLabel.Name = "maxLabel";
            this.maxLabel.Size = new System.Drawing.Size(42, 20);
            this.maxLabel.TabIndex = 53;
            this.maxLabel.Text = "Max.";
            // 
            // minLabel
            // 
            this.minLabel.AutoSize = true;
            this.minLabel.Location = new System.Drawing.Point(19, 125);
            this.minLabel.Name = "minLabel";
            this.minLabel.Size = new System.Drawing.Size(38, 20);
            this.minLabel.TabIndex = 52;
            this.minLabel.Text = "Min.";
            // 
            // proteinMax
            // 
            this.proteinMax.Location = new System.Drawing.Point(185, 188);
            this.proteinMax.Name = "proteinMax";
            this.proteinMax.Size = new System.Drawing.Size(79, 26);
            this.proteinMax.TabIndex = 38;
            // 
            // typeLabel
            // 
            this.typeLabel.AutoSize = true;
            this.typeLabel.Location = new System.Drawing.Point(19, 81);
            this.typeLabel.Name = "typeLabel";
            this.typeLabel.Size = new System.Drawing.Size(84, 20);
            this.typeLabel.TabIndex = 51;
            this.typeLabel.Text = "Type (C/H)";
            // 
            // typeInput
            // 
            this.typeInput.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.typeInput.Location = new System.Drawing.Point(213, 75);
            this.typeInput.MaxLength = 1;
            this.typeInput.Name = "typeInput";
            this.typeInput.Size = new System.Drawing.Size(42, 26);
            this.typeInput.TabIndex = 48;
            // 
            // mfrLabel
            // 
            this.mfrLabel.AutoSize = true;
            this.mfrLabel.Location = new System.Drawing.Point(19, 49);
            this.mfrLabel.Name = "mfrLabel";
            this.mfrLabel.Size = new System.Drawing.Size(173, 20);
            this.mfrLabel.TabIndex = 50;
            this.mfrLabel.Text = "Mfr (A, G, K, N, P, Q, R)";
            // 
            // mfrInput
            // 
            this.mfrInput.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.mfrInput.Location = new System.Drawing.Point(213, 43);
            this.mfrInput.MaxLength = 1;
            this.mfrInput.Name = "mfrInput";
            this.mfrInput.Size = new System.Drawing.Size(42, 26);
            this.mfrInput.TabIndex = 49;
            // 
            // nameLabel
            // 
            this.nameLabel.AutoSize = true;
            this.nameLabel.Location = new System.Drawing.Point(575, 312);
            this.nameLabel.Name = "nameLabel";
            this.nameLabel.Size = new System.Drawing.Size(51, 20);
            this.nameLabel.TabIndex = 28;
            this.nameLabel.Text = "Name";
            // 
            // nameInput
            // 
            this.nameInput.Location = new System.Drawing.Point(632, 306);
            this.nameInput.Name = "nameInput";
            this.nameInput.Size = new System.Drawing.Size(179, 26);
            this.nameInput.TabIndex = 27;
            // 
            // resetButton
            // 
            this.resetButton.Location = new System.Drawing.Point(132, 931);
            this.resetButton.Name = "resetButton";
            this.resetButton.Size = new System.Drawing.Size(267, 37);
            this.resetButton.TabIndex = 54;
            this.resetButton.Text = "Reset";
            this.resetButton.UseVisualStyleBackColor = true;
            this.resetButton.Click += new System.EventHandler(this.resetButton_Click);
            // 
            // cerealTable
            // 
            this.cerealTable.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.cerealTable.Location = new System.Drawing.Point(579, 352);
            this.cerealTable.Name = "cerealTable";
            this.cerealTable.RowHeadersWidth = 62;
            this.cerealTable.RowTemplate.Height = 28;
            this.cerealTable.Size = new System.Drawing.Size(1323, 638);
            this.cerealTable.TabIndex = 18;
            // 
            // toggleSortFilter
            // 
            this.toggleSortFilter.AutoSize = true;
            this.toggleSortFilter.Location = new System.Drawing.Point(6, 25);
            this.toggleSortFilter.Name = "toggleSortFilter";
            this.toggleSortFilter.Size = new System.Drawing.Size(124, 24);
            this.toggleSortFilter.TabIndex = 55;
            this.toggleSortFilter.TabStop = true;
            this.toggleSortFilter.Text = "Sorting Filter";
            this.toggleSortFilter.UseVisualStyleBackColor = true;
            // 
            // toggleCustomSearch
            // 
            this.toggleCustomSearch.AutoSize = true;
            this.toggleCustomSearch.Location = new System.Drawing.Point(248, 25);
            this.toggleCustomSearch.Name = "toggleCustomSearch";
            this.toggleCustomSearch.Size = new System.Drawing.Size(128, 24);
            this.toggleCustomSearch.TabIndex = 56;
            this.toggleCustomSearch.TabStop = true;
            this.toggleCustomSearch.Text = "Custom Filter";
            this.toggleCustomSearch.UseVisualStyleBackColor = true;
            // 
            // toggleBox
            // 
            this.toggleBox.BackColor = System.Drawing.Color.LightSlateGray;
            this.toggleBox.Controls.Add(this.toggleSortFilter);
            this.toggleBox.Controls.Add(this.toggleCustomSearch);
            this.toggleBox.Location = new System.Drawing.Point(42, 216);
            this.toggleBox.Name = "toggleBox";
            this.toggleBox.Size = new System.Drawing.Size(504, 59);
            this.toggleBox.TabIndex = 57;
            this.toggleBox.TabStop = false;
            this.toggleBox.Text = "Which Filter Would You Like To Use?";
            // 
            // titleLabel
            // 
            this.titleLabel.AutoSize = true;
            this.titleLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.titleLabel.Location = new System.Drawing.Point(672, 9);
            this.titleLabel.Name = "titleLabel";
            this.titleLabel.Size = new System.Drawing.Size(594, 82);
            this.titleLabel.TabIndex = 58;
            this.titleLabel.Text = "Cereal Killer App";
            // 
            // descriptionLabel
            // 
            this.descriptionLabel.AutoSize = true;
            this.descriptionLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.descriptionLabel.Location = new System.Drawing.Point(574, 115);
            this.descriptionLabel.Name = "descriptionLabel";
            this.descriptionLabel.Size = new System.Drawing.Size(934, 150);
            this.descriptionLabel.TabIndex = 59;
            this.descriptionLabel.Text = resources.GetString("descriptionLabel.Text");
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.SkyBlue;
            this.ClientSize = new System.Drawing.Size(1920, 1008);
            this.Controls.Add(this.descriptionLabel);
            this.Controls.Add(this.titleLabel);
            this.Controls.Add(this.toggleBox);
            this.Controls.Add(this.cerealTable);
            this.Controls.Add(this.resetButton);
            this.Controls.Add(this.customSearchBox);
            this.Controls.Add(this.filterBox);
            this.Controls.Add(this.orderBox);
            this.Controls.Add(this.nameInput);
            this.Controls.Add(this.nameLabel);
            this.Name = "Form1";
            this.Text = "Form1";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.orderBox.ResumeLayout(false);
            this.orderBox.PerformLayout();
            this.filterBox.ResumeLayout(false);
            this.filterBox.PerformLayout();
            this.customSearchBox.ResumeLayout(false);
            this.customSearchBox.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cerealTable)).EndInit();
            this.toggleBox.ResumeLayout(false);
            this.toggleBox.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox orderBox;
        private System.Windows.Forms.RadioButton descendingButton;
        private System.Windows.Forms.RadioButton ascendingButton;
        private System.Windows.Forms.GroupBox filterBox;
        private System.Windows.Forms.RadioButton carbFilter;
        private System.Windows.Forms.RadioButton fiberFilter;
        private System.Windows.Forms.RadioButton sodiumFilter;
        private System.Windows.Forms.RadioButton fatFilter;
        private System.Windows.Forms.RadioButton proteinFilter;
        private System.Windows.Forms.RadioButton caloriesFilter;
        private System.Windows.Forms.RadioButton typeFilter;
        private System.Windows.Forms.RadioButton mfrFilter;
        private System.Windows.Forms.RadioButton nameFilter;
        private System.Windows.Forms.GroupBox customSearchBox;
        private System.Windows.Forms.RadioButton ratingFilter;
        private System.Windows.Forms.RadioButton cupsFilter;
        private System.Windows.Forms.RadioButton vitaminFilter;
        private System.Windows.Forms.RadioButton weightFilter;
        private System.Windows.Forms.RadioButton shelfLifeFilter;
        private System.Windows.Forms.RadioButton potassFilter;
        private System.Windows.Forms.RadioButton sugarFilter;
        private System.Windows.Forms.Label ratingLabel;
        private System.Windows.Forms.Label cupsLabel;
        private System.Windows.Forms.Label weightLabel;
        private System.Windows.Forms.Label shelfLifeLabel;
        private System.Windows.Forms.Label vitaminLabel;
        private System.Windows.Forms.Label potassLabel;
        private System.Windows.Forms.Label sugarLabel;
        private System.Windows.Forms.Label carbsLabel;
        private System.Windows.Forms.Label fiberLabel;
        private System.Windows.Forms.TextBox ratingMax;
        private System.Windows.Forms.Label sodiumLabel;
        private System.Windows.Forms.TextBox cupsMax;
        private System.Windows.Forms.TextBox weightMax;
        private System.Windows.Forms.Label proteinLabel;
        private System.Windows.Forms.Label fatLabel;
        private System.Windows.Forms.TextBox shelfLifeMax;
        private System.Windows.Forms.TextBox vitaminsMax;
        private System.Windows.Forms.TextBox potassMax;
        private System.Windows.Forms.TextBox sugarMax;
        private System.Windows.Forms.TextBox carbsMax;
        private System.Windows.Forms.TextBox ratingMin;
        private System.Windows.Forms.TextBox cupsMin;
        private System.Windows.Forms.TextBox weightMin;
        private System.Windows.Forms.TextBox shelfLifeMin;
        private System.Windows.Forms.TextBox vitaminsMin;
        private System.Windows.Forms.TextBox potassMin;
        private System.Windows.Forms.TextBox sugarMin;
        private System.Windows.Forms.TextBox carbsMin;
        private System.Windows.Forms.TextBox fiberMax;
        private System.Windows.Forms.TextBox fiberMin;
        private System.Windows.Forms.TextBox sodiumMax;
        private System.Windows.Forms.TextBox sodiumMin;
        private System.Windows.Forms.TextBox fatMax;
        private System.Windows.Forms.TextBox fatMin;
        private System.Windows.Forms.TextBox proteinMin;
        private System.Windows.Forms.TextBox caloriesMax;
        private System.Windows.Forms.TextBox caloriesMin;
        private System.Windows.Forms.Label caloriesLabel;
        private System.Windows.Forms.Label maxLabel;
        private System.Windows.Forms.Label minLabel;
        private System.Windows.Forms.TextBox proteinMax;
        private System.Windows.Forms.Label typeLabel;
        private System.Windows.Forms.TextBox typeInput;
        private System.Windows.Forms.Label mfrLabel;
        private System.Windows.Forms.TextBox mfrInput;
        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.TextBox nameInput;
        private System.Windows.Forms.Button searchButton;
        private System.Windows.Forms.Button resetButton;
        private System.Windows.Forms.DataGridView cerealTable;
        private System.Windows.Forms.RadioButton toggleSortFilter;
        private System.Windows.Forms.RadioButton toggleCustomSearch;
        private System.Windows.Forms.GroupBox toggleBox;
        private System.Windows.Forms.Label titleLabel;
        private System.Windows.Forms.Label descriptionLabel;
    }
}

