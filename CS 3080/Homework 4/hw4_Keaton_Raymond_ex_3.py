'''
Homework 4, exercise 3
Name: Keaton Raymond
Date: 10/29/2022
Description:
    use regex to make sure the password string it recieves through an input arg is strong
    strong password requirements:
        at least 8 characters long
        contains both uppercase and lowercase letters
        has at least 1 digit
        assume there is no other special characters such as punctuations
'''
import re

#regex to match the password criteria given
passwordRegex = re.compile(r"^(?=.*[\d])(?=.*[A-Z])(?=.*[a-z])[\w\d]{8,}$")

#request user input password
passwordInput=input("Input the password you would like to check: ")

#if the password matches, then it is strong, otherwise it is not
if passwordRegex.match(passwordInput):
    print("Strong Password")
else:
    print("Weak Password")