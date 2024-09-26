/*
Keaton Raymond
CS 3060-002
Question:
    in statistics, when a set of values is sorted in ascending or descending order, its "median" is the middle value. 
    if the set contains an even number of values, the median is the mean, or average, of the 2 middle values. 
    write a function that accepts as arguments the following:
        an array of integers
        an integer that indicates the number of elements in the array
    
    the function should determine the median of the array. 
    this value should be returned as a double. (assume the values in the array are already sorted)

    demonstrate your pointer prowess by using pointer notation instead of array notation in this function
*/

#include <iostream>
using namespace std;

//prototype
double getMedian(int[], int);

int main()
{
    //declare the arrays and find the sizes
    int evenArray[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int evenArraySize = sizeof(evenArray)/sizeof(evenArray[0]);

    int oddArray[] = {1, 2, 3, 4, 5, 6, 7};
    int oddArraySize = sizeof(oddArray)/sizeof(oddArray[0]);

    //cout statement that prints the output of the getMedian function
    cout << "The median of the array with even elements is: " << getMedian(evenArray, evenArraySize) << endl;
    cout << "The median of the array with odd elements is: " << getMedian(oddArray, oddArraySize) << endl;
    
    return 0;
}

double getMedian(int medianArray[], int arraySize)
{
    int *arrPtr = &medianArray[0];
    double returnVal = 0.0;
    if(arraySize%2==0)
    {
        int evenLeftIndex = 0, evenRightIndex = 0;
        //find the index of the left and right elements
        evenLeftIndex = (arraySize-2)/2;
        evenRightIndex = arraySize/2;
        //calculate median, cast to double to do double division not int division
        returnVal = (double(*(arrPtr+evenLeftIndex)) + double(*(arrPtr+evenRightIndex)))/2;
        return returnVal;
    }
    else
    {
        int oddArrayIndex=0;
        oddArrayIndex = (arraySize-1)/2; //find the index of the median
        returnVal = *(arrPtr+oddArrayIndex);
    	return returnVal;
    }
}