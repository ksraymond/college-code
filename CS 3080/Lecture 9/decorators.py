# Reusing decorators
# In a file called decorators.py:

def doTwice(func):
    def wrapperDoTwice():
        func()
        func()

    return wrapperDoTwice

