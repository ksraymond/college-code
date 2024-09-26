'''
Homework 5, exercise 1
Name: Keaton Raymond
Date: 11/9/2022
Description:
    write iterator class ReverseIter that takes a list and iterates over it in reverse order
    to accomplish this I took advantage of negative indexing
'''

class ReverseIter:
    def __init__(self, iterList):
        self.i = -1 #-1 to use negative index to iterate backwards
        self.iterList = iterList

    def __iter__(self):
        return self

    def __next__(self):
        if self.i >= (len(self.iterList) * -1): #because using neg index, have to convert the length to a negative num
            result = self.iterList[self.i]
            self.i -= 1
            return result
        else:
            raise StopIteration()
        

#test code
testList = [1, 2, 3, 4, 5]
test = ReverseIter(testList)
print(next(test))
print(next(test))
print(next(test))
print(next(test))
print(next(test))
#print(next(test)) #StopIteration()