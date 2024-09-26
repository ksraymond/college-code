print('Hello world!'.startswith('Hello'))
# True
print('Hello world!'.endswith('world!'))
# True
print('abc123'.startswith('abcdef'))
# False
print('abc123'.endswith('12'))
# False
print('Hello world!'.startswith('Hello world!'))
# True
print('Hello world!'.endswith('Hello world!'))
# True

print(', '.join(['cats', 'rats', 'bats']))
# 'cats, rats, bats'

print(' '.join(['My', 'name', 'is', 'Simon']))
# 'My name is Simon'

print('ABC'.join(['My', 'name', 'is', 'Simon']))
# 'MyABCnameABCisABCSimon'

print('My name is Simon'.split())
# ['My', 'name', 'is', 'Simon’]

print('MyABCnameABCisABCSimon'.split('ABC'))
# ['My', 'name', 'is', 'Simon']

print('My name is Simon'.split('m'))
# ['My na', 'e is Si', 'on']
