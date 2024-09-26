class Test:
    def __init__(self):
        self.foo = 11
        self._bar = 23   # a hint that _bar is private, but not enforced
        self.__baz = 42  # private, but you can still mess with it


t = Test()
print(type(t))   # <class '__main__.Test'>

print(t.foo)     # 11
print(t._bar)    # 23
#print(t.__baz)   # AttributeError: 'Test' object has no attribute '__baz'

# printing attributes of object t
print(dir(t))
# ['_Test__baz', '__class__', '__delattr__', '__dict__', '__dir__',
# '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__',
# '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__',
# '__lt__', '__module__', '__ne__', '__new__', '__reduce__',
# '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__',
# '__subclasshook__', '__weakref__', '_bar', 'foo']
print(t.__dict__)
# {'foo': 11, '_bar': 23, '_Test__baz': 42}

# name mangling
print(t._Test__baz)  # 42
# to access "private" attributes, Python simply makes it hard, but not invalid
# This prevents subclass from having the same private attribute
