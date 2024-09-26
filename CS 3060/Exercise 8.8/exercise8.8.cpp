/*
Keaton Raymond
CS 3060-002
Question:
    write a program that has an array of at least 20 integers. 
    it should call a function that uses the linear search algorithm to locate one of the values. 
    the function should keep a count of the number of comparisons it makes until it finds the value. 
    the program then should call a function that uses the binary search algorithm to locate the same value. 
    it should also keep count of the number of comparisons it makes. display these values on the screen.
*/

#include <iostream>
using namespace std;

//constants
const int ARRAY_SIZE = 20;

//prototypes
int linearSearchBench(int[], int, int);
int binarySearchBench(int[], int, int);

int main()
{
    int comparisons=0;
    int tests[ARRAY_SIZE] = {101, 142, 147, 189, 199, 207, 222,  234, 289, 296, 310, 319, 388, 394, 417, 429, 447, 521, 536, 600};

    //display value being searched for
    cout << "Searching for the value 521, located near the end of the array.\n";

    //linear search
    comparisons = linearSearchBench(tests, ARRAY_SIZE, 521);
    cout << "The linear search made " << comparisons << " comparisons.\n";

    //binary search
    comparisons = binarySearchBench(tests, ARRAY_SIZE, 521);
    cout << "The linear search made " << comparisons << " comparisons.\n";

    return 0;
}

int linearSearchBench(int values[], int arrSize, int searchNum)
{
    //vars
    bool found = false;
    int index = 0;
    int comparisons = 0;

    //search while value has not been found and index is still in array bounds
    while (!found && index<arrSize)
    {
        comparisons++;

        if(values[index]==searchNum)
            found=true;
        
        index++;
    }
    
    return comparisons;
}

int binarySearchBench(int values[], int arrSize, int searchNum)
{
    //vars
    int comparisons = 0;
    bool found = false;
    int first = 0, middle=0, last=arrSize-1;

    //search while the value has not been found and the index is still in the array bounds
    while(!found && first<=last)
    {
        middle=(first+last)/2;
        comparisons++;

        //if value is midpoint
        if(values[middle]==searchNum)
            found=true;
        else if(values[middle]>searchNum) //elif value is in lower half
            last=middle-1;
        else //else val is in upper half
            first=middle+1;
    }

    return comparisons;
}