/*
programming challenge 18

put each of the functions into its own file (lmao no)
*/

#include <iostream>
#include <iomanip>
using namespace std;

//constants
const int SQFT_PER_GALLON = 110;
const double HOURLY_RATE = 25.0;

//prototypes
int getNumberOfRooms();
double getPaintPrice();
int getWallSquareFeet();
int numberOfGallons(int);
int laborHours(int);
void displayCost(int, double, int);

int main()
{
    //vars
    int numOfRooms, totalWallArea, gallonsNeeded;
    double paintPrice, labor;

    numOfRooms = getNumberOfRooms();

    paintPrice = getPaintPrice();

    for(int i=0; i<numOfRooms; i++)
    {
        cout << "Input the square feet for room " << i+1 << ": ";
        totalWallArea += getWallSquareFeet();
    }

    gallonsNeeded = numberOfGallons(totalWallArea);

    labor = laborHours(gallonsNeeded);

    displayCost(gallonsNeeded, paintPrice, labor);

    return 0;
}

int getNumberOfRooms()
{
    int numRooms = 0;
    do {
    {
        cout << "Input the number of rooms to paint: ";
        cin >> numRooms;
        if(numRooms < 1)
            cout << "Please enter a number greater than or equal to 1\n";
    }
    }while (numRooms < 1);

    return numRooms;
}

double getPaintPrice()
{
    double paintPrice = 0;
    do {
        cout << "Input the price of the paint: ";
        cin >> paintPrice;
        if (paintPrice < 10.0)
            cout << "Please enter a number greater than or equal to $10.00\n";
    }while (paintPrice < 10.0);

    return paintPrice;
}

int getWallSquareFeet()
{
    int squareFeet = -1;
    do {
        cin >> squareFeet;
        if (squareFeet < 0)
            cout << "Please enter a non negative number\n";
    }while(squareFeet<0);

    return squareFeet;
}

int numberOfGallons(int wallArea)
{
    return wallArea/SQFT_PER_GALLON;
}

int laborHours(int gallons)
{
    return gallons*8; //8 hours of labor per gallon
}

void displayCost(int gallons, double paintPrice, int hours)
{
    //vars
    double totalPaintCost, totalLabor, totalCharges;

    totalPaintCost = gallons*paintPrice;

    totalLabor = hours*HOURLY_RATE;

    totalCharges = totalPaintCost+totalLabor;

    cout << fixed << showpoint << setprecision(2);
    cout << "\nESTIMATED CHARGES\n";
    cout << "---------------\n";
    cout << "Gallons of paint: " << gallons << endl;
    cout << "Price per gallon: $" << paintPrice << endl;
    cout << "Paint cost: $" << totalPaintCost << endl;
    cout << "Hours of labor: " << hours << endl;
    cout << "Total cost of labor: $" << totalLabor << endl;
    cout << "Total charges: $" << totalCharges << endl;
    
}