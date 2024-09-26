# Real world examples - Timer
import functools
import time


def timer(func):
    """Print the runtime of the decorated function"""

    @functools.wraps(func)
    def wrapperTimer(*args, **kwargs):
        startTime = time.perf_counter()
        value = func(*args, **kwargs)
        endTime = time.perf_counter()
        runTime = endTime - startTime
        print("Finished '{}' in {:.4f} secs".format(func.__name__, runTime))
        return value

    return wrapperTimer


@timer
def wasteSomeTime(num_times):
    for _ in range(num_times):
        sum([i ** 2 for i in range(10000)])


wasteSomeTime(10)  # Finished 'wasteSomeTime' in 0.0494 secs
wasteSomeTime(100)  # Finished 'wasteSomeTime' in 0.4371 secs
