/*
bonus exercise, not a part of the homework assignment
*/

#include <iostream>
#include <iomanip>
using namespace std;

//prototype
double profit(int, double, double, double, double);

int main()
{
    int ns;
    double sp, sc, pp, pc, prof;

    //get num shares
    cout << "Input your number of shares: ";
    cin >> ns;

    //get purchase price per share
    cout << "Input your purchase price per share: ";
    cin >> pp;

    //get purchase commission
    cout << "Input your purchase commission: ";
    cin >> pc;

    //get sale price
    cout << "Input your sale price: ";
    cin >> sp;

    //get sales commission
    cout << "Input your sales commission: ";
    cin >> sc;

    //get profit or loss
    prof = profit(ns, sp, sc, pp, pc);

    //display result
    cout << fixed << showpoint << setprecision(2);
    if (prof >= 0)
        cout << "You made $" << prof;
    else if (prof < 0)
        cout <<"Your lost $" << prof;

    return 0;
}

double profit(int ns, double sp, double sc, double pp, double pc)
{
    return ((ns*sp) - sc) - ((ns*pp) + pc);
}