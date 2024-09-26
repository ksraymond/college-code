# Sync the threads
import threading
import time

print('Start of program.')


def someFunc():
    print('Doing something in an async thread')
    time.sleep(5)
    print('Async thread finished')


threadObj = threading.Thread(target=someFunc)
threadObj.start()

print('Doing something in the main thread')
time.sleep(2)
print('Main thread task finished. Wait for the async thread to finish.')

threadObj.join()

print('End of program.')


# Start of program.
# Doing something in an async thread
# Doing something in the main thread
# Main thread task finished
# Wait for the async thread to finish
# Async thread finished
# End of program.
