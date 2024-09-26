from random import randint
import math

n = randint(1, 10)
square = 0

for i in range(n):
    notSquare = True
    
    while(notSquare):
        root = math.sqrt(square) #find sqrt of the current number
        if (int(root + 0.5) ** 2 == square) and (square%3 != 0): #check if perfect square not not divisble by 3
            print(square)
            notSquare = False #to break out of loop
        square+=1 #check next number