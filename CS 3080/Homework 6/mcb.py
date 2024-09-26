'''
Homework 6, exercise 3
Name: Keaton Raymond
Date: 11/22/2022
Description:
    heres what the program does: 
        1. the command line argument is checked
        2. if the argument is 'save', then the current clipboard contents are saved under the keyword after 'save'
        3. if the argument is 'list', then all the saved keywords are printed
        4. otherwise, if only one keyword is provided and no 'save' or 'list' is in the arguments, 
           the text saved under this keyword is copied to the clipboard
'''

import pyperclip
import shelve
import sys

shelf = shelve.open('exercise3Shelf')

if len(sys.argv)>1: #ensure that the user input command line args at all
    if sys.argv[1]=='save': #if the argument given is save, then save what is on the 
        if len(sys.argv)>2: #ensure the user input a key to save the clipboard under
            shelf[sys.argv[2]] = pyperclip.paste()
        else:
            print("Please input a key to save your clipboard under")
    elif sys.argv[1]=='list': #if the argument is list, then list the keys they have saved
        print(list(shelf.keys()))
    else: #if the argument is anything else, copy the contents of that key to the clipboard
        if sys.argv[1] in list(shelf.keys()): #ensure that the key given is valid
            pyperclip.copy(shelf[sys.argv[1]])
        else:
            print("Sorry, the key you have given is not saved in the shelf")
else:
    print("Please input the action you would like")

shelf.close()