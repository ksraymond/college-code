# Parsing HTML with the BeautifulSoup Module
import bs4
import requests

res = requests.get('https://www.uccs.edu')
res.raise_for_status()
uccsSoup = bs4.BeautifulSoup(res.text, features="html.parser")
print(type(uccsSoup))
# <class 'bs4.BeautifulSoup'>
