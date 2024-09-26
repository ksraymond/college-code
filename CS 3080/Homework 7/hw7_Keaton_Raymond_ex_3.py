'''
Homework 7, exercise 3
Name: Keaton Raymond
Date: 12/7/2022
Description:
    write a multi threaded program that:
        in main thread:
            ask user to enter an integer as the total number of threads.
            if user enters a non-integer (e.g. a float or string) or an integer smaller than 2, keep asking user to re-enter until the input is an integer >= 2
            create numThreads threads using a function called someFunc(i) in a for loop
            when created, each thread is passed an argument i that is the control variable of the for loop
            after creating these threads, use join() to wait for all threads to finish IN A SEPARATE FOR LOOP
        in each new thread created, use the logging module to print all the messages with the following format, using the logging.DEBUG level:
            human readable time = line number where message is printed - the actual message
        in each new thread created
            print "Welcome thread i" (where i is argument passed in; please print i's actual value)
            print whether the number i is even or odd
            sleep 3 seconds
            print "Goodbye thread i" (print i's actual value)
'''
import threading
import time
import logging

#set the format for the logging messages
logging.basicConfig(level=logging.DEBUG,
                    format='%(asctime)s - %(lineno)d - %(message)s')

#creates thread i
def someFunc(i):
    threads[i] = threading.Thread(target=threadFunc, args=(i,))
    threads[i].start()

#each thread created calls this function to print the 3 messages
def threadFunc(i):
    logging.debug("Welcome thread {}".format(i))
    if i%2==0:
        logging.debug("Number {} is even".format(i))
    else:
        logging.debug("Number {} is odd".format(i))
    time.sleep(3)
    logging.debug("Goodbye thread {}".format(i))

#while loop checking for valid user input
while True:
    try: #need a try except to check for an integer input
        numThreads = int(input("Please enter the number of threads you would like to create: "))
        if numThreads < 2: #check that the input is 2+
            print("Please input an integer greater than or equal to 2.")
        else:
            break
    except ValueError: #if not an integer inputted, it will throw a valueError exception
        print("Please enter an integer.")

threads = [None] * numThreads #thread array
for i in range(len(threads)): #create all threads
    someFunc(i)

#wait for all threads to finish
for i in range(len(threads)):
    threads[i].join()