import functools


# Decorators with arguments
def repeat(numTimes): # This is another def that handles the arguments of the decorator
    def decoratorRepeat(func):
        @functools.wraps(func)
        def wrapperRepeat(*args, **kwargs):
            for _ in range(numTimes):
                value = func(*args, **kwargs)
            return value
        return wrapperRepeat
    return decoratorRepeat


@repeat(numTimes=4)
def sayHello(name):
    print("Hello {}".format(name))


sayHello('Yanyan')
print('='*30)

@repeat
def sayHello(name):
    print(f"Hello {name}")


sayHello('Yanyan')
# wrapperRepeat is never executed


# To see it better what is doing:
def repeat(numTimes): # This is another def that handles the arguments of the decorator
    print(0, numTimes)
    def decoratorRepeat(func):
        print(2, func)
        @functools.wraps(func)
        def wrapperRepeat(*args, **kwargs):
            print(4)
            for _ in range(numTimes):
                value = func(*args, **kwargs)
            return value

        print(3)
        return wrapperRepeat
    print(1)
    return decoratorRepeat


@repeat
def sayHello(name):
    print("Hello {}".format(name))


sayHello('Yanyan')