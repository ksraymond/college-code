# Sending Special Keys
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
import time

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
driver.get('http://www.uccs.edu')

try:
    linkElem = driver.find_element(By.LINK_TEXT, 'Apply Now')
    print(type(linkElem))
    print('Clicking...')
    linkElem.send_keys(Keys.ENTER)
except:
    print('Was not able to find an element with that text.')


time.sleep(10)
