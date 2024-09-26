import os

print(os.path.join('Users','johndoe','UCCS'))
# 'Users/johndoe/UCCS' on OS X, Linux
# 'Users\\johndoe\\UCCS' on Windows

print(os.path.sep) # Correct folder-separating slash for the computer running the program
# / on OS X, Linux
# \\ on Windows

path = "/Users/johndoe/Documents/UCCS/CS_3080_Python/Lectures/test.py"
print(path.split(os.path.sep))
# on OS X, Linux:
# ['', 'Users', 'johndoe', 'Documents', 'UCCS', 'CS_3080_Python', 'Lectures', 'test.py']


files = ['students.docx', 'account.txt', 'details.csv']
for file in files:
    print(os.path.join('Users', 'johndoe', 'Documents', file))
# Users/johndoe/Documents/students.docx
# Users/johndoe/Documents/account.txt
# Users/johndoe/Documents/details.csv

print(os.getcwd())
# Should return the current dir that this code is in
# /Users/yzhuang/PycharmProjects/CS3080/Lec10
os.chdir(os.path.join('/Users','yzhuang', 'Downloads'))
print(os.getcwd())
# /Users/yzhuang/Downloads

#os.chdir(os.path.join('/Users','nonExistingUser', 'Downloads'))
# Traceback (most recent call last):
#   File "/Users/yyzh/PycharmProjects/CS3080/Lec10/joinSplitFiles.py", line 31, in <module>
#     os.chdir(os.path.join('/Users','nonExistingUser', 'Downloads'))
# FileNotFoundError: [Errno 2] No such file or directory: '/Users/nonExistingUser/Downloads'

os.makedirs(os.path.join('.', 'lectures', 'lecture10', 'testfolder', 'subfolder'))
# 'lectures/lecture10/testfolder/subfolder' will be created under /Users/yzhuang/Downloads
# Delete this directory before running this code again
