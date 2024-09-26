/*
Keaton Raymond
CS 3060-002
Question:
    Write a program that lets a maker of chips and salsa keep track of sales for five different types of salsa: 
        mild, medium, sweet, hot, and zesty. 
    The program should use two parallel 5-element arrays: 
        an array of strings that holds the five salsa names, 
        and an array of integers that holds the number of jars sold during the past month for each salsa type. 
    The salsa names should be stored using an initialization list at the time the name array is created. 

    The program should prompt the user to enter the number of jars sold for each type.

    Once this sales data has been entered, the program should produce a report that displays sales for each salsa type, 
        total sales, and the names of the highest selling and lowest selling products.
    Input Validation: Do not accept negative values for number of jars sold.
*/

#include <iostream>
#include <ostream>
#include <string>
using namespace std;

int main()
{
    string salsaNames[] = {"Mild", "Medium", "Sweet", "Hot", "Zesty"};
    int jarsSold[5];
    int totalSales = 0;
    int holdVal = 0;
    int maxIndex, minIndex;

    int arraySize = sizeof(jarsSold)/sizeof(jarsSold[0]);

    //prompt for input of sales data for each salsa with error checking
    for(int i=0; i<arraySize; i++)
    {
        do {
            cout << "Enter the units sold for the " << salsaNames[i] << " salsa: ";
            cin >> jarsSold[i];
            if(jarsSold[i] < 0)
                cout << "Please enter a non negative number\n";
        }while(jarsSold[i] < 0);
        
        totalSales += jarsSold[i];
    }

    //get the index of the jar that sold the most
    for(int i=0; i<arraySize; i++)
    {
        if(jarsSold[i] > holdVal)
        {
            maxIndex = i;
            holdVal = jarsSold[i];
        }
    }

    //get the index of the jar that sold the least
    for(int i=0; i<arraySize; i++)
    {
        if(jarsSold[i] < holdVal)
        {
            minIndex = i;
            holdVal = jarsSold[i];
        }
    }

    //generate the report
    cout << "SALES REPORT\n";
    cout << "------------\n";
    cout << "Units sold for each salsa type:\n";
    for(int i=0; i<arraySize; i++)
    {
        cout << salsaNames[i] << "\t\t" << jarsSold[i] << endl;
    }
    cout << "Total sales: " << totalSales << endl;
    cout << "The best selling salsa was " << salsaNames[maxIndex] << endl;
    cout << "The worst selling salsa was " << salsaNames[minIndex] << endl;
    
    return 0;
}