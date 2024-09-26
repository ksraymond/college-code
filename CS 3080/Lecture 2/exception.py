def spam(divideBy):
    # A try clause can have any number of except clauses to
    # handle different exceptions, however, only one will be
    # executed in case an exception occurs.
    try:
        return 42 / divideBy
    except Exception as e:
        # every exception in Python inherits from the base Exception class
        print("Oops!", e.__class__, "occurred.")
    except ZeroDivisionError:
        print('Error: Argument cannot be a 0.')
    except TypeError:
        print('Error: Argument should be an int or a float')



#print(spam(2))
print(spam("Whee"))
#print(spam(12))
print(spam(0))
#print(spam(1))
