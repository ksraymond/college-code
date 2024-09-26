# List comprehension 1
my_list = [x * 2 for x in range(10)]
print(my_list)
# [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]


# List comprehension 2
comp_list = [x ** 2 for x in range(7) if x % 2 == 0]
print(comp_list)  # [0, 4, 16, 36]


# List comprehension 3
nums = [1, 2, 3, 4, 5]
letters = ['A', 'B', 'C', 'D', 'E']
nums_letters = [[n, l] for n in nums for l in letters]
print(nums_letters)
# [[1, 'A'], [1, 'B'], [1, 'C'], [1, 'D'], [1, 'E'], [2, 'A'], [2, 'B'], [2, 'C'], [2, 'D'], [2, 'E'], [3, 'A'],
# [3, 'B'], [3, 'C'], [3, 'D'], [3, 'E'], [4, 'A'], [4, 'B'], [4, 'C'], [4, 'D'], [4, 'E'], [5, 'A'], [5, 'B'],
# [5, 'C'], [5, 'D'], [5, 'E']]

# List comprehension 4
nums = [1, 2, 3, 4, 5]
letters = ['A', 'B', 'C', 'D', 'E']
nums_letters = [[n, l] for n in nums if n == 1 for l in letters if l == 'A']
print(nums_letters)  # [[1, 'A']]

# List comprehension 5
iter_string = "some text"
comp_list = [x for x in iter_string if x != " "]
print(comp_list)  # ['s', 'o', 'm', 'e', 't', 'e', 'x', 't']

