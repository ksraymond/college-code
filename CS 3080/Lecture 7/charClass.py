import re

# Character class example
xmasRegex = re.compile(r'\d+\s\w+')
print(xmasRegex.findall('12 drummers, 11 pipers, 10 lords, 9 ladies, '
                  '8 maids, 7 swans, 6 geese, 5 rings, 4 birds, '
                  '3 hens, 2 doves, 1 partridge'))
# ['12 drummers', '11 pipers', '10 lords', '9 ladies', '8 maids',
#  '7 swans', '6 geese', '5 rings', '4 birds', '3 hens', '2 doves',
#  '1 partridge']

num = re.compile(r'[0-5.]')  # same effect as r'[0-5\.]'
print(num.findall('100.05'))
# ['1', '0', '0', '.', '0', '5']

# Making Your Own Character Classes
vowelRegex = re.compile(r'[aeiouAEIOU]')
print(vowelRegex.findall('RoboCop eats baby food. BABY FOOD.'))
# ['o', 'o', 'o', 'e', 'a', 'a', 'o', 'o', 'A', 'O', 'O']

# Making Your Own Character Classes 2
consonantRegex = re.compile(r'[^aeiouAEIOU]')
print(consonantRegex.findall('RoboCop eats baby food. BABY FOOD.'))
# ['R', 'b', 'c', 'p', ' ', 't', 's', ' ', 'b', 'b', 'y', ' ',
# 'f', 'd', '.', 'B', 'B', 'Y', ' ', 'F', 'D', '.']

# The Caret and Dollar Sign Characters
beginsWithHello = re.compile(r'^Hello')
mo = beginsWithHello.search('Hello world!')
print(mo.group())
# Hello
print(beginsWithHello.search('He said Hello.') == None)
# True

endsWithNumber = re.compile(r'\d$')
mo = endsWithNumber.search('Your number is 42')
print(mo.group())
# 2
print(endsWithNumber.search('Your number is forty two.') == None)
# True

wholeStringIsNum = re.compile(r'^\d+$')
mo = wholeStringIsNum.search('1234567890')
print(mo.group())
# 1234567890
print(wholeStringIsNum.search('12345xyz67890') == None)
# True
print(wholeStringIsNum.search('12 34567890') is None)
# True
