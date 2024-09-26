'''
Homework 5, exercise 2
Name: Keaton Raymond
Date: 11/9/2022
Description:
    implement a generator called genRange that outputs the same as pythons built in range() function
    however, it yields individual values rather than generating a list of values to save memory
    genRange can be used as follows:
        genRange(stop)
        genRange(stop, start)
        genRange(stop, start, step)
'''
    
#range generator with passed in stop variable, default start of 0, and default step of 1
def genRange(stop, start=0, step=1):
    n = start
    while(n < stop): #while you haven't reached the stop num
        yield n #pass back the current number
        n += step #increment the current number by whatever the step is


#test case for just the stop variable
print("Test case 1")
print("range")
for i in range(10):
    print(i)
print("genRange")  
for i in genRange(10):
    print(i)

#test case for stop and start variables
print("\nTest case 2")
print("range")
for i in range(5, 10):
    print(i)
print("genRange")  
for i in genRange(10, 5):
    print(i)

#test case for stop, start, and step variables
print("\nTest case 3")
print("range")
for i in range(5, 10, 2):
    print(i)
print("genRange")  
for i in genRange(10, 5, 2):
    print(i)