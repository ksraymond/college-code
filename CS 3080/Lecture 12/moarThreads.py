# Moar threads!!
import threading
import time

print('Start of program.')


def someFunc(i):
    print('    Start doing something in thread {}'.format(i))
    time.sleep(3)
    print('    Thread {} finished'.format(i))


threads = [None] * 5
for i in range(len(threads)):
    print('Main thread creating thread {}'.format(i))
    # must pass in args as an iteratable, even there's only one arg
    threads[i] = threading.Thread(target=someFunc, args=(i,))
    threads[i].start()

# do some other stuff
print()
print('*'*50)

# try commenting out this for loop and see difference
for i in range(len(threads)):
    threads[i].join()
    print('Main thread waited for thread {} to end'.format(i))

print('End of program.')
