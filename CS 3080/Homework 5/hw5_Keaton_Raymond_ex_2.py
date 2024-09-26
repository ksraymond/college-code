'''
Homework 5, exercise 2
Name: Keaton Raymond
Date: 11/9/2022
Description:
    use generator function to find the first n pythagorean triplets, where n is an integer. 
    a triplet (x, y, z) is called a pythagorean triplet if x*x + y*y = z*z, 
    where x/y/z are all integers (0 not included)
    
    use the integers() and take(n, seq) functions explained in class. 
'''

import math

#provided method
def integers():
    """Infinite sequence of integers."""
    i = 1
    while True:
        yield i
        i = i + 1

#provided method
def take(n, seq):
    """Returns first n values from the given sequence."""
    seq = iter(seq)  # Just in case it is an iterable object,
                            # not a generator or iterator
    result = []
    try:
        for i in range(n):
            result.append(next(seq))
    except StopIteration:
        pass
    return result


#helper method to check if x and y make a pythagorean triple
def isPYT(x, y):
    zSquared = (x**2) + (y**2)
    z = math.sqrt(zSquared)
    return z.is_integer() #if the square root of zSquared is an integer, that means that x and y form a pythagorean triple with z

#pythagorean triple generator
def pyt():
    for y in integers():
        for x in range(1, y):
            if(isPYT(x, y)): #if x and y form a pythagorean triple
                z = int(math.sqrt(x**2 + y**2)) #recalculate z
                yield ((x, y, z)) #yield the pythagorean triple as a tuple

#test case to print the first 10 pythagorean triples
print(take(10, pyt()))