# Threads with a race condition
import threading
import time

print('Start of program.')
myList = []


def raceFunc(i):
    myList.append(i)
    # address of list: hex(id(myList)) - try to print it!
    print('    Start doing something in thread {}, '
          'with list {} (at {})'.format(i, myList, hex(id(myList))))
    time.sleep(3)
    # I want thread i to read back the same myList as line 12/13 but...
    print('    Thread {} finished with list {}'.format(i, myList))


threads = [None] * 5
for i in range(len(threads)):
    threads[i] = threading.Thread(target=raceFunc, args=(i,))
    threads[i].start()

# do some other stuff
print()   # print an empty line
print('*' * 50)

[thread.join() for thread in threads]
print('End of program.')
