# Syntactic sugar
def myDecorator(func):
    def wrapper():
        print("Something is happening before the function is called.")
        func()
        print("Something is happening after the function is called.")
    return wrapper


@myDecorator  # Same as: sayWhee = myDecorator(sayWhee)
def sayWhee():
    print("Whee!")


sayWhee()
