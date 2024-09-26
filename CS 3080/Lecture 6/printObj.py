class Test:
    def __init__(self, a):
        self.a = a

    def __str__(self):
        return "Test: a is {}".format(self.a)


t = Test(1234)
print(t)
print(dir(t))  # The dir() function returns all attributes and
               # methods of the specified object, without values
print(t.__dict__)  # __dict__ prints all attributes and their values in a dictionary
