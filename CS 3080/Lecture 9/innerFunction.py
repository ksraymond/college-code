# Inner functions
def parent():
    print("Printing from the parent() function")

    def firstChild():
        print("Printing from the firstChild() function")

    def secondChild():
        print("Printing from the secondChild() function")

    secondChild()
    firstChild()


parent()
# Printing from the parent() function
# Printing from the second_child() function
# Printing from the first_child() function
print('*'*30)


# Returning Functions From Functions
def parent(num):
    def firstChild():
        return "String from the firstChild() function"

    def secondChild():
        return "String from the secondChild() function"

    if num == 1:
        return firstChild
    else:
        return secondChild


print(parent(1)())  # Printing from the firstChild() function
print(parent(2)())  # Printing from the secondChild() function

# Returning Functions From Functions 2
thisIsAReference = parent(1)
print("Now I can call the function from its reference: " + thisIsAReference())
