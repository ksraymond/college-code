# queue module - Multithreading - To show it doesn't improve in performance.
# Try different number of threads.
import queue
import threading
import time


# Use this function to actually use CPU
def wasteSomeTime(num_times):
    for _ in range(num_times):
        sum([i ** 2 for i in range(10000)])


def consumer(id, q):
    ''' Thread that will consume items in the queue'''
    while True:
        item = q.get()
        if item is None:
            break

        # Do something with the item obtained
        wasteSomeTime(100)
        print("Item {} processed".format(item))

    print("Consumer #{} shutting down".format(id))


startTime = time.perf_counter()
q = queue.Queue()
threads = []
numThreads = 8

# Piece of code that acts as the producer
for msg in ['A','B','C','D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N' , 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z']:
    q.put(msg)

# Start consumers
for threadId in range(numThreads):
    threads.append(threading.Thread(target=consumer, args=(threadId, q,)))
    threads[threadId].start()
    q.put(None)  # Add one sentinel at the end of the queue for each consumer thread

[thread.join() for thread in threads]

endTime = time.perf_counter()
print("Program executed in {:.4f}".format(endTime-startTime))
