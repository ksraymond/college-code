# Lambda functions
def add(x, y):
    return x + y


print(add(5, 3))
# 8

add = lambda x, y: x + y
print(add(5, 3))
# 8

print((lambda x, y: x + y)(5, 3))
# 8


def makeAdder(n):
    # print(n)
    return lambda x: x + n


plus3 = makeAdder(3)
plus5 = makeAdder(5)
print(plus3(4))
print(plus5(4))
