'''
Homework 2, exercise 1
Name: Keaton Raymond
Date: 9/23/2022
Description:
    Function that shows the Collatz sequence
    if number is even, then collatz() should print number // 2 and return that value
    if number is odd, then collatz() should print and return 3 * number + 1
    the user enters an integer, and the program goes through the collatz sequence until the function returns 1
    write program that lets the user enter an integer and keeps calling collatz() on that number until the function returns value 1
'''

def collatz(number):
    if number%2 == 0: #if the number is even
        newNumber = number // 2
        print(newNumber)
        return newNumber
    else:
        newNumber = 3 * number + 1
        print(newNumber)
        return newNumber

print("Enter a number:")
number = int(input())

while(number != 1):
    number = collatz(number)