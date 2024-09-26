'''
Homework 7, exercise 1
Name: Keaton Raymond
Date: 12/7/2022
Description:
    what the program should do:
        search all filenames in the current working directory for american style dates in the names
        when one is found, rename the file to make the date portion asian style (the rest of the filename doesn't change)
        (search for dates in filenames that are MM-DD-YYYY, make them YYYY-MM-DD)
'''

import os
import re
import shutil

#regex that searches for valid dates in the format MM-DD-YYYY
dateRegex = re.compile(r'''
    (0[1-9]|1[012]) #only match months for 01-12
    - #separator
    (0[1-9]|[12][0-9]|3[01]) #only match valid dates for 01-31, different cases for the tens digit so it won't match something like 39
    - #separator
    (\d{4}) #match 4 numbers for the year, assignment spec doesn't specify any numeric range restrictions, just has to be 4 numbers
    ''', re.VERBOSE)

for file in os.listdir(): #iterate through files in current working directory
    if dateRegex.search(file): #if a file contains the regex
        americanDate = dateRegex.search(file) #pull the date out of the string with the regex
        asianDate = americanDate.group(3) + '-' + americanDate.group(1) + '-' + americanDate.group(2) #use the groups for DD, MM, and YYYY to reformat the date
        shutil.move(file, file.replace(americanDate.group(), asianDate)) #rename the file that matches to a name that replaces the american formatted date to the asian formatted date