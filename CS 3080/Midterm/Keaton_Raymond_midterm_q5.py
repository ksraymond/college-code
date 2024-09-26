import string

testString = "!!!!!"

#question 1

charDict = {}

#format string without the punctuation or spaces
stringQ1 = testString.translate(str.maketrans('', '', string.punctuation))
stringQ1 = testString.replace(" ", "")

#add all characters to a dictionary
for letter in stringQ1:
    if(letter in charDict.keys()):
        charDict[letter] += 1
    else:
        charDict[letter] = 1

#find the key for the max value and the occurences
maxKey = max(charDict, key=charDict.get)
maxOccurence = charDict[maxKey]

print("Key value pair for the char with most occurences:", maxKey, maxOccurence)

#question 2

#remove punctuation
stringQ2 = testString.translate(str.maketrans('', '', string.punctuation))

#split the words into a list and print
wordList = stringQ2.split()
print("Number of words: ", len(wordList))