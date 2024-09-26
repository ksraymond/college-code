/*

THE EXERCISE WE WERE SUPPOSED TO DO IS IN 1.25 LAB

Keaton Raymond
CS 3060-002
Question:
    write a function named timesTen. The function should have an integer parameter named number. 
    when timesTen is called, it should display the product of number times ten.
*/

#include <iostream>
using namespace std;

void timesTen(int); //prototype

void timesTen(int number)
{
    cout << number*10;
}

int main()
{
    timesTen(10);

    return 0;
}