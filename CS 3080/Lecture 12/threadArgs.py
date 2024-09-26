# Multithreading with arguments
import threading
import time


def wakeUp(firstname, lastname, hours=8):
    time.sleep(2)
    print('Wake up {} {}! You have slept for {} hours'.format(firstname, lastname, hours))


threadObj = threading.Thread(target=wakeUp, args=('Jim', 'Carrey'), kwargs={'hours': 10})
threadObj.start()
print('New thread started.')
