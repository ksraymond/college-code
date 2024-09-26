# Returning Values From Decorated Functions
def doTwice(func):
    def wrapperDoTwice(*args, **kwargs):
        func(*args, **kwargs)
        func(*args, **kwargs)

    return wrapperDoTwice


@doTwice
def sayHello(name):
    return "Hello {}".format(name)


print(sayHello('Bob'))  # None


def doTwice(func):
    def wrapperDoTwice(*args, **kwargs):
        func(*args, **kwargs)
        return func(*args, **kwargs)

    return wrapperDoTwice


@doTwice
def sayHello(name):
    return "Hello {}".format(name)


print(sayHello('Bob'))  # Hello Bob, but only runs once


def doTwice(func):
    def wrapperDoTwice(*args, **kwargs):
        ret1 = func(*args, **kwargs)
        ret2 = func(*args, **kwargs)
        return ret1, ret2

    return wrapperDoTwice


@doTwice
def sayHello(name):
    return "Hello {}".format(name)


print(sayHello('Bob'))  # ('Hello Bob', 'Hello Bob')

for message in sayHello('Bob'):
    print(message)

