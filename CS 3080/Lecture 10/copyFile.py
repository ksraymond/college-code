# Copying files and folders
import shutil, os

# manually create ./testdirectory/
source = os.path.join('.', 'myCats.py')
destination = os.path.join('.', 'testdirectory')
print(shutil.copy(source, destination))
# ./testdirectory/myCats.py
# what if testdirectory doesn't exist?

destination = os.path.join('testdirectory', 'file0.py')
print(shutil.copy(source, destination))
# testdirectory/file0.py

# manually create folder1 and delete folder2 before running this
# then comment out copytree to continue, otherwise FileExistsError
source = os.path.join('testdirectory', 'folder1')
destination = os.path.join('testdirectory', 'folder2')
print(shutil.copytree(source, destination))
# testdirectory/folder2


