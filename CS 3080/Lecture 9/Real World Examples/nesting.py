import debug
import decorators


# Nesting decorators
@debug.debug
@decorators.doTwice
def sayHello(name):        # debug(doTwice(sayHello()))
    print("Hello {}".format(name))

sayHello('Yanyan')
#Calling sayHello('Yanyan')
#Hello Yanyan
#Hello Yanyan
#'sayHello' returned 'None'
print('='*30)

# Nesting decorators
@decorators.doTwice
@debug.debug
def sayHello(name):        # doTwice(debug(sayHello()))
    print("Hello {}".format(name))

sayHello('Yanyan')
#Calling sayHello('Yanyan')
#Hello Yanyan
#'sayHello' returned 'None'
#Calling sayHello('Yanyan')
#Hello Yanyan
#'sayHello' returned 'None'
