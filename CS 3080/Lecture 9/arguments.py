# Decorating functions with arguments
def myDecorator(func):
    def wrapper(*args, **kwargs):
        print("Something is happening before the function is called.")
        func(*args, **kwargs)
        print("Something is happening after the function is called.")

    return wrapper


def sayHello(name):
    print("Hello {}".format(name))


var = myDecorator(sayHello)
var("Bob")
# Something is happening before the function is called.
# Hello Bob
# Something is happening after the function is called.
print('x'*30)


def doTwice(func):
    def wrapperDoTwice(*args, **kwargs):
        func(*args, **kwargs)
        func(*args, **kwargs)

    return wrapperDoTwice


@doTwice
def sayHello(name):
    print("Hello {}".format(name))


@doTwice
def sayWhee():
    print("Whee!")

sayWhee()
sayHello("Bob")
# Whee!
# Whee!
# Hello Bob
# Hello Bob
