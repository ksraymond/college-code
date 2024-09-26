# Starting a Selenium-Controlled Browser
# https://stackoverflow.com/questions/40208051/selenium-using-python-geckodriver-executable-needs-to-be-in-path
# General guide:
# https://selenium-python.readthedocs.io/installation.html

from selenium import webdriver
from selenium.webdriver.common.by import By
# To solve "SessionNotCreatedException: Message: session not created:
# This version of ChromeDriver only supports Chrome version XXX"
from webdriver_manager.chrome import ChromeDriverManager
# To solve "DeprecationWarning: executable_path has been deprecated selenium python"
from selenium.webdriver.chrome.service import Service
# Very un-elegant workaround for click() is to sleep and wait for page to load
import time


driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
print(type(driver))
# <class 'selenium.webdriver.chrome.webdriver.WebDriver'>
driver.get('https://www.uccs.edu')

try:
    elem = driver.find_element(By.CLASS_NAME, 'uccs-sp-hero-img')
    print(type(elem))
    print('Found <{}> element with class name {}!'.format(elem.tag_name, 'uccs-sp-hero-img'))
except:
    print('Was not able to find an element with that name.')


try:
    linkElem = driver.find_element(By.LINK_TEXT, 'Apply Now')
    print(type(linkElem))
    print('Found <{}> element with text {}! Clicking...'.format(linkElem.tag_name, 'Apply Now'))
    linkElem.click()
except:
    print('Was not able to find an element with that text.')


# Very un-elegant workaround if you don't like to learn JavaScript
# https://stackoverflow.com/questions/8832858/using-python-bindings-selenium-webdriver-click-is-not-working-sometimes
time.sleep(10)

# And now output all the available cookies for the current URL
#for cookie in driver.get_cookies():
#    print(cookie)
