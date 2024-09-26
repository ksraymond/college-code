# Instantiating Objects#
class Dog:

    species = 'mammal'  # Class attributes: same for all objs when creating them
                        # like static attributes of C++ and Java

    # Initializer / Instance attributes
    # Works just like a constructor
    def __init__(self, name, age):
        # "self" represents the object itself, like "this"
        # you need to declare it in the methods explicitly
        self.name = name  # attribute = input arg
        self.age = age


# When you create an object of Dog() or call its methods,
# self will be passed automatically
phil = Dog("Phil", 5)
tom = Dog("Tom", 2)
bella = Dog("Bella", 9)
lucy = Dog("Lucy", 4)


if phil.species == "mammal":
    print("{} is a {}!".format(phil.name, phil.species))
if tom.species == "mammal":
    print("{} is a {}!".format(tom.name, tom.species))


def getOldestDog(dogs):
    oldestDog = None
    for dog in dogs:
        if oldestDog is None:
            oldestDog = dog
        elif dog.age > oldestDog.age:
            oldestDog = dog
    print("The oldest dog is {0} who's {1} years old.".format(oldestDog.name, oldestDog.age))


getOldestDog([phil, tom, bella, lucy])


bella.species = "animal"   # you can change class attributes
print("{} is a {}!".format(bella.name, bella.species))
# Bella is a animal!
print("{} is a {}!".format(bella.name, Dog.species))
# Bella is a mammal!
print("{} is a {}!".format(lucy.name, lucy.species))
# Lucy is a mammal!
