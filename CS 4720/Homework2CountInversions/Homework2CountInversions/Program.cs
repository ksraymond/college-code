using System;
using System.Linq;

namespace Homework2CountInversions
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] invArray = DeclareArray();

            ulong totalInv = CountInv(invArray);

            //BruteForce(invArray);

            Console.WriteLine($"Total Inversions: {totalInv}");
        }

        static ulong CountInv(int[] invArray)
        {
            ulong leftInv, rightInv, splitInv;
            int[] leftHalf = invArray.Take(invArray.GetLength(0) / 2).ToArray();
            int[] rightHalf = invArray.Skip(invArray.GetLength(0) / 2).ToArray();

            if (invArray.GetLength(0) == 0 || invArray.GetLength(0) == 1)
                return 0;
            else
            {
                leftInv = CountInv(leftHalf);
                rightInv = CountInv(rightHalf);
                splitInv = CountSplitInv(leftHalf, rightHalf);
                return leftInv + rightInv + splitInv;
            }

        }

        static ulong CountSplitInv(int[] leftHalf, int[] rightHalf)
        {
            ulong splitInv = 0;

            for (int i = 0; i < leftHalf.GetLength(0); i++)
            {
                for (int j = 0; j < rightHalf.GetLength(0); j++)
                {
                    if (leftHalf[i] > rightHalf[j])
                        splitInv++;
                }
            }

            return splitInv;
        }

        static void BruteForce(int[] invArray)
        {
            ulong numInv = 0;

            for (int i = 0; i < invArray.GetLength(0)-1; i++)
            {
                for (int j = i+1; j < invArray.GetLength(0); j++)
                {
                    if (invArray[i] > invArray[j])
                        numInv++;
                }
            }

            Console.WriteLine($"Number of Inversions: {numInv}");
        }

        static int[] DeclareArray()
        {
            int[] integerArray = new int[10];
            int contor = 0;
            string[] stringArray = System.IO.File.ReadAllLines("inversionFiles\\prob3.5Test.txt");

            foreach (string num in stringArray)
            {
                integerArray[contor] = Convert.ToInt32(num.Trim());
                ++contor;
            }

            return integerArray;
        }
    }
}
