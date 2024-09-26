using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace Challenge6
{
    class Program
    {
        static void Main(string[] args)
        {
            StreamReader reader = new StreamReader("metal_bands_2017.csv", Encoding.UTF32);
            int numberOfBands = File.ReadLines("metal_bands_2017.csv").Count() - 1;
            string line;
            reader.ReadLine();

            //array of band objects
            //List<Band> bands = new List<Band>();
            Band[] bands = new Band[numberOfBands];

            //read file and instantiate all cereals
            int j = 0;
            while ((line = reader.ReadLine()) != null)
            {
                string[] values = line.Split(',');
                bands[j] = new Band(Convert.ToInt32(values[0]), values[1],
                    Convert.ToInt32(values[2]), Convert.ToInt32(values[3]),
                    values[4], Convert.ToInt32(values[5]), values[6]);

                j++;
            }

            Console.WriteLine(bands[1].Style);
            //cannot for the life of my figure out how to read in the object
            //everything im trying should really work but instead it just doesn't

            //this is what the query would look like if it would read the file
            
            /*
             * var result =
             *      from band in bands
             *      where origin = "Finland"
             *      orderby split-formed descending
             *      select bandName;
             * foreach (var bandName in result)
             *      Console.WriteLine(bandName);
             *      
             * then for adding the doom, you would say:
             *      where Style.Contains("doom")
             */

        }
    }
}
