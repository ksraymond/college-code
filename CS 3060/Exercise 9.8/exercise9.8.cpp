/*
Keaton Raymond
CS 3060-002
Question:
    in statistics, the "mode" of a set of values that occurs most often or with the greatest frequency. 
    write a function that accepts as arguments the following:
        an array of integers
        an integer that indicates the number of elements in the array

    the function should determine the mode of the array. 
    that is, it should determine which value in the array occurs most often. 
    the mode is the value the function should return. 
    if the array has no mode (none of the values occur more than once), the function should return -1.
    (assume the array will always contain nonnegative values)

    demonstrate your pointer prowess by using pointer notation instead of array notation in this function
*/

#include <iostream>
using namespace std;

//prototype
int getMode(int[], int);

int main()
{
    //declare the array and find the size
    int modeArray[] = {10, 12, 14, 10, 12, 12, 14, 15, 120, 19, 12, 10, 10, 10, 10, 15, 1, 2};
    int arraySize = sizeof(modeArray)/sizeof(modeArray[0]);

    //cout statement that prints the output of the getMode function
    cout << "The mode of the array is: " << getMode(modeArray, arraySize) << endl;
    
    return 0;
}

int getMode(int modeArray[], int arraySize)
{
    int modeValActual=0, modeCountActual=0; //used to store the current mode val and how many occurrences
    int modeValCheck=0, modeCountCheck=0; //used to store the current value that is being checked
    int *arrPtr = &modeArray[0]; //pointer to first val in array

    for(int i=0; i<arraySize; i++)
    {
        modeCountCheck=0;
        modeValCheck = *(arrPtr+i);

        for(int j=i; j<arraySize; j++) //j=i because don't need to check previous values
        {
            if(*(arrPtr+j) == modeValCheck) //if the value matches what is currently being counted for the mode
                modeCountCheck++;
        }

        if(modeCountCheck>modeCountActual) //if the current value has a count > than the current max, make that the new max
        {
            modeCountActual = modeCountCheck;
            modeValActual = modeValCheck;
        }
            
    }

    //if the modeCountActual is 1 that means that there is no mode
    if(modeCountActual==1)
        return -1;
    else
        return modeValActual;
}