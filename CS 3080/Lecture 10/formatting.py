# Saving Variables with the pprint.pformat() Function
import pprint, os

filepath = os.path.join('.', 'myCats.py')
cats = [{'name': 'Zophie', 'desc': 'chubby'}, {'name': 'Pooka', 'desc': 'fluffy'}, ]
print(pprint.pformat(cats))
# "[{'desc': 'chubby', 'name': 'Zophie'}, {'desc': 'fluffy', 'name': 'Pooka'}]"

fileObj = open(filepath, 'w')
fileObj.write('cats = ' + pprint.pformat(cats) + '\n')
fileObj.close()


# Saving Variables with the pprint.pformat() Function
import myCats
print(myCats.cats)
# [{'desc': 'chubby', 'name': 'Zophie'}, {'desc': 'fluffy', 'name': 'Pooka'}]

print(myCats.cats[0])
# {'desc': 'chubby', 'name': 'Zophie'}
print(myCats.cats[0]['name'])
# 'Zophie'

