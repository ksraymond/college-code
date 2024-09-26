# The copy Module’s copy() and deepcopy() Functions
import copy

spam = ['A', 'B', 'C', 'D']
cheese = copy.copy(spam)
cheese[1] = 42
print(spam)
# ['A', 'B', 'C', 'D']
print(cheese)
# ['A', 42, 'C', 'D']


spam = [["a","b","c"], 1, 2, 3, 4, 5]
cheese = copy.copy(spam)
cheese[0][1] = 'Hello!'
print(spam)
# [['a', 'Hello!', 'c'], 1, 2, 3, 4, 5]
print(cheese)
# [['a', 'Hello!', 'c'], 1, 2, 3, 4, 5]

spam = [["a","b","c"], 1, 2, 3, 4, 5]
cheese = copy.deepcopy(spam)
cheese[0][1] = 'Hello!'
print(spam)
# [['a', 'b', 'c'], 1, 2, 3, 4, 5]
print(cheese)
# [['a', 'Hello!', 'c'], 1, 2, 3, 4, 5]

