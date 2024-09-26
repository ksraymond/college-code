class Base1(object):
    def __init__(self):
        self.str1 = "String 1"

    def method(self):
        print("Base1 is used")


class Base2(object):
    def __init__(self):
        self.str2 = "String 2"

    def method(self):
        print("Base2 is used")


class Derived(Base1, Base2):
    def __init__(self):
        Base1.__init__(self)
        Base2.__init__(self)

    def printStrs(self):
        print(self.str1, self.str2)


ob = Derived()
ob.printStrs()      # String 1 String 2
ob.method()         # Python looks for the methods from parent class’s listed left to right.
                    # For attributes, it will be the last __init__ called.
                    # When inheriting same methods, the first base inherited is called