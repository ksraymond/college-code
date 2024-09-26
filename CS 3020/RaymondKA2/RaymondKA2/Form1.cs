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

namespace RaymondKA2
{

    public partial class Form1 : Form
    {
        //class variable so all methods can have access
        Cereal[] cereals = PopulateCerealArray();

        /// <summary>
        /// subscribe to events and populate the GUI
        /// </summary>
        public Form1()
        {
            InitializeComponent();
            PopulateCustomSearch();
            PopulateDataGrid(cereals);
            toggleSortFilter.CheckedChanged += FilterToggleHandler;
            toggleCustomSearch.CheckedChanged += FilterToggleHandler;
            descendingButton.CheckedChanged += AscendDescendHandler;
            ascendingButton.CheckedChanged += AscendDescendHandler;
            nameFilter.CheckedChanged += FilterBoxHandler;
            mfrFilter.CheckedChanged += FilterBoxHandler;
            typeFilter.CheckedChanged += FilterBoxHandler;
            caloriesFilter.CheckedChanged += FilterBoxHandler;
            proteinFilter.CheckedChanged += FilterBoxHandler;
            fatFilter.CheckedChanged += FilterBoxHandler;
            sodiumFilter.CheckedChanged += FilterBoxHandler;
            fiberFilter.CheckedChanged += FilterBoxHandler;
            carbFilter.CheckedChanged += FilterBoxHandler;
            sugarFilter.CheckedChanged += FilterBoxHandler;
            potassFilter.CheckedChanged += FilterBoxHandler;
            vitaminFilter.CheckedChanged += FilterBoxHandler;
            shelfLifeFilter.CheckedChanged += FilterBoxHandler;
            weightFilter.CheckedChanged += FilterBoxHandler;
            cupsFilter.CheckedChanged += FilterBoxHandler;
            ratingFilter.CheckedChanged += FilterBoxHandler;
            nameInput.TextChanged += NameSearchHandler;
            caloriesMin.TextChanged += InputSearchHandler;
            caloriesMax.TextChanged += InputSearchHandler;
            proteinMin.TextChanged += InputSearchHandler;
            proteinMax.TextChanged += InputSearchHandler;
            fatMin.TextChanged += InputSearchHandler;
            fatMax.TextChanged += InputSearchHandler;
            sodiumMin.TextChanged += InputSearchHandler;
            sodiumMax.TextChanged += InputSearchHandler;
            fiberMin.TextChanged += InputSearchHandler;
            fiberMax.TextChanged += InputSearchHandler;
            carbsMin.TextChanged += InputSearchHandler;
            carbsMax.TextChanged += InputSearchHandler;
            sugarMin.TextChanged += InputSearchHandler;
            sugarMax.TextChanged += InputSearchHandler;
            potassMin.TextChanged += InputSearchHandler;
            potassMax.TextChanged += InputSearchHandler;
            vitaminsMin.TextChanged += InputSearchHandler;
            vitaminsMax.TextChanged += InputSearchHandler;
            shelfLifeMin.TextChanged += InputSearchHandler;
            shelfLifeMax.TextChanged += InputSearchHandler;
            weightMin.TextChanged += InputSearchHandler;
            weightMax.TextChanged += InputSearchHandler;
            cupsMin.TextChanged += InputSearchHandler;
            cupsMax.TextChanged += InputSearchHandler;
            ratingMin.TextChanged += InputSearchHandler;
            ratingMax.TextChanged += InputSearchHandler;
        }

        #region handlers
        /// <summary>
        /// handler for which filter is chosen
        /// </summary>
        public void FilterToggleHandler(object sender, EventArgs e)
        {
            ActivateFilterBox();
        }
        /// <summary>
        /// handler for when either ascend or descend radio button is clicked
        /// </summary>
        public void AscendDescendHandler(object sender, EventArgs e)
        {
            ActivateSortBox();
            SortByCategory();
        }
        /// <summary>
        /// handler for when any of the filter options is clicked
        /// </summary>
        public void FilterBoxHandler(object sender, EventArgs e)
        {
            SortByCategory();
        }
        /// <summary>
        /// handler for when user searches by name
        /// </summary>
        public void NameSearchHandler(object sender, EventArgs e)
        {
            SearchByName();
        }
        /// <summary>
        /// handler for when min/max values are inputted
        /// </summary>
        public void InputSearchHandler(object sender, EventArgs e)
        {
            CheckSearchInput(sender as TextBox);
        }
        #endregion

        #region enable boxes
        /// <summary>
        /// activate whichever filter is selected
        /// </summary>
        public void ActivateFilterBox()
        {
            if (toggleSortFilter.Checked)
            {
                orderBox.Enabled = true;
                customSearchBox.Enabled = false;
                ResetSearch();
            }
            else if (toggleCustomSearch.Checked)
            {
                customSearchBox.Enabled = true;
                orderBox.Enabled = false;
                ResetSearch();
            }
        }
        /// <summary>
        /// when ascend or descend button pushed, allow use of the sort box
        /// </summary>
        public void ActivateSortBox()
        {
            if (descendingButton.Checked || ascendingButton.Checked)
                filterBox.Enabled = true;
            else
                filterBox.Enabled = false;
        }
        #endregion

        /// <summary>
        /// if else statements for when a filter is chosen
        /// </summary>
        public void SortByCategory()
        {
            
            if (ascendingButton.Checked)
            {
                if (nameFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Name ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (mfrFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Mfr ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (typeFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Type ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (caloriesFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Calories ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (proteinFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Protein ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (fatFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Fat ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (sodiumFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Sodium ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (fiberFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Fiber ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (carbFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Carbo ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (sugarFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Sugar ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (potassFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Potass ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (vitaminFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Vitamins ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (shelfLifeFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.ShelfLife ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (weightFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Weight ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (cupsFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Cups ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (ratingFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Rating ascending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
            }
            else
            {
                if (nameFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Name descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (mfrFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Mfr descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (typeFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Type descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (caloriesFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Calories descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (proteinFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Protein descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (fatFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Fat descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (sodiumFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Sodium descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (fiberFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Fiber descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (carbFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Carbo descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (sugarFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Sugar descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (potassFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Potass descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (vitaminFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Vitamins descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (shelfLifeFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.ShelfLife descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (weightFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Weight descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (cupsFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Cups descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
                else if (ratingFilter.Checked)
                {
                    var sortResult =
                        from cerealPick in cereals
                        orderby cerealPick.Rating descending
                        select cerealPick;
                    Cereal[] cerealSort = new Cereal[sortResult.Count()];
                    int i = 0;
                    foreach (var cerealPick in sortResult)
                    {
                        cerealSort[i] = cerealPick;
                        i++;
                    }
                    PopulateDataGrid(cerealSort);
                }
            }
        }
        /// <summary>
        /// query for if user decides to search by name
        /// </summary>
        public void SearchByName()
        {
            string searchTerm = nameInput.Text;
            var nameResult =
                from cereal in cereals
                where cereal.Name.ToUpper().Contains(searchTerm.ToUpper()) //use .ToUpper to account for case sensitivity
                select cereal;

            Cereal[] cerealSort = new Cereal[nameResult.Count()];
            int i = 0;
            foreach (var cereal in nameResult)
            {
                cerealSort[i] = cereal;
                i++;
            }
            PopulateDataGrid(cerealSort);
        }
        /// <summary>
        /// make sure search input is integers
        /// </summary>
        public void CheckSearchInput(TextBox text)
        {
            if (System.Text.RegularExpressions.Regex.IsMatch(text.Text, "[^0-9]"))
            {
                text.Text = text.Text.Remove(text.Text.Length - 1);
            }
        }

        #region populate methods
        /// <summary>
        /// read in cereals from .csv file and make objects
        /// </summary>
        static Cereal[] PopulateCerealArray()
        {

            StreamReader reader = new StreamReader("cereal.csv");
            string line;
            int numberOfCereals = File.ReadLines("cereal.csv").Count() - 1;
            reader.ReadLine();

            //array of cereal objects
            Cereal[] cereals = new Cereal[numberOfCereals];

            //read file and instantiate all cereals
            int j = 0;
            while ((line = reader.ReadLine()) != null)
            {
                string[] values = line.Split(',');
                cereals[j] = new Cereal(values[0], values[1][0], values[2][0], Convert.ToInt32(values[3]),
                                            Convert.ToInt32(values[4]), Convert.ToInt32(values[5]),
                                            Convert.ToInt32(values[6]), Convert.ToDouble(values[7]),
                                            Convert.ToDouble(values[8]), Convert.ToInt32(values[9]),
                                            Convert.ToInt32(values[10]), Convert.ToInt32(values[11]),
                                            Convert.ToInt32(values[12]), Convert.ToDouble(values[13]),
                                            Convert.ToDouble(values[14]), Convert.ToDouble(values[15]));
                j++;
            }
            return cereals;
        }
        /// <summary>
        /// place min and max values in the custom search to make custom search easier
        /// </summary>
        public void PopulateCustomSearch()
        {
            nameInput.Text = "";
            mfrInput.Text = "";
            typeInput.Text = "";
            caloriesMax.Text = $"{cereals.Max(x => x.Calories)}";
            caloriesMin.Text = $"{cereals.Min(x => x.Calories)}";
            proteinMax.Text = $"{cereals.Max(x => x.Protein)}";
            proteinMin.Text = $"{cereals.Min(x => x.Protein)}";
            fatMax.Text = $"{cereals.Max(x => x.Fat)}";
            fatMin.Text = $"{cereals.Min(x => x.Fat)}";
            sodiumMax.Text = $"{cereals.Max(x => x.Sodium)}";
            sodiumMin.Text = $"{cereals.Min(x => x.Sodium)}";
            sugarMax.Text = $"{cereals.Max(x => x.Sugar)}";
            sugarMin.Text = $"{cereals.Min(x => x.Sugar)}";
            potassMax.Text = $"{cereals.Max(x => x.Potass)}";
            potassMin.Text = $"{cereals.Min(x => x.Potass)}";
            vitaminsMax.Text = $"{cereals.Max(x => x.Vitamins)}";
            vitaminsMin.Text = $"{cereals.Min(x => x.Vitamins)}";
            shelfLifeMax.Text = $"{cereals.Max(x => x.ShelfLife)}";
            shelfLifeMin.Text = $"{cereals.Min(x => x.ShelfLife)}";
            fiberMax.Text = $"{Math.Ceiling(cereals.Max(x => x.Fiber))}";
            fiberMin.Text = $"{Math.Floor(cereals.Min(x => x.Fiber))}";
            carbsMax.Text = $"{Math.Ceiling(cereals.Max(x => x.Carbo))}";
            carbsMin.Text = $"{Math.Floor(cereals.Min(x => x.Carbo))}";
            weightMax.Text = $"{Math.Ceiling(cereals.Max(x => x.Weight))}";
            weightMin.Text = $"{Math.Floor(cereals.Min(x => x.Weight))}";
            cupsMax.Text = $"{Math.Ceiling(cereals.Max(x => x.Cups))}";
            cupsMin.Text = $"{Math.Floor(cereals.Min(x => x.Cups))}";
            ratingMax.Text = $"{Math.Ceiling(cereals.Max(x => x.Rating))}";
            ratingMin.Text = $"{Math.Floor(cereals.Min(x => x.Rating))}";
        }
        /// <summary>
        /// fill data grid with whatever the result is
        /// </summary>
        public void PopulateDataGrid(Cereal[] cerealList)
        {
            var cerealData = cerealList.Select(x => new
            {
                Name = x.Name,
                Manufacturer = x.Mfr,
                Type = x.Type,
                Calories = x.Calories,
                Protein = x.Protein,
                Fat = x.Fat,
                Sodium = x.Sodium,
                Fiber = x.Fiber,
                Carbs = x.Carbo,
                Sugar = x.Sugar,
                Potass = x.Potass,
                Vitamins = x.Vitamins,
                Shelf = x.ShelfLife,
                Weight = x.Weight,
                Cups = x.Cups,
                Rating = x.Rating
            }).ToList();
            cerealTable.DataSource = cerealData;
        }
        #endregion

        #region button clicks
        /// <summary>
        /// if reset button is clicked, clear all filters
        /// </summary>
        private void resetButton_Click(object sender, EventArgs e)
        {
            ResetSearch();
        }
        /// <summary>
        /// when search button is clicked, apply custom filter
        /// </summary>
        private void searchButton_Click(object sender, EventArgs e)
        {
            char mfrMin = 'A';
            char mfrMax = 'Z';
            char typeMin = 'A';
            char typeMax = 'Z';
            if(mfrInput.Text != "")
                mfrMin = mfrMax = mfrInput.Text[0];

            if (typeInput.Text != "")
                typeMin = typeMax = typeInput.Text[0];

            var customResult =
                from cereal in cereals
                where cereal.Calories >= Convert.ToInt32(caloriesMin.Text) && cereal.Calories <= Convert.ToInt32(caloriesMax.Text)
                && cereal.Protein >= Convert.ToInt32(proteinMin.Text) && cereal.Protein <= Convert.ToInt32(proteinMax.Text)
                && cereal.Fat >= Convert.ToInt32(fatMin.Text) && cereal.Fat <= Convert.ToInt32(fatMax.Text)
                && cereal.Sodium >= Convert.ToInt32(sodiumMin.Text) && cereal.Sodium <= Convert.ToInt32(sodiumMax.Text)
                && cereal.Sugar >= Convert.ToInt32(sugarMin.Text) && cereal.Sugar <= Convert.ToInt32(sugarMax.Text)
                && cereal.Potass >= Convert.ToInt32(potassMin.Text) && cereal.Potass <= Convert.ToInt32(potassMax.Text)
                && cereal.Vitamins >= Convert.ToInt32(vitaminsMin.Text) && cereal.Vitamins <= Convert.ToInt32(vitaminsMax.Text)
                && cereal.ShelfLife >= Convert.ToInt32(shelfLifeMin.Text) && cereal.ShelfLife <= Convert.ToInt32(shelfLifeMax.Text)
                && cereal.Fiber >= Convert.ToDouble(fiberMin.Text) && cereal.Fiber <= Convert.ToDouble(fiberMax.Text)
                && cereal.Carbo >= Convert.ToDouble(carbsMin.Text) && cereal.Carbo <= Convert.ToDouble(carbsMax.Text)
                && cereal.Weight >= Convert.ToDouble(weightMin.Text) && cereal.Weight <= Convert.ToDouble(weightMax.Text)
                && cereal.Cups >= Convert.ToDouble(cupsMin.Text) && cereal.Cups <= Convert.ToDouble(cupsMax.Text)
                && cereal.Rating >= Convert.ToDouble(ratingMin.Text) && cereal.Rating <= Convert.ToDouble(ratingMax.Text)
                && cereal.Mfr >= mfrMin && cereal.Mfr <= mfrMax
                && cereal.Type >= typeMin && cereal.Type <= typeMax
                select cereal;

            Cereal[] cerealSort = new Cereal[customResult.Count()];
            int i = 0;
            foreach (var cereal in customResult)
            {
                cerealSort[i] = cereal;
                i++;
            }
            PopulateDataGrid(cerealSort);
        }
        #endregion

        /// <summary>
        /// reset the search parameters
        /// </summary>
        private void ResetSearch()
        {
            PopulateCustomSearch();
            ascendingButton.Checked = false;
            descendingButton.Checked = false;
            PopulateDataGrid(cereals);
        }
    }
}