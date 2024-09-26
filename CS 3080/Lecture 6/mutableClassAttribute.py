# Unlike immutable types, you can change mutable class
# attributes from an instance.
class Test:
    myList = [1]


t1 = Test()
t2 = Test()

print(t1.myList, t2.myList)
print("t1", t1.__dict__)
print("t2", t2.__dict__)
print("Test", Test.__dict__)

t1.myList.append(2)
print("t1", t1.__dict__)
print("t2", t2.__dict__)
print("Test", Test.__dict__)

print(t1.myList, t2.myList)
print(Test.myList)

# The rule of thumb here is to avoid class attributes
# unless you have a reason to use them.
