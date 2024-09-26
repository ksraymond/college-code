using System;
using System.Threading.Tasks;

namespace MultiThreading_Async_Testing
{
    class Program
    {
        static async Task Main(string[] args)
        {
            Task<long> aTask = Task.Run(() => CountToABillion());
            Console.WriteLine("This might take a while....");
            await aTask;
            Console.WriteLine(aTask.Result);
        }

        public static long CountToABillion()
        {
            long result = 0;
            for (long i = 0; i < 1000000000; i++)
            {
                result += i;
            }
            return result;
        }
    }
}
