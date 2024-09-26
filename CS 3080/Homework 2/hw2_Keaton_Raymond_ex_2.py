'''
Homework 2, exercise 2
Name: Keaton Raymond
Date: 9/23/2022
Description:
    add try and except statements to exercise 1 to detect if the user enters a non integer value
    normally the int() function will raise a ValueError error if it is passed a non integer string, as in int('puppy')
    in the except clause, print a message to the user saying that they must enter an integer
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

#if the user doesn't input an integer, then it throws an error message
try:
    number = int(input())
    while(number != 1):
        number = collatz(number)
except ValueError:
    print("Please input an integer")