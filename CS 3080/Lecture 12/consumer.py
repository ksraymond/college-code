# queue module - simple consumer function
# using a synchronized queue class
# https://docs.python.org/3/library/queue.html
import queue
import threading
import time
import random
import logging

logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(funcName)s - %(lineno)d - %(message)s')
# uncomment this line to suppress debug msg
#logging.disable(logging.DEBUG)


def consumer(id, q):
    """ Thread that will consume items in the queue"""
    while True:
        # Queue.get(block=True, timeout=None) remove and return an item from the queue
        # Default behavior: block if necessary until an item is available.
        item = q.get()
        logging.debug('consumer {} got {}, now: {}'.format(id, item, q.queue))
        if item is None:
            break

        # Do something with the item obtained
        time.sleep(random.randint(1, 20)/10)
        logging.debug("Item {} processed by consumer {}".format(item, id))

    logging.debug("Consumer {} shutting down".format(id))


startTime = time.perf_counter()
# Constructor for a FIFO queue in the queue module
# The queue module implements multi-producer, multi-consumer queues
# Queue object uses locks to temporarily block competing threads
q = queue.Queue()
threads = []
numThreads = 3

# Piece of code that acts as the producer
for msg in ['A', 'B', 'C', 'D', 'E', 'F']:
    # Queue.put(item, block=True, timeout=None) puts item into the queue
    # Default behavior: block if necessary until a free slot is available
    q.put(msg)
    logging.debug('after put: {}'.format(q.queue))

# Start consumers
for threadId in range(numThreads):
    threads.append(threading.Thread(target=consumer, args=(threadId, q)))
    threads[threadId].start()
    q.put(None)  # Add one sentinel at the end of the queue for consumer thread
    logging.debug('started consumer {}, queue: {}'.format(threadId, q.queue))

[thread.join() for thread in threads]

endTime = time.perf_counter()
print("Program executed in {:.4f}".format(endTime-startTime))
