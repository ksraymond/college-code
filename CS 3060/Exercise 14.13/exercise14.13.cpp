/*
Keaton Raymond
CS 3060-002
Question:
    carpet calculator application
    create a class named RoomDimension that has 2 FeetInches objects as attributes:
        one for length
        one for width
    FeetInches class is described in question 11
    RoomDimension also has a multiply member function. use this function to calculate the area of the room
    the RoomDimension class should have a member function that returns the area of the room as a FeetInches object
    next create a RoomCarpet class that has a RoomDimension object as an attribute. it should also have an attribute for the cost of the carpet per square foot
    the RoomCarpet class should have a member function that returns the total cost of the carpet
    once you have written these classes, use them in an application that asks the user to enter the dimension of a room and the price per square foot of the desired carpeting. the application should display the total cost of the carpet

    FeetInches class:

*/

#include <iostream>
using namespace std;

//feet inches class from chapter 14, holds the feet and inches and has a simplify function to simplify it back down if inches > 12
class FeetInches
{
    private:
        int feet;
        int inches;

        void simplify()
        {
            if(inches >= 12)
            {
                feet += (inches/12);
                inches = inches%12;
            }
        }
    
    public:
        FeetInches(int f=0, int i=0)
        {
            feet = f;
            inches = i;
            simplify();
        }

        void setFeet(int f)
        {
            feet = f;
        }
        void setInches(int i)
        {
            inches = i;
            simplify();
        }

        int getFeet()
        {
            return feet;
        }
        int getInches()
        {
            return inches;
        }
};

//room dimensions class consisting of 2 different FeetInches objects
class RoomDimension
{
    private:
        FeetInches length;
        FeetInches width;
        FeetInches totalArea;
    
    public:
        RoomDimension(int lFeet=0, int lInch=0, int wFeet=0, int wInch=0)
        {
            length = FeetInches(lFeet, lInch);
            width = FeetInches(wFeet, wInch);
        }

        void setLength(int f, int i)
        {
            length.setFeet(f);
            length.setInches(i);
        }
        void setWidth(int f, int i)
        {
            width.setFeet(f);
            width.setInches(i);
        }

        FeetInches getLength()
        {
            return length;
        }
        FeetInches getWidth()
        {
            return width;
        }
        FeetInches getArea() //calculates the total area of the room
        {
            totalArea.setFeet(length.getFeet()*width.getFeet());
            totalArea.setInches(length.getInches()*width.getInches());

            return totalArea;
        };
};

//class for the carpet that calculates the price to carpet the room of X dimensions
class RoomCarpet
{
    private:
        RoomDimension dimensions;
        double carpetPrice;
    
    public:
        RoomCarpet(RoomDimension d, double p)
        {
            dimensions = d;
            carpetPrice = p;
        }

        void setPrice(double p)
        {
            carpetPrice = p;
        }
        void setDimensions(RoomDimension d)
        {
            dimensions = d;
        }

        double getPrice()
        {
            return carpetPrice;
        }

        double getTotalPrice()
        {
            double totalPrice = 0;
            FeetInches totalArea = dimensions.getArea();
            
            totalPrice += (totalArea.getFeet()*carpetPrice);
            totalPrice += ((totalArea.getInches()*0.0069)*carpetPrice); //0.0069 is conversion from square inches to square ft
            return totalPrice;
        }
};

int main()
{
    //test code
    RoomDimension dimensions(10, 6, 12, 6);
    double carpetPrice = 10.0;

    RoomCarpet carpet(dimensions, carpetPrice);

    cout << "total area: " << dimensions.getArea().getFeet() << " ft and " << dimensions.getArea().getInches() << " in" << endl;
    cout << "total cost: $" << carpet.getTotalPrice();


    return 0;
}