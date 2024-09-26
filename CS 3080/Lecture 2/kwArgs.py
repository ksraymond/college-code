#kwArgs = keyword arguments
def fun(a, b, c):
    return a+b+c


print(fun(1, 2, 3))


def fun(a, b):
    print('a is ' + str(a))
    print('b is ' + str(b))
    return a+b


fun(5, 10)
fun(a=5, b=10)
fun(b=10, a=5)
