# Create two threads. 
# One thread is created using a function called printCubes(n) that prints the first n cubes 
# (e.g., if n=3, it prints 1, 8, 27). 
# The second thread is created using a function called printSquares(n) 
# that prints the first n squares (e.g., if n=3, it prints 1, 4, 9). 
# n is a random integer between 10 and 20 (both inclusive). 
# Do not hard code the value of n. Use the same n value to pass to these two threads. 

# Make sure two threads using printCubes(n) and printSquares(n) 
# are NOT printing values in a random order. If you call printCubes(n) and printSquares(n) as 
# functions instead of creating threads, you will lose at least 20pts.

# Within each thread, also use the time module to measure how long each thread takes 
# from start to finish, and print the execution time with 4 decimal points. An example output:

# The first 12 cubes: 1 8 27 64 125 216 343 512 729 1000 1331 1728 
# printCube(12) took 0.0004 secs to finish
# The first 12 squares: 1 4 9 16 25 36 49 64 81 100 121 144 
# printSquare(12) took 0.0002 secs to finish


'''
NOTE ON THE TIME TO FINISH
i tested it with time.sleep() statements and the time is accurate,
but at least in testing, it sometimes finished in less than 0.0001 seconds 
resulting in it saying it finished in 0.0000 seconds
'''

import time, threading, random

n = random.randint(10, 20)

threads = [None] * 2 #thread array

def printCubes(n):
    start = time.time()
    print("the first {} cubes:".format(n), end=' ')
    for i in range(1, n):
        result = i*i*i
        print(result, end=' ')
    end = time.time()
    print("\nprintCubes({}) took {:.4f} seconds to finish".format(n, end-start))

def printSquares(n):
    start = time.time()
    print("the first {} squares:".format(n), end=' ')
    for i in range(1, n):
        result = i*i
        print(result, end=' ')
    end = time.time()
    print("\nprintSquares({}) took {:.4f} seconds to finish".format(n, end-start))


threads[0] = threading.Thread(target=printCubes, args=(n,))
threads[0].start()

threads[0].join() #without this, it just prints both outputs intertwined, makes sure that it prints one thread then the next

threads[1] = threading.Thread(target=printSquares, args=(n,))
threads[1].start()