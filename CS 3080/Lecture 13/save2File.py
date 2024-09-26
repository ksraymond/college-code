# Saving Downloaded Files to the Hard Drive
import requests

res = requests.get('https://automatetheboringstuff.com/files/rj.txt')
res.raise_for_status()

# Must open the file in write binary mode by passing the string 'wb'
# Even if the page is in plain-text, you need to write binary data
# in order to maintain the Unicode encoding of the text
# http://www.joelonsoftware.com/articles/Unicode.html
playFile = open('RomeoAndJuliet.txt', 'wb')

# iterate chunk by chunk by calling iter_content(),
# with a max size of the chunk being 100000
for chunk in res.iter_content(100000):
    playFile.write(chunk)

playFile.close()
