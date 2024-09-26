'''
Homework 7, exercise 2
Name: Keaton Raymond
Date: 12/7/2022
Description:
    write a program that:
        walks through a directory tree and searches for files with a .pdf extension. 
        print these files with their absolute path and file size to the screen
        copy these files from whatever location they are in to a new folder in your current working directory called allPdfs
'''

import os
import shutil

pdfsToCopy = [] #array that stores the full filepaths to be copied
plainFilenames = [] #used in file copy loop to ensure that files are only being copied if they do not exist

#ask the user for the input path they want to walk
pathInput = input("Please input the directory you would like to walk (enter '.' to iterate through current directory): ")

#if the path exists, iterate through
if os.path.exists(pathInput):
    #walk through the parent directory
    for root, dirname, filenames in os.walk(os.path.abspath(pathInput)):
        for filename in filenames: #iterate through specifically the filenames
            if(filename.endswith('.pdf')): #if the filename is a pdf file
                filePath = os.path.abspath(os.path.join(root, filename)) #set a filepath string that is the absolute path including any subdirectories
                print(filePath)
                print(" Size: " + str(os.path.getsize(filePath)) + " bytes")
                pdfsToCopy.append(filePath) #add the full filepath to the pdfsToCopy array
                plainFilenames.append(filename) #add only the file name to the plainFilenames array
else: #if it doesn't exist, tell the user
    print("Inputted directory '{}' does not exist.".format(pathInput))

#if the allPdfs directory doesn't exist in the parent directory, then create it
if not os.path.exists('./allPdfs'):
    os.mkdir('./allPdfs')

#loop to copy all pdfs to the allPdfs folder
#this loop is needed because without it os.walk will go though the pdfs that were copied into the allPdfs folder as well
for i in range(len(pdfsToCopy)):
    if not os.path.exists(os.path.join('./allPdfs', plainFilenames[i])): #make sure that the pdf hasn't been copied yet, then add if it hasn't
        shutil.copy(pdfsToCopy[i], './allPdfs')