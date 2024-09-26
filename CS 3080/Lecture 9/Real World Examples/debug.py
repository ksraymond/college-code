# Real world examples - Debug
import functools


def debug(func):
    """Print the function signature and return value"""
    @functools.wraps(func)
    def wrapperDebug(*args, **kwargs):
        # Create a list of the positional arguments. Use repr() to get a nice string representing each argument.
        argsRepr = [repr(a) for a in args]
        # !r specifier means that repr() is used to represent the value.
        kwargsRepr = ["{}={}".format(k, repr(v)) for k, v in kwargs.items()]
        signature = ", ".join(argsRepr + kwargsRepr)
        print("Calling {}({})".format(func.__name__, signature))
        value = func(*args, **kwargs)
        print("'{}' returned '{}'".format(func.__name__, value))
        return value
    return wrapperDebug


@debug
def wasteSomeTime(numTimes):
    for _ in range(numTimes):
        sum([i**2 for i in range(10000)])


if __name__ == "__main__":
    wasteSomeTime(10)
    # Calling waste_some_time(10)
    # 'waste_some_time' returned None
