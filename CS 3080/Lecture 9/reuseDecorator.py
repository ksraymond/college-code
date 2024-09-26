# You can now use this new decorator in other files by doing a regular import:
from decorators import doTwice

# why import decorators doesn't work?
#import decorators

@doTwice
#@decorators.doTwice
def sayWhee():
    print("Whee!")


sayWhee()

# Decorating functions with arguments
@doTwice
#@decorators.doTwice
def sayHello(name):
    print("Hello {}".format(name))


# This will break! wrapperDoTwice() takes 0 positional arguments but 1 was given
#sayHello('Bob')
