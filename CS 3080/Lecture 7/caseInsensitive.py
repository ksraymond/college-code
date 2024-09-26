import re

# Case-Insensitive Matching
robocop = re.compile(r'robocop', re.I)  # Or re.IGNORECASE
print(robocop.search('RoboCop is part man, part machine.').group())
# 'RoboCop'

print(robocop.search('ROBOCOP protects the innocent.').group())
# 'ROBOCOP'

print(robocop.search('Al, why does your programming book talk about robocop so much?').group())
# 'robocop'
