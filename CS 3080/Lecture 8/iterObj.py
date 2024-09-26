# Let's create our range iter object!
class MyRange:
    def __init__(self, n):
        self.i = 0
        self.n = n

    def __iter__(self):
        return self

    def __next__(self):
        if self.i < self.n:
            result = self.i
            self.i += 1
            return result
        else:
            raise StopIteration()


myRange = MyRange(5)
print(next(myRange))
print(next(myRange))
print(next(myRange))
print(next(myRange))
print(next(myRange))
#print(next(myRange))  # StopIteration
print()

myRange = MyRange(5)
for item in myRange:
    print(item)
