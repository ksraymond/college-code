'''
Homework 1
Name: Keaton Raymond
Date: 9/2/2022
Description:
    develop a security program
    in a while loop ask several questions
    when all of them are answered correctly by the user, a piece of secret information will be printed and the program finishes
'''
from random import randint

print("Answer all of the following questions correctly to get the secret.")
print("If any question is answered incorrectly, you must start over.")

while True:
    print("What is your name?")
    name = input()
    
    #question utilizes int() and +
    print("What is 7 + 11?")
    answer1 = int(input())
    if answer1 == (7 + 11):
        print("Correct")
    else:
        print("Incorrect")
        continue
    
    #question utilizes len()
    print("How many letters are in your name?")
    answer2 = int(input())
    if answer2 == len(name):
        print("Correct")
    else:
        print("Incorrect")
        continue
    
    #question utilizes str() and %
    print("What is the remainder of 5/3? (using integer division)")
    answer3 = input()
    if answer3 == str(5 % 3):
        print("Correct")
    else:
        print("Incorrect")
        continue
    
    #question utilizes randint()
    print("Time to flip a coin, type 1 for heads and 2 for tails.")
    answer4 = int(input())
    coinFlip = randint(1, 2)
    if coinFlip == 1:
        print("The coin landed on heads")
    elif coinFlip == 2:
        print("The coin landed on tails")
    if answer4 == coinFlip:
        print("Correct")
    else:
        print("Incorrect")
        continue
    
    #3 questions inside a for loop utilizing the iterator to choose the question
    wrongQuestion = False
    for i in range(3):
        if wrongQuestion:
            break
        if i == 0:
            print("What is 4 * 3?") #question utilizing *
            answer5 = int(input())
            if answer5 == 12:
                print("Correct")
            else:
                print("Incorrect")
                wrongQuestion = True
                continue
        elif i == 1:
            print("What is 5/2? (including decimal)") #question utilizing / and float
            answer6 = float(input())
            if answer6 == 2.5:
                print("Correct")
            else:
                print("Incorrect")
                wrongQuestion = True
                continue
        else:
            print("Don't type anything, just press enter.") #question utilizing truthy/falsey statement
            answer7 = input()
            if not answer7:
                print("Correct")
            else:
                print("Incorrect")
                wrongQuestion = True
                continue
    if wrongQuestion:
        continue
    
    print("You have answered all of the questions correctly")
    print("The secret is 'secret string'")
    break