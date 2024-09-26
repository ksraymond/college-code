# Finding File Sizes and Folder Contents
import os

path = "/Users/yzhuang/PycharmProjects/CS3080/Lec10/sizeContent.py"
print(os.path.getsize(path))
# 659 (in bytes)
print(os.listdir('.'))
# ['absRelative.py', 'joinSplitFiles.py', 'sizeContent.py', ...]


# Checking Path Validity
file = "/Users/yzhuang/PycharmProjects/CS3080/Lec10/sizeContent.py"
dir = "/Users/yzhuang/PycharmProjects/CS3080/Lec10/"
print(os.path.isfile(file))  # True
print(os.path.isfile(dir))  # False
print(os.path.isdir(file))  # False
print(os.path.isdir(dir))  # True
print(os.path.exists(file))  # True
print(os.path.exists(dir))  # True
print(os.path.exists("/Users/MadeUpFolder"))  # False

