# Generators expressions 1
gen_exp = (x ** 2 for x in range(10) if x % 2 == 0)
print(type(gen_exp))
# <class 'generator'>

for x in gen_exp:
    print(x)
# 0
# 4
# 16
# 36
# 64
