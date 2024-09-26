/*
Keaton Raymond
CS 3060-002
Question:
    write templates for the two functions minimum and maximum
    the minimum function should accept 2 arguments 
        and return the value of the argument that is the lesser of the two
    the maximum function should accept 2 arguments 
        and return the value of the argument that is the greater of the two
    design a simple driver program that demonstrates the templates with various data types
*/

#include <iostream>
using namespace std;

//function prototypes
template<typename T>
T minimum(T, T);
template<typename T>
T maximum(T, T);

int main()
{
    cout << "minimum test\n";
    cout << minimum(1, 2) << endl;
    cout << minimum(100.231, 12.421) << endl;
    cout << minimum('a', 'b') << endl;

    cout << "\nmaximum test\n";
    cout << maximum(1, 2) << endl;
    cout << maximum(100.231, 12.421) << endl;
    cout << maximum('a', 'b') << endl;
    return 0;
}

//return minimum value
template<typename T>
T minimum(T t1, T t2)
{
    if(t1<=t2)
        return t1;
    else
        return t2;
}

//return maximum value
template<typename T>
T maximum(T t1, T t2)
{
    if(t1>=t2)
        return t1;
    else
        return t2;
}