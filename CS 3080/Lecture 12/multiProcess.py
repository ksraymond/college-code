# Multiprocessing
import multiprocessing
import time

# Use this function to actually use CPU
def wasteSomeTime(num_times):
    for _ in range(num_times):
        sum([i ** 2 for i in range(10000)])


def worker(id, q):
    """ Thread that will consume items in the queue"""
    while True:
        item = q.get()
        if item is None:
            break

        # Do something with the item obtained
        wasteSomeTime(100)
        print("Item {} processed".format(item))

    print("Consumer #{} shutting down".format(id))


# On some OSes (Windows, Mac) the subprocesses will import (i.e. execute)
# the main module at start. if __name__ == '__main__' is a guard to avoid
# creating subprocesses recursively, and sometimes getting a RuntimeError:
# "An attempt has been made to start a new process before the
# current process has finished its bootstrapping phase."
# https://stackoverflow.com/questions/18204782/
if __name__ == '__main__':
    startTime = time.perf_counter()
    q = multiprocessing.Queue()
    processes = []
    numProcesses = 8

    # Piece of code that acts as the producer
    for msg in ['A','B','C','D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N' , 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z']:
        q.put(msg)

    # Start consumers
    for processId in range(numProcesses):
        processes.append(multiprocessing.Process(target=worker, args=(processId, q,)))
        processes[processId].start()
        q.put(None)  # Add one sentinel at the end of the queue for each consumer thread

    [process.join() for process in processes]

    endTime = time.perf_counter()
    print("Program executed in {:.4f}".format(endTime-startTime))
