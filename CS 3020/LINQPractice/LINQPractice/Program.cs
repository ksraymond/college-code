using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace LINQPractice
{
    /// <summary>
    /// Keaton Raymond
    /// LINQ practice/in class challenge
    /// </summary>
    class Program
    {

        static Dictionary<string, int> maleNames = new Dictionary<string, int>();
        static Dictionary<string, int> femaleNames = new Dictionary<string, int>();


        //simple query list
        static string[] names = new string[] { "Bobby", "Jenna", "Bob", "Hank", 
                                               "Peggy", "Dale", "Boomhauer", "Bill"};

        static void Main(string[] args)
        {

            ReadInNames();

            var myName =
                from name in maleNames
                where name.Key == "Keaton"
                select name;

            Console.WriteLine($"{myName.First().Key} happens {myName.First().Value} times");

            //find most popular
            //var mostPopular =
            //    from name in femaleNames
            //    orderby name.Value descending
            //    select name;

            //Console.WriteLine(mostPopular.First().Key);

            //orderby popularity descending
            //var result =
            //    from name in maleNames
            //    orderby name.Value descending
            //    select name;
            //foreach(var name in result)
            //    Console.WriteLine($"{name.Key}, {name.Value}");

            //only select names w/ value between 1000 and 1100
            //var result =
            //    from name in maleNames
            //    where name.Value > 1000 && name.Value < 1100
            //    select name.Key;
            //foreach (var name in result)
            //{
            //    Console.WriteLine(name);
            //}

            //simple query commands
            //var namesB = GetBNames();
            //foreach(var name in namesB)
            //    Console.WriteLine(name);
        }

        static void ReadInNames()
        {
            for (int year = 1880; year <= 2016; year++)
            {
                string yearString = year.ToString();
                string fileName = "yob" + yearString + ".txt";

                try
                {
                    StreamReader reader = new StreamReader($"names\\names\\{fileName}");

                    while (!reader.EndOfStream)
                    {
                        string line = reader.ReadLine();
                        string[] data = line.Split(',');


                        if (data[1].CompareTo("F") == 0)
                        {
                            if(femaleNames.ContainsKey(data[0]))
                                femaleNames[data[0]] += int.Parse(data[2]);
                            else
                                femaleNames.Add(data[0], int.Parse(data[2]));
                        }
                        else
                        {
                            if (maleNames.ContainsKey(data[0]))
                                maleNames[data[0]] += int.Parse(data[2]);
                            else
                                maleNames.Add(data[0], int.Parse(data[2]));
                        }
                    }

                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }


        #region SimpleQueries
        static List<string> GetNamesByLength()
        {
            var result =
                from name in names
                orderby name.Length descending   //adding descending keyword will sort in reverse order
                select name;

            return result.ToList<string>();
        }

        static List<string> GetBNames()
        {
            var result =
                from name in names
                where (name.ToUpper())[0] == 'B' //can also write as "where name.StartsWith == 'B'
                                                 //the .ToUpper is to account for lowercase
                orderby name
                select name;

            return result.ToList<string>();
        }
        #endregion
    }
}
