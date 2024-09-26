using System;
using System.Diagnostics;

namespace Homework3QuickSort
{
    class Program
    {
        static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            int[] sortArray = DeclareArray();

            stopwatch.Start();

            //BubbleSort(sortArray);
            QuickSort(sortArray, 0, sortArray.GetLength(0));

            stopwatch.Stop();
            Console.WriteLine($"Elapsed Time is {stopwatch.ElapsedMilliseconds} ms");
            //PrintArray(sortArray);
        }

        static void QuickSort(int[] sortArray, int l, int r)
        {
            if (l >= r)
                return;
            int j = Partition(sortArray, l, r);
            QuickSort(sortArray, l, j);
            QuickSort(sortArray, j + 1, r);
        }

        static int Partition(int[] sortArray, int l, int r)
        {
            int pivot = sortArray[l];
            int i = l+1;

            for (int j = l+1; j < r; j++)
            {
                if(sortArray[j] < pivot)
                {
                    (sortArray[j], sortArray[i]) = (sortArray[i], sortArray[j]);
                    i++;
                }
            }
            (sortArray[l], sortArray[i - 1]) = (sortArray[i - 1], sortArray[l]);

            return i-1;
        }

        static void BubbleSort(int[] sortArray)
        {
            for (int pass = 1; pass < sortArray.GetLength(0); pass++)
            {
                for (int j = 0; j < sortArray.GetLength(0) - pass; j++)
                {
                    if (sortArray[j] > sortArray[j + 1])
                        (sortArray[j], sortArray[j+1]) = (sortArray[j+1], sortArray[j]);
                }
            }
        }

        static int[] DeclareArray()
        {
            int[] integerArray = new int[10000];
            int contor = 0;
            string[] stringArray = System.IO.File.ReadAllLines("QuickSortFiles\\10000Elements.txt");

            foreach (string num in stringArray)
            {
                integerArray[contor] = Convert.ToInt32(num.Trim());
                ++contor;
            }

            return integerArray;
        }

        static void PrintArray(int[] array)
        {
            for (int i = 0; i < array.GetLength(0); i++)
            {
                Console.WriteLine(array[i]);
            }
        }
    }
}
