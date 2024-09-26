# Define a string variable with value 'Hello World!'. 
# Create an @uppercase decorator that will convert this string to all uppercase 'HELLO WORLD!'. 
# Note: you cannot hard code 'HELLO WORLD!' in the decorator.

# Use a regular function printStr() that prints your string variable, 
# and it will be decorated with your @uppercase decorator. 
# Call the decorated printStr() to test your result.

helloWorld = "Hello World!"


def uppercase(func):
    def wrapper():
        original_result = func()
        modified_result = original_result.upper()
        return modified_result
    return wrapper


@uppercase
def printStr():
    return helloWorld


print(printStr())