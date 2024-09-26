/*
PROGRAMMING CHALLENGE 6
apparently supposed to do the programming challenges not the 6.6 question
*/

#include <iostream>
using namespace std;

double kineticEnergy(double, double);

int main()
{
    double mass, velocity;

    cout << "Input the mass in kg: ";
    cin >> mass;
    cout << "Input the velocity in m/s: ";
    cin >> velocity;
    
    cout << "The object's kinetic energy is " << kineticEnergy(mass, velocity) << " Joules.";

    return 0;
}

double kineticEnergy(double mass, double velocity)
{
    return 0.5*mass*velocity*velocity;
}