import threading
import time

print('Start of program.')


def takeANap():
    time.sleep(3)
    print('Wake up!')


threadObj = threading.Thread(target=takeANap)  #DO NOT use target=takeANap()
threadObj.start()
print('End of program.')

#Start of program.
#End of program.
#Wake up!

