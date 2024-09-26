# pip install requests
import requests

res = requests.get('https://automatetheboringstuff.com/files/rj.txt')
print(type(res))  # <class 'requests.models.Response'>
print(res.status_code == requests.codes.ok)  # True
print(len(res.text))  # 178978
print(res.text[:250])
# The Project Gutenberg EBook of Romeo and Juliet, by William Shakespeare
# This eBook is for the use of anyone anywhere at no cost and with
# almost no restrictions whatsoever. You may copy it, give it away or
# re-use it under the terms of the Projec
