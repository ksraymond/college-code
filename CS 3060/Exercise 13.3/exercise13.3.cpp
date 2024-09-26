/*
Keaton Raymond
CS 3060-002
Question:
    write a class named Car that has the following member variables:
        yearModel - an int that holds the car's year model
        make - a string that holds the make of the car
        speed - an int that holds the car's current speed

    in addition, the class should have the following constructor and other member functions:
        constructor - the constructor should accept the car's year model and make as arguments. 
            these values should be assigned to the object's yearModel and make member vars. the constructor should also assign 0 to the speed member variable
        accessor - appropriate accessor functions to get the values stored in an object's yearModel, make, and speed member variables
        accelerate - the accelerate function should add 5 to the speed member variable each time it is called
        brake - the brake functions should subtract 5 from the speed member variable each time it is called

    demonstrate the class in a program that:
        creates a car object
        calls the accelerate function 5 times
        after each call to the accelerate function, get the current speed of the car and display it
        call the brake function 5 times
        after each call to the brake function, get the current speed of the car and display it
*/

#include <iostream>
#include <string>
using namespace std;

class Car
{
    private:
        int yearModel;
        string make;
        int speed;
    
    public:
        //constructor
        Car(int year, string makeInput)
        {
            yearModel = year;
            make = makeInput;
            speed = 0;
        }

        //getters
        int getYearModel()
        {
            return yearModel;
        }
        string getMake()
        {
            return make;
        }
        int getSpeed()
        {
            return speed;
        }

        //accelerate and brake
        void accelerate()
        {
            speed += 5;
        }
        void brake()
        {
            speed -= 5;
        }
};

int main()
{
    //instantiate car object
    Car carObject(2023, "Mustang");

    //accelerate 5 times
    for(int i=0; i<5; i++)
    {
        carObject.accelerate();
        cout << "The " << carObject.getYearModel() << " " << carObject.getMake() << " just accelerated to " << carObject.getSpeed() << "MPH.\n";
    }

    //brake 5 times
    for(int i=0; i<5; i++)
    {
        carObject.brake();
        cout << "The " << carObject.getYearModel() << " " << carObject.getMake() << " just slowed to " << carObject.getSpeed() << "MPH.\n";
    }

    return 0;
}