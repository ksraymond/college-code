# Finding Patterns of Text Without Regular Expressions
def isPhoneNumber(text):
    if len(text) != 12:
        return False

    for i in range(0, 3):
        if not text[i].isdecimal():
            return False

    if text[3] != '-':
        return False

    for i in range(4, 7):
        if not text[i].isdecimal():
            return False

    if text[7] != '-':
        return False

    for i in range(8, 12):
        if not text[i].isdecimal():
            return False
    return True


print('415-555-4242 is a phone number:')
print(isPhoneNumber('415-555-4242'))
print('Moshi moshi is a phone number:')
print(isPhoneNumber('Moshi moshi'))
# 415-555-4242 is a phone number:
# True
# Moshi moshi is a phone number:
# False

# To check the whole file for a phone number
message = 'Call me at 415-555-1011 tomorrow. 415-555-9999 is my office.'
for i in range(len(message)):
    chunk = message[i:i + 12]
    if isPhoneNumber(chunk):
        print('Phone number found: ' + chunk)
print('Done')
# Phone number found: 415-555-1011
# Phone number found: 415-555-9999
# Done

# What if the number is 415.555.4242, (415) 555-4242, 415-555-4242 x99?
# The isPhoneNumber() function would fail to validate them.
# You could add yet more code for these additional patterns, but there's an easier way.
