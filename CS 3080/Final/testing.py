a = (i * i for i in range(1000) if i % 3 != 0)

for _ in range(5):
    print(next(a), end=' ')