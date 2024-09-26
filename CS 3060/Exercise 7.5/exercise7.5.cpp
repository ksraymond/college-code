/*
Keaton Raymond
CS 3060-002
Question:
    A local zoo wants to keep track of how many pounds of food each of its three monkeys eats each day during a typical week. 
    Write a program that stores this information in a two-dimensional 3 x 5 array, 
    where each row represents a different monkey, and each column represents a different day of the week. 
    The program should first have the user input the data for each monkey. 
    Then, it should create a report that includes the following information:
        average amount of food eaten per day by the whole family of monkeys
        the least amount of food eaten during the week by any one monkey
        the greatest amount of food eaten during the week by any one monkey

    input validation: do not accept negative numbers for lbs of food eaten
*/

#include <iostream>
using namespace std;

const int ROWS = 3;
const int COLS = 5;

int main()
{
    //rows: monkeys
    //cols: days
    int monkeyDiet[ROWS][COLS];
    int totalFood=0;
    int minMonkey, minDay, maxMonkey, maxDay;
    int holdVal=0;

    //ask for user input for all monkey data
    for(int i=0; i<ROWS; i++)
    {
        for(int j=0; j<COLS; j++)
        {
            do 
            {
                cout << "Enter how many lbs of food was eaten by monkey " << i+1 << " on day " << j+1 << ": ";
                cin >> monkeyDiet[i][j];
                if (monkeyDiet[i][j]<0)
                    cout <<"Please enter a non negative number.\n";
            }while (monkeyDiet[i][j]<0);
            totalFood += monkeyDiet[i][j];
        }
    }

    //get the greatest amount of food eaten during the week by any 1 monkey
    for(int i=0; i<ROWS; i++)
    {
        for(int j=0; j<COLS; j++)
        {
            if(holdVal < monkeyDiet[i][j])
            {
                maxMonkey = i;
                maxDay = j;
                holdVal = monkeyDiet[i][j];
            }
        }
    }

    //get the least amount of food eaten during the week by any 1 monkey
    for(int i=0; i<ROWS; i++)
    {
        for(int j=0; j<COLS; j++)
        {
            if(holdVal > monkeyDiet[i][j])
            {
                minMonkey = i;
                minDay = j;
                holdVal = monkeyDiet[i][j];
            }
        }
    }

    //generate report

    //get average amount of food eaten per day by whole family of monkeys
    cout << "The average amount of food eaten per day by the whole family of monkeys is: " << totalFood/COLS << endl;

    //add 1 because the variables are all indices
    cout << "The greatest amount of food eaten during the week by any 1 monkey was monkey " << maxMonkey+1 << " on day " << maxDay+1 << endl;
    cout << "The least amount of food eaten during the week by any 1 monkey was monkey " << minMonkey+1 << " on day " << minDay+1 << endl;

}