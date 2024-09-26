# Dictionary methods
spam = {'color': 'red', 'age': 42}
print(spam.values())
# dict_values(['red', 42])
print(list(spam.values()))
# ['red', 42]


for v in spam.values():
    print(v)
# red
# 42


for k in spam.keys():
    print(k)
# color
# age


for i in spam.items():
    print(i)
# ('color', 'red')
# ('age', 42)


spam = {'color': 'red', 'age': 42}
for k, v in spam.items():
    print('Key: ' + k + ', Value: ' + str(v))
# Key: age, Value: 42
# Key: color, Value: red


# get()
picnicItems = {'apples': 5, 'cups': 2}
print('I am bringing ' + str(picnicItems.get('cups', 0)) + ' cups.')
# 'I am bringing 2 cups.'
print('I am bringing ' + str(picnicItems.get('eggs', 0)) + ' eggs.')
# 'I am bringing 0 eggs.'


# myDict['key']
picnicItems = {'apples': 5, 'cups': 2}
#print('I am bringing ' + str(picnicItems['eggs']) + ' eggs.')
# KeyError: 'eggs'


# setDefault
spam = {'name': 'Pooka', 'age': 5}
if 'color' not in spam:
    spam['color'] = 'black'
print(spam)


spam = {'name': 'Pooka', 'age': 5}
print(spam.setdefault('color', 'black'))
# 'black'
print(spam)
# {'color': 'black', 'age': 5, 'name': 'Pooka'}

print(spam.setdefault('color', 'white'))
# 'black'
print(spam)
# {'color': 'black', 'age': 5, 'name': 'Pooka'}

