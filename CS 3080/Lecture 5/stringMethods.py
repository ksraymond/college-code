# Useful string methods 1
spam = 'Hello world!'
print(spam.islower())
# False
print(spam.isupper())
# False
print('HELLO'.isupper())
# True
print('abc12345'.islower())
# True
print('12345'.islower())
# False
print('12345'.isupper())
# False


print('Hello'.upper())
# 'HELLO'
print('Hello'.upper().lower())
# 'hello'
print('Hello'.upper().lower().upper())
# 'HELLO'
print('HELLO'.lower())
# 'hello'
print('HELLO'.lower().islower())
# True


print('hello'.isalpha())
# True
print('hello123'.isalpha())
# False
print('hello123'.isalnum())
# True
print('hello'.isalnum())
# True
print('123'.isdecimal())
# True
print(' '.isspace())
# True
print('This Is Title Case'.istitle())
# True
print('This Is Title Case 123'.istitle())
# True
print('This Is not Title Case'.istitle())
# False
print('This Is NOT Title Case Either'.istitle())
# False
