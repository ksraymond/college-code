# Simple decorator
def myDecorator(func):
    def wrapper():
        print("Something is happening before the function is called.")
        func()
        print("Something is happening after the function is called.")
    return wrapper


def sayWhee():
    print("Whee!")


decoratedSayWhee = myDecorator(sayWhee)
decoratedSayWhee()
# Something is happening before the function is called.
# Whee!
# Something is happening after the function is called.
print(decoratedSayWhee)
# <function myDecorator.<locals>.wrapper at 0x10ceb6670>
print('*'*30)


# Simple decorator workflow
print(0)
def myDecorator(func):
    print(2)
    def wrapper():
        print(5)
        print("Something is happening before the function is called.")
        func()
        print(7)
        print("Something is happening after the function is called.")
    print(3)
    return wrapper


def sayWhee():
    print(6)
    print("Whee!")


print(1)
decoratedSayWhee = myDecorator(sayWhee)
print(4)
decoratedSayWhee()
print(8)
