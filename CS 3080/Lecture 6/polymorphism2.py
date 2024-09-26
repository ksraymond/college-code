class Human:
    def swim(self):
        print("The human is swimming.")


class Fish:
    def swim(self):
        pass  # Note that this will return None


class Shark(Fish):
    def swim(self):
        print("The shark is swimming.")


class Clownfish(Fish):
    def swim(self):
        print("The clownfish is swimming.")


anna = Fish()
sammy = Shark()
casey = Clownfish()
bob = Human()

for animal in (anna, sammy, casey, bob):
    animal.swim()
