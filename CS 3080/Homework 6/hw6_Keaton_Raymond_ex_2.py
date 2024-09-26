'''
Homework 6, exercise 2
Name: Keaton Raymond
Date: 11/22/2022
Description:
    implement a fibonacci sequence using a @cache decorator that saves the calculations in a dictionary 
    apply the count calls decorator from class to determine efficiency compared to a normal fibonacci function 
    without the cache dictionary
    
    do you see a difference between using the @cache and not using it? 
        Yes, as seen in the output comparison, with an input of 10, without the cache the function has 177 calls, 
        with the cache it only has 19 with the same input number.
        Another example is I tried each fibonacci function with an input number of 100. The function that used the 
        cache returned a value nearly instantaneously with 199 calls, however the function that didn't use the cache
        was running for over 15 minutes before I decided to halt the program because I had no idea how much longer it might take.
'''
import functools

#count calls decorator from class with the print statement removed, used to measure efficiency
def countCalls(func):
    @functools.wraps(func)
    def wrapperCountCalls(*args, **kwargs):
        wrapperCountCalls.numCalls += 1
        return func(*args, **kwargs)
    wrapperCountCalls.numCalls = 0
    return wrapperCountCalls

#cache function 
def cache(func):
    cacheDict = {}
    @functools.wraps(func)
    def wrapperCache(*args, **kwargs):
        if args in cacheDict: #this if statement removes the need to recalculate the number by checking the dictionary first
            return cacheDict[args]
        else: #if the value is not in the dictionary, then add it to the dict by calculating it by calling the function
            cacheDict[args] = func(*args)
            return cacheDict[args]
    return wrapperCache

#this is a test fibonacci that doesn't use a dictionary for comparison
@countCalls
def fibonacciBad(num):
    if num<2:
        return num
    return fibonacciBad(num-1)+fibonacciBad(num-2)

#the fibonacci function that uses the cache dictionary 
@countCalls
@cache
def fibonacci(num):
    if num<2:
        return num
    return fibonacci(num-1)+fibonacci(num-2)


#print statements for testing, the number for the good and bad fibonacci and the number of function calls for each
#the lower the number of function calls, the more efficient
print("bad fib num:", fibonacciBad(10))
print("number of calls for bad fib:", fibonacciBad.numCalls)
print("good fib num:", fibonacci(10))
print("number of calls for good fib:", fibonacci.numCalls)