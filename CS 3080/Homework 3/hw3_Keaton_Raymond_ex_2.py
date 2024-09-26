'''
Homework 3, exercise 2
Name: Keaton Raymond
Date: 10/7/2022
Description:
    given a string, count the occurrence of each unique character
    put the results into a dictionary with the key being the character, and the value being the occurrences
    finally print the dictionary
'''

import pprint

countString = "The quick brown fox jumps over the lazy dog."
charDict = {}

for letter in countString:
    if(letter in charDict.keys()):
        charDict[letter] += 1
    else:
        charDict[letter] = 1
        
pprint.pprint(charDict)