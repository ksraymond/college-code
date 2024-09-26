'''
Homework 4, exercise 2
Name: Keaton Raymond
Date: 10/29/2022
Description:
    program that takes whatever text is on your clipboard and pulls out all phone numbers and email addresses
    those phone numbers and email addresses are then printed to the console and the text on your clipboard is replaced with the list
'''
import re
import pyperclip

phoneRegex = re.compile(r'''(
    (\d{3}|\(\d{3}\))?              # area code
    (\s|-|\.)?                      # separator
    \d{3}                           # first 3 digits
    (\s|-|\.)                       # separator
    \d{4}                           # last 4 digits
)''', re.VERBOSE)

emailRegex = re.compile(r'''(
    (\w|\d|\.|_|\#|\+|-)+           #username, has to have 1+ characters
    @                               #separator between username and domain
    (\w|\d|_)+                      #domain part 1, has to have 1+ characters
    \.                              #dot between domain part 1 and 2
    \w{2,4}                         #part 2 of domain matches any combo of letters with 2-4 characters because that matches almost all possibilities from .co to .live
)''', re.VERBOSE)

#get an iterator of all matches for the phone number and email regexes
phoneMatches = phoneRegex.finditer(pyperclip.paste())
mailMatches = emailRegex.finditer(pyperclip.paste())

#initialize string for the phone numbers and emails for use later
#will be used to replace text in the clipboard
mailAndPhoneString = ""

#iterate through the email address matches
print("All email addresses:")
for match in mailMatches:
    print(match.group()) #print the match to the console
    mailAndPhoneString += match.group() #add the match to the mail string
    mailAndPhoneString += '\n' #add new line for better formatting
    
#iterate through phone number matches
print("\nAll phone numbers:")
for match in phoneMatches:
    print(match.group())
    mailAndPhoneString += match.group()
    mailAndPhoneString += '\n'

#replace the text on clipboard with the string that has just the emails and phone numbers
pyperclip.copy(mailAndPhoneString)