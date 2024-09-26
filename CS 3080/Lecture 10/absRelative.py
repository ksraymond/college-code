# Handling absolute and relative paths
import os

print(os.path.abspath('.'))
# /Users/yzhuang/PycharmProjects/CS3080/Lec10
print(os.path.abspath(os.path.join('.','lectures','lecture10')))
# /Users/yzhuang/PycharmProjects/CS3080/Lec10/lectures/lecture10
print(os.path.isabs('.'))
# False, it is relative!
print(os.path.isabs(os.path.abspath('.')))
# True, now it is absolute


# How to relatively go from the second path to the first path
print(os.path.relpath(os.path.join('Users', 'johndoe', 'Documents', 'UCCS'),
                      os.path.join('Users', 'johndoe')))
# Documents/UCCS
print(os.path.relpath(os.path.join('Users', 'johndoe', 'Downloads'),
                      os.path.join('Users', 'johndoe', 'Documents', 'UCCS')))
# ../../Downloads

path = os.path.join(os.path.abspath('.'), 'test.py')
print(path)
# /Users/yzhuang/PycharmProjects/CS3080/Lec10/test.py
print(os.path.dirname(path))
# /Users/yzhuang/PycharmProjects/CS3080/Lec10
print(os.path.basename(path))
# test.py
print(os.path.split(path))
# ('/Users/yyzh/PycharmProjects/CS3080/Lec10', 'test.py')

