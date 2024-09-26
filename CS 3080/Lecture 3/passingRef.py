# Passing references in function arguments
def eggs(someParameter):
    someParameter.append('Hello')
    # See that we don't have any return!


spam = [1, 2, 3]
eggs(spam)

# Notice that when eggs() is called, a return value is not used to assign a
# new value to spam. Instead, it modifies the list in place, directly.
print(spam)
# [1, 2, 3, 'Hello']


def eggs_dict(someParameter):
    someParameter['name'] = 'Pooka'


dict_spam = {'age': 5, 'color': 'white'}
eggs_dict(dict_spam)
print(dict_spam)
