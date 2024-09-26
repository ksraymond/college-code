# Checking for Errors
import requests

res = requests.get('http://inventwithpython.com/page_that_does_not_exist')
print(res.text)
#res.raise_for_status()
# raise HTTPError(http_error_msg, response=self)
# requests.exceptions.HTTPError: 404 Client Error:
# Not Found for url: http://inventwithpython.com/page_that_does_not_exist


# Checking for Errors 2
res = requests.get('http://inventwithpython.com/page_that_does_not_exist')
try:
    res.raise_for_status()
except Exception as exc:
    print('There was a problem:\n{}'.format(exc))
# There was a problem: 404 Client Error:
# Not Found for url: http://inventwithpython.com/page_that_does_not_exist

