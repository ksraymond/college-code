# Importing modules 1
import random
print(random.randint(1, 10))

# Importing modules 2
from random import randint
print(randint(1, 10))

# Importing modules 3
from random import *
print(randint(1, 10))

# Terminate the program early
import sys
while True:
    print('Type exit to exit.')
    response = input()
    if response == 'exit':
        sys.exit()
    print('You typed ' + response + '.')
    