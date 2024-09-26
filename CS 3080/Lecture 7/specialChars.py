import re

# Matching multiple patterns with Pipe
heroRegex = re.compile(r'Batman|Tina Fey')
# the first occurrence of matching text will be returned
mo1 = heroRegex.search('Batman and Tina Fey.')
print(mo1.group())
# 'Batman'
mo2 = heroRegex.search('Tina Fey and Batman.')
print(mo2.group())
# 'Tina Fey'

mo3 = heroRegex.findall('Tina Fey and Batman.')
print(mo3)
# ['Tina Fey', 'Batman']

# Matching multiple patterns with Pipe 2
batRegex = re.compile(r'Bat(man|mobile|copter|bat)')
mo = batRegex.search('Batmobile lost a wheel')

# mo.group() returns full matched text 'Batmobile’,
# while mo.group(1) returns just part of the matched
# text inside the first parentheses group
print(mo.group())
# 'Batmobile'
print(mo.group(1))
# 'mobile'

# Optional Matching with the Question Mark
batRegex = re.compile(r'Bat(wo)?man')
mo1 = batRegex.search('The Adventures of Batman')
print(mo1.group())
# 'Batman'
mo2 = batRegex.search('The Adventures of Batwoman')
print(mo2.group())
# 'Batwoman'

phoneRegex = re.compile(r'(\d\d\d-)?\d\d\d-\d\d\d\d')
mo1 = phoneRegex.search('My number is 415-555-4242')
print(mo1.group())
# '415-555-4242'
mo2 = phoneRegex.search('My number is 555-4242')
print(mo2.group())
# '555-4242'

# Matching Zero or More with the Star
batRegex = re.compile(r'Bat(wo)*man')
mo1 = batRegex.search('The Adventures of Batman')
print(mo1.group())
# 'Batman'
mo2 = batRegex.search('The Adventures of Batwoman')
print(mo2.group())
# 'Batwoman'
mo3 = batRegex.search('The Adventures of Batwowowowoman')
print(mo3.group())
# 'Batwowowowoman'

# Matching One or More with the Plus
batRegex = re.compile(r'Bat(wo)+man')
mo1 = batRegex.search('The Adventures of Batwoman')
print(mo1.group())
# 'Batwoman'
mo2 = batRegex.search('The Adventures of Batwowowowoman')
print(mo2.group())
# 'Batwowowowoman'
mo3 = batRegex.search('The Adventures of Batman')
print(mo3 is None)
# True
