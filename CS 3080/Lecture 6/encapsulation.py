"""
Read more about it here
https://dbader.org/blog/meaning-of-underscores-in-python
"""


# Public Attributes
class PublicEmployee:
    def __init__(self, name, sal):
        self.name = name
        self.salary = sal


print('PublicEmployee'.center(30, '='))
employee = PublicEmployee('Homer', 1000)
print(employee.name + ' salary (before): ' + str(employee.salary))
employee.salary = 1500
print(employee.name + ' salary (after): ' + str(employee.salary))


# Protected Attributes
class ProtectedEmployee:
    def __init__(self, name, sal):
        self._name = name  # protected attribute
        self._salary = sal # protected attribute


print('ProtectedEmployee'.center(30, '='))
employee = ProtectedEmployee('Bart', 1000)
print(employee._name + ' salary (before): ' + str(employee._salary))
employee._salary = 1500
print(employee._name + ' salary (after): ' + str(employee._salary))


# Private Attributes
class PrivateEmployee:
    def __init__(self, name, sal):
        self.__name = name  # private attribute
        self.__salary = sal # private attribute


print('PrivateEmployee'.center(30, '='))
employee = PrivateEmployee('Lisa', 1000)
#print(employee.__name + ' salary (before): ' + str(employee.__salary))
# AttributeError: 'PrivateEmployee' object has no attribute '__name'
print(dir(employee))
employee._PrivateEmployee__salary = 1500
print(employee._PrivateEmployee__name + ' salary (after): ' \
      + str(employee._PrivateEmployee__salary))
