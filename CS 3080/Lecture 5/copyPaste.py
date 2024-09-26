# pyperclip module
from time import sleep
import pyperclip
pyperclip.copy('Hello world!')
print(pyperclip.paste())
# 'Hello world!'
# pause for some time to copy text to clipboard
sleep(7)


# Copy this to the clipboard:
'''
Sending the output of your program to the clipboard 
will make it easy to paste it to an email, word 
processor, or some other software.
'''
print(pyperclip.paste())
