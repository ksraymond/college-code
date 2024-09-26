import functools


def countCalls(func):
    @functools.wraps(func)
    def wrapperCountCalls(*args, **kwargs):
        wrapperCountCalls.numCalls += 1
        print("Call {} of {}".format(wrapperCountCalls.numCalls, func.__name__))
        return func(*args, **kwargs)

    wrapperCountCalls.numCalls = 0
    return wrapperCountCalls


@countCalls
def passFunc():
    pass


passFunc()  # Call 1 of 'passFunc'
passFunc()  # Call 2 of 'passFunc'
print(passFunc.numCalls)  # 2