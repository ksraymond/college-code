# Shelve module
import shelve, os

filepath = os.path.join('.', 'mycats')
shelfFile = shelve.open(filepath)
cats = ['Zophie', 'Pooka', 'Simon']
shelfFile['cats'] = cats  # They are saved like key-value pair
shelfFile.close()

shelfFile = shelve.open(filepath)
print(type(shelfFile))
# <class 'shelve.DbfilenameShelf'>
print(shelfFile['cats'])
# ['Zophie', 'Pooka', 'Simon']
shelfFile.close()

shelfFile = shelve.open('mycats')
print(list(shelfFile.keys()))
# ['cats']
print(list(shelfFile.values()))
# [['Zophie', 'Pooka', 'Simon']]
shelfFile.close()

