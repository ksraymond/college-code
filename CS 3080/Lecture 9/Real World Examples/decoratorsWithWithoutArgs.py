import functools

def repeat(_func=None, *, numTimes=2):
    def decoratorRepeat(func):
        @functools.wraps(func)
        def wrapperRepeat(*args, **kwargs):
            for _ in range(numTimes):
                value = func(*args, **kwargs)
            return value
        return wrapperRepeat

    if _func is None:
        return decoratorRepeat
    else:
        return decoratorRepeat(_func)


# Same as: sayWhee = repeat(sayWhee)
@repeat
def sayWhee():
    print("Whee!")


# Same as: sayWhee2 = repeat(num_times=3)(sayWhee2)
@repeat(numTimes=3)
def sayWhee2():
    print("Whee2!")


sayWhee()
sayWhee2()
# Whee!
# Whee!
# Whee2!
# Whee2!
# Whee2!
