'''
from slide 34 on the first lecture notes
requirements:
    ask user for their name and age
    tell them: length of their name
               how old they will be in a year
'''

#test loop, unrelated to the firstProgram.py
for i in range(5, -1, -1):
    print(i)

print("what is your name")
name = input()
print("how old are you")
age = int(input())

print("your name has " + str(len(name)) + " characters")
print("in 1 year you will be " + str(age + 1) + " years old")

print("your name has {} characters and in 1 year you will be {} years old".format(len(name), age+1))