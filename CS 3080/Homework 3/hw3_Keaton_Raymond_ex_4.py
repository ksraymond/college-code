'''
Homework 3, exercise 4
Name: Keaton Raymond
Date: 10/7/2022
Description:
    create a tic tac toe game using a dictionary
    2 player, not 1 player against machine
    don't have to check for win, just iterate until the board is full
'''

board = {"slot1": ' ', "slot2": ' ', "slot3": ' ', "slot4": ' ', "slot5": ' ', "slot6": ' ', "slot7": ' ', "slot8": ' ', "slot9": ' '}

#function to print the board with nice formatting
def printBoard(board):
    print(" {} | {} | {}".format(board["slot1"], board["slot2"], board["slot3"]))
    print("-----------")
    print(" {} | {} | {}".format(board["slot4"], board["slot5"], board["slot6"]))
    print("-----------")
    print(" {} | {} | {}".format(board["slot7"], board["slot8"], board["slot9"]))
    
#function to print the rules, helps keep playGame cleaner
def printRules():
    print("Player 1 is X's, Player 2 is Os")
    print("You will input which slot you would like to take, and an X or O will be placed there")
    print("The order of slots is as follows:")
    print(" 1 | 2 | 3")
    print("-----------")
    print(" 4 | 5 | 6")
    print("-----------")
    print(" 7 | 8 | 9")
    print()

#function to play the game
def playGame(board):
    printRules()
    turnCount = 0
    #while the board still has empty space, because don't have to check for win
    while(' ' in board.values()):
        formatSlot = "slot" #used later to index dictionary
        
        #check if it is player 1 or 2s turn
        if(turnCount %2 == 0):
            print("Player 1")
            player = 1
        else:
            print("Player 2")
            player = 2
            
        #take input, and append it to the word "slot" to index into the dict properly
        slot = input("What slot would you like? ")
        formatSlot += slot
        
        #check if they are trying to take a slot that has already been taken
        if(board[formatSlot] != ' '):
            print("Sorry, that slot is already taken. try again.")
            turnCount -= 1
        else:
            if(player == 1): #player 1 plays as X's
                board[formatSlot] = 'X'
            else: #player 2 plays as O's
                board[formatSlot] = 'O'
            print()
            printBoard(board) #print the board after each turn
            print()
        
        turnCount += 1 #go to the next turn
    print("Game Over!")

playGame(board)