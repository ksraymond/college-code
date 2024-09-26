import os


# Reading files
path = os.path.join('.', 'hello.txt')
if os.path.exists(path) and os.path.isfile(path):
    helloFile = open(path)
    print(helloFile)
# <_io.TextIOWrapper name='./hello.txt' mode='r' encoding='UTF-8'>

# Reading the Contents of Files
print(helloFile.read())
# Hello world! This is a text file.
# And this is a second line.
# Third line.
helloFile.close()

helloFile = open(path)
print(helloFile.readlines())
# ['Hello world! This is a text file.\n', 'And this is a second line.\n', 'Third line.']
helloFile.close()

helloFile = open(path)
print(helloFile.readline())
# Hello world! This is a text file.
print(helloFile.readline())
# And this is a second line.
print(helloFile.readline())
# Third line.
#print(helloFile.readline())
# will print an empty line
helloFile.close()


# DELETE bacon.txt before showing this!
# Writing to files
path = os.path.join('.', 'bacon.txt')
baconFile = open(path, 'w')
baconFile.write('Hello world!\n')
baconFile.close()

baconFile = open(path, 'w')
baconFile.write('New hello world!\n')
baconFile.close()

baconFile = open(path, 'a')
baconFile.write('Bacon is not a vegetable.')
baconFile.close()

baconFile = open(path)
content = baconFile.read()
#content = baconFile.readline()
baconFile.close()
print(content)
# New hello world!
# Bacon is not a vegetable.

