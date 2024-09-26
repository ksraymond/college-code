'''
Homework 4, exercise 1
Name: Keaton Raymond
Date: 10/29/2022
Description:
    write 3 classes:
        rectangle constructed by length and width
        circle constructed by radius
        square constructed by a side length
    methods for all classes
        area
        diagonal of rectangle or square and diameter of circle
        perimeter
    calculate perimeter of circle with radius that is half of diagonal of rectangle with length 20 and width 10
'''
from math import *

#rectangle class to compute area, perimeter, and length of diagonal
class Rectangle:
    def __init__(self, length, width):
        self.length = length
        self.width = width
    
    #compute area
    def area(self):
        return self.length*self.width
    
    #compute perimeter
    def perimeter(self):
        return (2*self.length)+(2*self.width)
    
    #compute diagonal
    def diagonal(self):
        return sqrt((self.length*self.length)+(self.width*self.width))

#all square methods are same as rectangle methods but with same length sides
#so use inheritance with the length and width equal to the same side length
class Square(Rectangle):
    def __init__(self, side):
        super().__init__(side, side)

#pi is a constant that is imported from the math module
class Circle:
    def __init__ (self, radius):
        self.radius = radius
    
    #compute area
    def area(self):
        return pi*self.radius*self.radius
    
    #compute diameter
    def diameter(self):
        return 2*self.radius
    
    #compute perimeter/circumference
    def perimeter(self):
        return 2*pi*self.radius
    
#calculate perimeter of circle with radius that is half of diagonal of rectangle with length 20 and width 10
rect = Rectangle(20, 10) #rectangle with l=20, w=10
halfDiag = rect.diagonal()/2 #calculate diagonal and divide by 2
circ = Circle(halfDiag) #create circle object with a radius that is half of the diagonal
print("Perimeter of a circle with a radius equal to half the diagonal of a rectangle with length 20 and width 10")
print(circ.perimeter()) #calculate the perimeter/circumference