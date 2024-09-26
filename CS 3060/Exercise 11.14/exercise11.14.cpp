/*
Keaton Raymond
CS 3060-002
Question:
    write a program that simulates inventory bins in a warehouse. 
    each bin holds a number of the same type of parts. 
    the program should use a struct that keeps the follwoing data:
        description of part kept in the bin
        number of parts in the bin
    the program should have an array of 10 bins, initialized with the following data
        part description        number of parts
        valve                   10
        bearing                 5
        bushing                 15
        coupling                21
        flange                  7
        gear                    5
        gear housing            5
        vacuum gripper          25
        cable                   18
        rod                     12
    the program should have the following functions:
        addParts - increases a specific bin's part count by a specified number
        removeParts - decreases a specific bin's part count by a specified number
    when the program runs, it should repeat a loop that performs the following steps:
        the user should see a list of what each bin holds and how many parts are in each bin
        the user can choose to either quit the program or select a bin
        when a bin is selected, the user can either add parts or remove parts
        the loop repeats showing updated bin data on the screen
    input validation: no bin can hold more than 30 parts, so don't let the user add more than a bin can hold. 
    also, don't accept negative values for the number of parts being added or removed
*/

#include <iostream>
#include <string>
using namespace std;

//inventory bin struct
struct inventoryBin
{
    string partDescription;
    int partCount;
};

//prototypes
void addParts(inventoryBin*);
void removeParts(inventoryBin*);
void initializeArray(inventoryBin*[]);
void printArray(inventoryBin*[]);

//constant array size
const int ARRAY_SIZE = 10;

int main()
{
    int menuChoice=0, addRemoveChoice=0;
    inventoryBin* bins[ARRAY_SIZE];
    initializeArray(bins);

    do {
    {
        cout << "Input the index of the part you would like to add to or remove from.\n";
        cout << "Enter '0' to quit.\n";
        printArray(bins);
        cout << "Input: ";
        cin >> menuChoice;

        if(menuChoice > 10 || menuChoice < 0) //if invalid menu choice
            cout << "Please input a valid number.\n";

        else if(menuChoice == 0) //elif they quit
            cout << "Goodbye.\n";

        else //they chose a bin
        {
            cout << "Input 1 to add parts to the " << bins[menuChoice-1]->partDescription << " bin.\n";
            cout << "Input 2 to add parts to the " << bins[menuChoice-1]->partDescription << " bin.\n";
            cout << "Input: ";
            cin >> addRemoveChoice;
            if(addRemoveChoice==1)
                addParts(bins[menuChoice-1]);
            else if(addRemoveChoice==2)
                removeParts(bins[menuChoice-1]);
            else
                cout << "Invalid input.\n";
        }
        cout << endl;
    }
    }while (menuChoice!=0);

    return 0;
}

void initializeArray(inventoryBin* bins[])
{
    bins[0] = new inventoryBin;
    bins[0]->partDescription = "Valve";
    bins[0]->partCount = 10;

    bins[1] = new inventoryBin;
    bins[1]->partDescription = "Bearing";
    bins[1]->partCount = 5;

    bins[2] = new inventoryBin;
    bins[2]->partDescription = "Bushing";
    bins[2]->partCount = 15;

    bins[3] = new inventoryBin;
    bins[3]->partDescription = "Coupling";
    bins[3]->partCount = 21;

    bins[4] = new inventoryBin;
    bins[4]->partDescription = "Flange";
    bins[4]->partCount = 7;

    bins[5] = new inventoryBin;
    bins[5]->partDescription = "Gear";
    bins[5]->partCount = 5;

    bins[6] = new inventoryBin;
    bins[6]->partDescription = "Gear Housing";
    bins[6]->partCount = 5;

    bins[7] = new inventoryBin;
    bins[7]->partDescription = "Vacuum Gripper";
    bins[7]->partCount = 25;

    bins[8] = new inventoryBin;
    bins[8]->partDescription = "Cable";
    bins[8]->partCount = 18;

    bins[9] = new inventoryBin;
    bins[9]->partDescription = "Rod";
    bins[9]->partCount = 12;
}

void printArray(inventoryBin* bins[])
{
    
    for(int i=0; i<ARRAY_SIZE; i++)
    {
        cout << i+1 << ". " << bins[i]->partDescription << ".........." << bins[i]->partCount << endl;
    }
}

void addParts(inventoryBin* part)
{
    int addCount=0;
    int numOfParts = part->partCount; //needed for loop check
    do
    {
        cout << "How many parts would you like to add to the " << part->partDescription << " bin? ";
        cin >> addCount;

        if(part->partCount+addCount > 30) //if their input makes the count over 30
            cout << "Each bin can only hold 30 parts. Please enter a valid number.\n";
        else if(addCount<0) //if their input is negative
            cout << "Cannot add negative parts. Please enter a valid number.\n";
        else //else valid input
            part->partCount+=addCount;
            
    }while((numOfParts+addCount > 30) || addCount<0);
}

void removeParts(inventoryBin* part)
{
    int removeCount=0;
    int numOfParts = part->partCount; //needed for loop check
    do
    {
        cout << "How many parts would you like to remove from the " << part->partDescription << " bin? ";
        cin >> removeCount;

        if(part->partCount-removeCount < 0) //if input makes count over 30
            cout << "Each bin cannot hold negative parts. Please enter a valid number.\n";
        else if(removeCount<0) //if input is negative
            cout << "Cannot remove negative parts. Please enter a valid number.\n";
        else //else valid input
            part->partCount-=removeCount;
            
    }while((numOfParts-removeCount < 0) || removeCount<0);
}