# source: https://www.toptal.com/python/python-class-attributes-an-overly-thorough-guide
class MyClass:
    class_var = 1

    def __init__(self, i_var):
        self.i_var = i_var


# Python classes and instances each have their own distinct namespaces
# represented by built-in attribute MyClass.__dict__ and myObject.__dict__
print(MyClass.__dict__)

foo = MyClass(2)
print(foo.__dict__)

# When you try to access an attribute from an object, it first looks at
# its instance namespace. If it finds the attribute, it returns the value.
print(foo.i_var)
# If not, it then looks in the class namespace and returns the attribute
# (if it’s not present, throwing an error)
print(foo.class_var)

# A class attribute set by the class: override the value for all instances
foo = MyClass(2)
print(foo.class_var)
# 1
MyClass.class_var = 2
print(foo.class_var)
# 2
print(foo.__dict__)
# {'i_var': 2}

# A class variable set by an instance: override the value only for the instance
# (essentially overrides class variable and turns it into an instance variable
# available only for that instance)
foo = MyClass(2)
print(foo.class_var)
# 1
foo.class_var = 2
print(foo.class_var)
# 2
print(foo.__dict__)
# {'i_var': 2, 'class_var': 2}
print(MyClass.class_var)
# 1
