# Dictionaries vs lists
spam = ['cats', 'dogs', 'moose']
bacon = ['dogs', 'moose', 'cats']
print(spam == bacon)
# False

eggs = {'name': 'Zophie', 'species': 'cat', 'age': '8'}
ham = {'species': 'cat', 'age': '8', 'name': 'Zophie'}
print(eggs == ham)
# True


person1 = {}
person1['name'] = 'Phill'
person1['salary'] = 3500.0
person1['age'] = 22

person2 = {}
person2['age'] = 22
person2['salary'] = 3500.0
person2['name'] = 'Phill'

print(person1 == person2) # True

list1 = []
list1.append(0)
list1.append(10)
list1.append(20)

list2 = []
list2.append(10)
list2.append(20)
list2.append(0)

print(list1 == list2) # False

