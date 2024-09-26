import secondExample #import another .py file so you can use the functions within it
#the code from second example is run twice because it is run once during import, then again when we call the function

secondExample.say_whee() #call a function in the other imported .py file, very similar to C# or Java

name = ''

while name != 'Yanyan':
    print('Please enter your name:')
    name = input()

print('Hello, ' + name)

name = 3.5
print('Now name becomes ' + str(name))
