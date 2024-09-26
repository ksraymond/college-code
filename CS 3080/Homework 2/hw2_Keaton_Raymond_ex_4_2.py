'''
Homework 2, exercise 2
Name: Keaton Raymond
Date: 9/23/2022
Description:
    same as last program, except it has random upper and lower bounds as opposed to a single random number
'''
from random import randint

randUpper = randint(2, 20) #upper bound is from 2 to 20 because if it is 1 the lower bound cannot be any lower than the minimum
randLower = randint(1, 19) #lower bound is from 1 to 19 because if it is 20 the upper bound cannot be any higher than the maximum

#if the lower bound is higher than the upper bound, reset it until it is lower
while(randLower >= randUpper):
    randLower = randint(1, 19)
    
print("I am thinking of a range between 1 and 20. You have 10 tries.")

guessCount = 0
for i in range(10):
    #getting user guess
    print("Take a guess.")
    guess = int(input())
    guessCount += 1
    
    #check if too high, too low, or if it is correct print good job message and break out
    if(guess > randUpper):
        print("Your guess is too high.")
    elif(guess < randLower):
        print("Your guess is too low.")
    else:
        print("Good job! The range was between {} and {}. You guessed it in {} guesses!".format(randLower, randUpper, guessCount))
        break

#if they ran out of guesses, tell them the number and print a sorry message
if(guessCount == 10):
    print("Sorry, the range I was thinking of was between {} and {}".format(randLower, randUpper))