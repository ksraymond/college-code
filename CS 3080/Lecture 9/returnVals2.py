# Returning Values From Decorated Functions
def myDecorator(func):
    def wrapper(*args, **kwargs):
        print("Something is happening before the function is called.")
        a = func(*args, **kwargs)
        print("Something is happening after the function is called.")
        return a

    return wrapper


@myDecorator
def sayHello(name):
    print("Inside sayHello()")
    return "Hello {}".format(name)


print(sayHello("Bob"))
# Something is happening before the function is called.
# Inside sayHello()
# Something is happening after the function is called.
# Hello Bob
