class Shark:
    def swim(self):
        print("The shark is swimming.")


class Clownfish:
    def swim(self):
        print("The clownfish is swimming.")


def inThePacific(fish):
    fish.swim()


sammy = Shark()
casey = Clownfish()

for fish in (sammy, casey):
    fish.swim()

for fish in (sammy, casey):
    inThePacific(fish)
