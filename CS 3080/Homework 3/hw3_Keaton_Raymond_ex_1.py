'''
Homework 3, exercise 1
Name: Keaton Raymond
Date: 10/7/2022
Description:
    print out a given 2d array
'''

#initialize grid
grid = [['.', '.', '.', '.', '.', '.'], 
        ['.', 'O', 'O', '.', '.', '.'], 
        ['O', 'O', 'O', 'O', '.', '.'], 
        ['O', 'O', 'O', 'O', 'O', '.'], 
        ['.', 'O', 'O', 'O', 'O', 'O'], 
        ['O', 'O', 'O', 'O', 'O', '.'], 
        ['O', 'O', 'O', 'O', '.', '.'], 
        ['.', 'O', 'O', '.', '.', '.'], 
        ['.', '.', '.', '.', '.', '.']]


#nested for loop to print the array
for x in range(len(grid[0])):
    for y in range(len(grid)):
        print(grid[y][x], end="")
    print()