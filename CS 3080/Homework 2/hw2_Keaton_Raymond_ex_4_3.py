'''
Homework 2, exercise 4
Name: Keaton Raymond
Date: 9/23/2022
Description:
    same as exercise 4 part 1, except the code guesses automatically
    the automatic player still has 10 tries
    the automatic code cannot guess the same guess twice
'''
from random import randint

randNum = randint(1, 20)
print("I am thinking of a number between 1 and 20. You have 10 tries.")

guessCount = 0
guessList = [] #list to keep track of all guesses that have been made
for i in range(10):
    #getting automatic guess
    print("Take a guess.")
    
    guess = randint(1, 20) #get the random guess
    while(guess in guessList): #if the guess is in the list, then make new guesses until it isn't
        guess = randint(1, 20)
    guessList.append(guess) #add the new guess to the list
    
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