import pprint

# Dict comprehensions
dict_comp = {x: x for x in range(10)}
print(type(dict_comp))  # <class 'dict'>
print(dict_comp)
# {0: 0, 1: 1, 2: 2, 3: 3, 4: 4, 5: 5, 6: 6, 7: 7, 8: 8, 9: 9}

dict_comp = {x: str(x) for x in range(10)}
print(dict_comp)
# {0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7', 8: '8', 9: '9'}

dict_comp = {str(x): x for x in range(10)}
print(dict_comp)
# {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}

dict_comp = {x: chr(x) for x in range(10)}
print(dict_comp)
# {0: '\x00', 1: '\x01', 2: '\x02', 3: '\x03', 4: '\x04', 5: '\x05',
# 6: '\x06', 7: '\x07', 8: '\x08', 9: '\t'}

dict_comp = {x: chr(65+x) for x in range(1, 11)}
print(dict_comp)  # {1: 'B', 2: 'C', 3: 'D', 4: 'E', 5: 'F', 6: 'G', 7: 'H', 8: 'I', 9: 'J', 10: 'K'}
