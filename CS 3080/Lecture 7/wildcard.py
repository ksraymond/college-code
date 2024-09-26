import re

# The wildcard character
atRegex = re.compile(r'.at')
print(atRegex.findall('The cat in the hat sat on the flat mat. Somewhat!'))
# ['cat', 'hat', 'sat', 'lat', 'mat', 'hat']

noNewlineRegex = re.compile('.*')
print(noNewlineRegex.search('Serve the public trust.\nProtect the innocent.'
                            '\nUphold the law.').group())
# 'Serve the public trust.'
newlineRegex = re.compile('.*', re.DOTALL)
print(newlineRegex.search('Serve the public trust.\nProtect the innocent.'
                          '\nUphold the law.').group())
# 'Serve the public trust.\nProtect the innocent.\nUphold the law.'

# Matching Everything with Dot-Star
nameRegex = re.compile(r'First Name: (.*) Last Name: (.*)')
mo = nameRegex.search('First Name: Yanyan  Last Name: Zhuang_75+')
print(mo.group(1))
# 'Yanyan'
print(mo.group(2))
# 'Zhuang_75+'

# Matching Everything with Dot-Star 2
greedyRegex = re.compile(r'<.*>')
mo = greedyRegex.search('<To serve man> for dinner.>')
print(mo.group())
# '<To serve man> for dinner.>'

nongreedyRegex = re.compile(r'<.*?>')
mo = nongreedyRegex.search('<To serve man> for dinner.>')
print(mo.group())
# '<To serve man>'
