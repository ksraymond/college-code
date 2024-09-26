# Generators
def myRange(n):
    i = 0
    while i < n:
        yield i
        i += 1


x = myRange(3)
print(type(x))
# <class 'generator'>

print(next(x))
print(next(x))
print(next(x))
#print(next(x))  # StopIteration
print()

for item in myRange(5):
    print(item)


def foo():
    for i in range(3):
        yield i


x = foo()
print(next(x))
print(next(x))
print(next(x))
print()
for item in foo():
    print(item)
    