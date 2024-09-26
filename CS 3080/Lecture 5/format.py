# Useful string methods 3
def printPicnic(itemsDict, leftWidth, rightWidth):
    print('PICNIC ITEMS'.center(leftWidth + rightWidth, '-'))
    for k, v in itemsDict.items():
        print(k.ljust(leftWidth, '.') + str(v).rjust(rightWidth))


picnicItems = {'sandwiches': 4, 'apples': 12, 'cups': 4, 'cookies': 8000}

printPicnic(picnicItems, 12, 5)
printPicnic(picnicItems, 20, 6)


spam = '   Hello World   '
print(spam.strip())     # 'Hello World'
print(spam.lstrip())    # 'Hello World   '
print(spam.rstrip())    # '   Hello World’
print(spam, " string value not changed.")

spam = 'SpamSpamBaconSpamEggsSpamSpam'
print(spam.strip('ampS'))
# 'BaconSpamEggs'
print(spam, " string value not changed.")

name = 'Bob'
age = 20
print("{0} has {1}!".format(name, age))
# Bob has 20
print("{} has {}!".format(name, age))
# Bob has 20
print("{1} has {0}!".format(name, age))
# 20 has Bob
print("{name} has {age}!".format(name='Bob', age=20))
# Bob has 20
