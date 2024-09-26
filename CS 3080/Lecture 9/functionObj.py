# First-Class Objects
def sayHello(name):
    return "Hello {}".format(name)


def sayBye(name):
    return "Bye {}!".format(name)


def tellBob(greeter_func):
    return greeter_func("Bob")


print(tellBob(sayHello))  # 'Hello Bob'
print(tellBob(sayBye))   # 'Bye Bob!'
