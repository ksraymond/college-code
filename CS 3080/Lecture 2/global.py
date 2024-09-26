def spam():
    #global eggs # In this function, eggs refers to the global
                # variable, so don’t create a local variable with
                # this name.

    eggs = 'spam'
    print(eggs)


eggs = 'global'
spam()
print(eggs)
