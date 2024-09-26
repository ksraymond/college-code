def student(firstname, lastname ='Mark', standard ='Fifth'):
    print(firstname, lastname, 'is in', standard, 'grade')


student('John')

student('John', 'Gates', 'Seventh')

student('John', 'Seventh')

student('John', standard='Seventh')

#student() # Error: missing 1 required positional argument: 'firstname'

# SyntaxError: positional argument follows keyword argument
#student(firstname ='John', 'Seventh')

# TypeError: student() got an unexpected keyword argument 'subject'
#student(subject ='Maths')
