# Introspection
def sayHello(name):
    print("Inside sayHello()")
    return "Hello {}".format(name)


print(sayHello.__name__)  # sayHello


def doTwice(func):
    def wrapperDoTwice(*args, **kwargs):
        func(*args, **kwargs)
        return func(*args, **kwargs)

    return wrapperDoTwice


@doTwice
def sayHello(name):  # same as sayHello = doTwice(sayHello)
    print("Inside sayHello()")
    return "Hello {}".format(name)


print(sayHello.__name__)  # wrapperDoTwice



import functools

def doTwice(func):
    @functools.wraps(func)
    def wrapperDoTwice(*args, **kwargs):
        func(*args, **kwargs)
        return func(*args, **kwargs)

    return wrapperDoTwice


@doTwice
def sayHello(name):
    print("Inside sayHello()")
    return "Hello {}".format(name)


print(sayHello.__name__)  # sayHello

