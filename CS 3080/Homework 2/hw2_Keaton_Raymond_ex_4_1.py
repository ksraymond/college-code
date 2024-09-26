'''
Homework 2, exercise 4
Name: Keaton Raymond
Date: 9/23/2022
Description:
    program comes up with a random number between 1 and 20 (both inclusive), and the player has to guess it within 10 tries
    if after all 10 guesses were wrong, print a message
    tell them if their guess was too high or too low, or print a good job message
'''
from random import randint

randNum = randint(1, 20)
print("I am thinking of a number between 1 and 20. You have 10 tries.")

guessCount = 0
for i in range(10):
    #getting user guess
    print("Take a guess.")
    guess = int(input())
    guessCount += 1
    
    #check if too high, too low, or if it is correct print good job message and break out
    if(guess > randNum):
        print("Your guess is too high.")
    elif(guess < randNum):
        print("Your guess is too low.")
    else:
        print("Good job! You guessed my number in {} guesses!".format(guessCount))
        break

#if they ran out of guesses, tell them the number and print a sorry message
if(guessCount == 10):
    print("Sorry, the number I was thinking of was {}".format(randNum))