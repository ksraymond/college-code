import re

# Matching Specific Repetitions with Curly Brackets
haRegex = re.compile(r'(Ha){3}')
mo1 = haRegex.search('HaHaHa')
print(mo1.group())
# 'HaHaHa'
mo2 = haRegex.search('Ha')
print(mo2 == None)
# True

mo = haRegex.search("HaHaHaHaaa")
print(mo.group(0))
# HaHaHa
print(mo.group(1))
# Ha
#print(mo.group(2)) # IndexError: no such group

haRegex = re.compile(r'(Ha)(Ha)(Ha)')
mo = haRegex.search("HaHaHaHaaa")
print(mo.group(0)) # HaHaHa
print(mo.group(1)) # Ha
print(mo.group(2)) # Ha
print(mo.group(3)) # Ha

# Greedy and Nongreedy Matching
greedyHaRegex = re.compile(r'(Ha){3,5}')
mo1 = greedyHaRegex.search('HaHaHaHaHa')
print(mo1.group())
# 'HaHaHaHaHa' even if it could also be 'HaHaHa' or 'HaHaHaHa'
# (Ha){3,} will match three or more instances of the (Ha) group,
# (Ha){,5} will match zero to five instances

nongreedyHaRegex = re.compile(r'(Ha){3,5}?')
mo2 = nongreedyHaRegex.search('HaHaHaHaHa')
print(mo2.group())
# 'HaHaHa'
