# Parsing HTML with the BeautifulSoup Module
import os
import bs4

os.chdir(os.path.join("."))

exampleFile = open('example.html')
exampleSoup = bs4.BeautifulSoup(exampleFile, features="html.parser")
print(type(exampleSoup))
# <class 'bs4.BeautifulSoup'>
print('='*30)

elems = exampleSoup.select('#author')  # also span#author
print(type(elems))
# <class 'bs4.element.ResultSet'>
print(str(elems))
# [<span id="author">Yanyan!!</span>]
print(len(elems))
# 1
print(type(elems[0]))
# <class 'bs4.element.Tag'>
print(elems[0].getText())
# Yanyan!!
print(str(elems[0]))
# <span id="author">Yanyan!!</span>
print(elems[0].attrs)
# {'id': 'author'}
print('='*30)


# Finding an Element with the select() Method
pElems = exampleSoup.select('p')
print(len(pElems))
# 3
print(str(pElems[0]))
# <p>Download the <strong>Python</strong> slides from
#       <a href="https://canvas.uccs.edu/courses/123679/modules">Canvas</a>.
#    </p>
print(pElems[0].getText())
# Download the Python slides from Canvas.
print(str(pElems[1]))
# <p class="slogan">CS 3080: Python Programming</p>
print(pElems[1].getText())
# CS 3080: Python Programming
print(str(pElems[2]))
# <p>By <span id="author">Yanyan!!</span></p>
print(pElems[2].getText())
# By Yanyan!!
print('='*30)


# Getting Data from an Element’s Attributes
spanElem = exampleSoup.select('span')[0]
print(str(spanElem))
# <span id="author">Yanyan!!</span>
print(spanElem.get('id'))
# 'author'
print(spanElem.get('some_nonexistent_addr') == None)
# True
print(spanElem.attrs)
# {'id': 'author'}
print('='*30)


pElem = exampleSoup.select('body p')
print(len(pElem))
for e in pElem:
    print(str(e))
    print(e.getText())

print('='*30)


span = exampleSoup.select('span[id]')
print(len(span))
print(str(span[0]))
print(span[0].getText())


span = exampleSoup.select('span#author')
print(len(span))
print(str(span[0]))
print(span[0].getText())


