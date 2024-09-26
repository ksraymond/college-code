from sys import getsizeof

# Generator expressions 2
gen_exp = lambda var: (x ** 2 for x in range(var) if x % 2 == 0)
print(type(gen_exp))
# <class 'function'>
print(type(gen_exp(10)))
# <class 'generator'>
for x in gen_exp(10):
    print(x)
# 0
# 4
# 16
# 36
# 64

# Generator expressions 3
list_comp = [x ** 2 for x in range(10) if x % 2 == 0]
gen_exp = (x ** 2 for x in range(10) if x % 2 == 0)
print(list_comp)  # [0, 4, 16, 36, 64]
print(gen_exp)  # <generator object <genexpr> at 0x7f600131c410>

# size difference
list_comp = [x * 5 for x in range(1000)]
gen_exp = (x * 5 for x in range(1000))
print(getsizeof(list_comp))
# 9024 (in bytes)
print(getsizeof(gen_exp))
# 120 (in bytes)
