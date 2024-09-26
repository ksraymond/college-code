import re
# Substituting Strings with the sub() Method# 1
namesRegex = re.compile(r'Agent \w+')
print(namesRegex.sub('CENSORED', 'Agent Alice gave the secret documents to Agent Bob.'))
# 'CENSORED gave the secret documents to CENSORED.'

# Substituting Strings with the sub() Method# 2
# In the first argument to sub() , you can type \1 , \2 , \3 , and so on,
# to mean "Enter the text of group 1 , 2 , 3 , and so on, in the substitution."
agentNamesRegex = re.compile(r'Agent (\w)\w*')
print(agentNamesRegex.sub(r'\1****', 'Agent Alice told Agent Carol that'
                                     ' Agent Eve knew Agent Bob was a '
                                     'double agent.'))
# A**** told C**** that E**** knew B**** was a double agent.'
