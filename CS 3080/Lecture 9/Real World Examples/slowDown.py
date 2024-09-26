# Real world example - Slow down
# Explain that I used this decorator to make calls every 5 minutes to the server side so the server never sleep
import functools
import time


def slowDown(func):
    """Sleep 1 second before calling the function"""
    @functools.wraps(func)
    def wrapperSlowDown(*args, **kwargs):
        time.sleep(1)
        return func(*args, **kwargs)
    return wrapperSlowDown


@slowDown
def countdown(fromNumber):
    if fromNumber < 1:
        print("Liftoff!")
    else:
        print(fromNumber)
        countdown(fromNumber - 1)


countdown(5)
# 5
# 4
# 3
# 2
# 1
# Liftoff!
