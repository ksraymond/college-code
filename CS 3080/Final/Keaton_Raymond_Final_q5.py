# Generate a random integer between 1 and 10 (both inclusive) 
# and store it in a variable n. Do not hard code n. 
# Use a Generator function (NOT an object/class or a generator expression) \
# to generate the first n negative odd numbers starting from -1. For example, your output for n = 5 would be:

# The first 5 negative odd numbers are: -1 -3 -5 -7 -9

import random

def negInt(n):
    i = -1 #initialize i to be -1, then just subtract 2 each time. will always yield the next negative odd num
    for j in range(n):
        yield i
        i = i - 2

n = random.randint(1, 10)

listNum = negInt(n)

for i in range(n):
    print(next(listNum), end=' ')