using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Challenge8_ASync
{
    class Program
    {
        static Task<Gravy> makeGravy;
        static async Task Main(string[] args)
        {
            Task<Turkey> turkeyTasks = PrepareAndCookTurkey();
            Task<MashedPotatoes> potatoTasks = BoilAndMashPotatoes();
            

            List<Task> thanksgivingTasks = new List<Task> { turkeyTasks, potatoTasks };

            while(thanksgivingTasks.Count > 0)
            {
                Task finishedTask = await Task.WhenAny(thanksgivingTasks);
                if(finishedTask == turkeyTasks)
                {
                    Console.WriteLine("Turkey is cooling.");
                    makeGravy = MakeThatGravy();
                    thanksgivingTasks.Add(makeGravy);
                }else if(finishedTask == potatoTasks)
                {
                    Console.WriteLine("Potatoes look delicious.");
                }else if(finishedTask == makeGravy)
                {
                    Console.WriteLine("Gravy's done.");
                }
                thanksgivingTasks.Remove(finishedTask);
            }
        }

        static async Task<Turkey> PrepareAndCookTurkey()
        {
            //prepare
            Console.WriteLine("Preparing the turkey...");
            await Task.Delay(60 * 100);
            Console.WriteLine("Turkey prepared.");

            //cook
            Console.WriteLine("Cooking the turkey...");
            await Task.Delay(60 * 100 * 5);
            Console.WriteLine("Turkey is done.");

            return new Turkey();
        }

        static async Task<MashedPotatoes> BoilAndMashPotatoes()
        {
            //cut
            Console.WriteLine("Dicing potatoes...");
            await Task.Delay(30 * 100);
            Console.WriteLine("Potatoes diced.");

            //boil
            Console.WriteLine("Boiling potatoes...");
            await Task.Delay(30 * 100);
            Console.WriteLine("Potatoes boiled.");

            //mashing
            Console.WriteLine("Mashing potatoes...");
            await Task.Delay(30 * 100);
            Console.WriteLine("Mashed potatoes ready.");

            return new MashedPotatoes();
        }

        static async Task<Gravy> MakeThatGravy()
        {
            Console.WriteLine("Making gravy...");
            await Task.Delay(10000);
            Console.WriteLine("Gravy is ready.");

            return new Gravy();
        }
    }
}
