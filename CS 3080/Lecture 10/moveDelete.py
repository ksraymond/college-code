import shutil, os

# Moving file0 to folder1
# comment out move and delete folder1/file0.py to continue
source = os.path.join('testdirectory', 'file0.py')
destination = os.path.join('testdirectory', 'folder1/file0.py')
# If file0.py already is in folder1 (copy file0.py to testdirectory),
# then shutil.move overwrites existing file
#print(shutil.move(source, destination))
# testdirectory/folder1/file0.py


# Moving file0 to folder1 and renaming it to file9.py
# comment out move and delete folder1/file9.py to continue
source = os.path.join('testdirectory', 'file0.py')
destination = os.path.join('testdirectory', 'folder1', 'file9.py')
#print(shutil.move(source, destination))
# testdirectory/folder1/file9.py

# first delete folder2 before running this example
# Moving file0 to non-existing folder2. Now the name of the file will be folder2
# comment out move and delete folder2 to continue
source = os.path.join('testdirectory', 'file0.py')
destination = os.path.join('testdirectory', 'folder2')
#shutil.move(source, destination)

# Moving to non-existing folder10 and rename to file9.py
# comment out move to continue
source = os.path.join('testdirectory', 'file0.py')
destination = os.path.join('testdirectory', 'folder10', 'file9.py')
#shutil.move(source, destination)
# FileNotFoundError: [Errno 2] No such file or directory: 'testdirectory/folder10/file9.py'

# Removing files
path = os.path.join('testdirectory', 'folder1', 'file0.py')
#print(os.unlink(path))
# None
