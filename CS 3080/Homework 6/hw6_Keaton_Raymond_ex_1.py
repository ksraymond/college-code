'''
Homework 6, exercise 1
Name: Keaton Raymond
Date: 11/22/2022
Description:
    modify the @slowDown decorator given in class to accept an optional rate argument
    the optional rate argument controls how long in seconds it sleeps and has a default value of 1
'''

import functools
import time


def slowDown(rate=1): #optional argument rate has a defualt value of 1
    def myDecorator(func):
        """Sleep 1 second before calling the function"""
        @functools.wraps(func)
        def wrapperSlowDown(*args, **kwargs):
            time.sleep(rate)
            return func(*args, **kwargs)
        return wrapperSlowDown
    return myDecorator


@slowDown(3) #set the rate parameter to 3
def countdown(fromNumber):
    if fromNumber < 1:
        print("Liftoff!")
    else:
        print(fromNumber)
        countdown(fromNumber - 1)
     
#countdown from 5 with the delay of 3 seconds set above   
countdown(5)