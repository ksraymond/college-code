class Base(object):
    pass


class Derived(Base):
    pass


print(issubclass(Derived, Base))    # True
print(issubclass(Base, Derived))  # False

d = Derived()
b = Base()

print(isinstance(d, Derived))  # True
print(isinstance(b, Base))  # True

# b is not an instance of Derived
print(isinstance(b, Derived))  # False
# But d is an instance of Base
print(isinstance(d, Base))  # True
