class Person:
    def __init__(self, first, last):
        self.firstname = first
        self.lastname = last

    def description(self):
        return self.firstname + " " + self.lastname


class Employee(Person):
    def __init__(self, first, last, staffnum):
        Person.__init__(self, first, last)
        # or
        # super().__init__(first, last)
        self.staffnumber = staffnum

    def employeeDescription(self):
        return self.description() + ", " + self.staffnumber
        # or:
        # return Person.description(self) + ", " + self.staffnumber
        # return super().description() + ", " + self.staffnumber


marge = Person("Marge", "Simpson")
homer = Employee("Homer", "Simpson", "1007")
print(marge.description())  # Marge Simpson
print(homer.description())  # Homer Simpson
print(homer.employeeDescription())  # Homer Simpson, 1007
