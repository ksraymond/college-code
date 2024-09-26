# mapIt.py - Launches a map in the browser using an address from the clipboard.
import pyperclip
import webbrowser
# Example streets
# 1420 Austen Bluffs Pkwy, Colorado Springs 80918 CO
# The University of British Columbia, Vancouver, BC, Canada V6T 1Z4
# The University of British Columbia

# Get address from clipboard.
address = pyperclip.paste()

# Replace " " to "+"
address = address.replace(" ", "+")

# Open the browser with the address.
webbrowser.open('https://www.google.com/maps/search/' + address)
