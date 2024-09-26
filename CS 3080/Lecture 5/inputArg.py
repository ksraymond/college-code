import sys
print('Number of arguments:', len(sys.argv), 'arguments.')
print(type(sys.argv))
print('Argument List:', str(sys.argv))

for i in range(len(sys.argv)):
    # sys.argv[i] are all strings
    print('Arg' + str(i) + ':', sys.argv[i])

