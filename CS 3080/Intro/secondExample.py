#my_decorator is a function that takes a function as an input, then that function is called within the wrapper
def my_decorator(func):
    def wrapper(): #embedded function
        print("Something is happening before the function is called.")
        func() #input for the decorator
        print("Something is happening after the function is called.")

    return wrapper
    #a variable that refers to a function, dont call the function but a reference to the function
    #this is very similar to a function pointer in C


#this basically links my_decorator with an input of say_whee
#so now, if you want to call say_whee it is linked with my_decorator
#this @ operator could be removed and instead make a variable that says "say_whee=my_decorator(say_whee)"
@my_decorator
def say_whee():
    print('Wheee!!')


say_whee()
