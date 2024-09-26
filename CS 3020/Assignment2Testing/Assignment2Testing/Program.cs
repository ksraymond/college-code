using System;
using System.IO;
using System.Linq;

namespace Assignment2Testing
{
    class Program
    {
        static void Main(string[] args)
        {
            #region Create Object Array of Cereals
            StreamReader reader = new StreamReader("cereal.csv");
            string line;
            int numberOfCereals = File.ReadLines("cereal.csv").Count() - 1;

            CerealTest[] cereals = new CerealTest[numberOfCereals];
            
            reader.ReadLine();
            int j = 0;
            while ((line = reader.ReadLine()) != null)
            {
                string[] values = line.Split(',');
                cereals[j] = new CerealTest(values[0], values[1][0], values[2][0], Convert.ToInt32(values[3]),
                                            Convert.ToInt32(values[4]), Convert.ToInt32(values[5]),
                                            Convert.ToInt32(values[6]), Convert.ToDouble(values[7]),
                                            Convert.ToDouble(values[8]), Convert.ToInt32(values[9]),
                                            Convert.ToInt32(values[10]), Convert.ToInt32(values[11]),
                                            Convert.ToInt32(values[12]), Convert.ToDouble(values[13]),
                                            Convert.ToDouble(values[14]), Convert.ToDouble(values[15]));
                j++;

            }
            #endregion

            #region min/max variables
            var maxCal = cereals.Max(x => x.Calories);
            var minCal = cereals.Min(x => x.Calories);
            var maxProtein = cereals.Max(x => x.Protein);
            var minProtein = cereals.Min(x => x.Protein); 
            var maxFat = cereals.Max(x => x.Fat);
            var minFat = cereals.Min(x => x.Fat); 
            var maxSodium = cereals.Max(x => x.Sodium);
            var minSodium = cereals.Min(x => x.Sodium); 
            var maxSugar = cereals.Max(x => x.Sugar);
            var minSugar = cereals.Min(x => x.Sugar); 
            var maxPotass = cereals.Max(x => x.Potass);
            var minPotass = cereals.Min(x => x.Potass); 
            var maxVitamins = cereals.Max(x => x.Vitamins);
            var minVitamins = cereals.Min(x => x.Vitamins); 
            var maxShelf = cereals.Max(x => x.ShelfLife);
            var minShelf = cereals.Min(x => x.ShelfLife); 
            var maxFiber = cereals.Max(x => x.Fiber);
            var minFiber = cereals.Min(x => x.Fiber); 
            var maxCarbo = cereals.Max(x => x.Carbo);
            var minCarbo = cereals.Min(x => x.Carbo); 
            var maxWeight = cereals.Max(x => x.Weight);
            var minWeight = cereals.Min(x => x.Weight); 
            var maxCups = cereals.Max(x => x.Cups);
            var minCups = cereals.Min(x => x.Cups); 
            var maxRating = cereals.Max(x => x.Rating);
            var minRating = cereals.Min(x => x.Rating);
            #endregion

            #region left side ascending and descending filters
            ///for each ascending and descending filter on the left hand side
            ///have 2 of these, one for if its ascending
            ///one for if its descending
            ///also instead of the bool, have it trigger when that button is activated
            bool ascending = false;
            bool carbsSort = true;
            if(ascending && carbsSort)
            {
                var sortResult =
                    from cereal in cereals
                    orderby cereal.Carbo ascending
                    select cereal;
                foreach(var cereal in sortResult)
                {
                    Console.WriteLine($"{cereal.Name}\t\t{cereal.Carbo}");
                    //dont print to console, print to a list of some sorts
                    //still have to figure out those details
                }
            }
            #endregion

            #region custom search
            //custom search
            //trigger when search button is hit
            //still need to add hot/cold and mfr
            //      idea: have a char set to whether its hot or cold earlier in code
            //            and have it say cereal.Type == hotColdVariable

            var customResult =
                from cereal in cereals
                where cereal.Calories >= minCal && cereal.Calories <= maxCal
                && cereal.Protein >= minProtein && cereal.Protein <= maxProtein
                && cereal.Fat >= minFat && cereal.Fat <= maxFat
                && cereal.Sodium >= minSodium && cereal.Sodium <= maxSodium
                && cereal.Sugar >= minSugar && cereal.Sugar <= maxSugar
                && cereal.Potass >= minPotass && cereal.Potass <= maxPotass
                && cereal.Vitamins >= minVitamins && cereal.Vitamins <= maxVitamins
                && cereal.ShelfLife >= minShelf && cereal.ShelfLife <= maxShelf
                && cereal.Fiber >= minFiber && cereal.Fiber <= maxFiber
                && cereal.Carbo >= minCarbo && cereal.Carbo <= maxCarbo
                && cereal.Weight >= minWeight && cereal.Weight <= maxWeight
                && cereal.Cups >= minCups && cereal.Cups <= maxCups
                && cereal.Rating >= minRating && cereal.Rating <= maxRating
                select cereal;
            //foreach(var cereal in customResult)
            //Console.WriteLine(cereal.Name);
            #endregion

            #region search by name
            //.Contains is case sensitive, find a way around that if possible
            string searchTerm = "Frosted";
            var nameResult =
                from cereal in cereals
                where cereal.Name.Contains(searchTerm)
                select cereal;
            //foreach(var cereal in nameResult)
            //    Console.WriteLine(cereal.Name);
            #endregion
        }
    }
}
