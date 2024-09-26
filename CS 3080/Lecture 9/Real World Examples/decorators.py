# Reusing decorators
# In a  file called decorators.py:
import functools

def doTwice(func):
    @functools.wraps(func)
    def wrapperDoTwice(*args, **kwargs):
        func(*args, **kwargs)
        func(*args, **kwargs)

    return wrapperDoTwice
