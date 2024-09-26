# Generators examples
def integers():
    """Infinite sequence of integers."""
    i = 1
    while True:
        yield i
        i = i + 1
# 1
# 2
# 3
# 4
# ...


def twoPows():
    """Infinite sequence of two pow numbers."""
    i = 0
    while True:
        yield 2 ** i
        i += 1
# 1
# 2
# 4
# 8
# ...


def twoPows():
    """Infinite sequence of two pow numbers."""
    for i in integers():
        yield 2 ** i


def squares():
    """Infinite sequence of squares."""
    for i in integers():
        yield i * i
# 0
# 1
# 4
# 9
# ...


def take(n, seq):
    """Returns first n values from the given sequence."""
    seq = iter(seq)  # Just in case it is an iterable object,
                            # not a generator or iterator
    result = []
    try:
        for i in range(n):
            result.append(next(seq))
    except StopIteration:
        pass
    return result


print(take(5, squares()))  # [1, 4, 9, 16, 25]
print(take(5, integers()))  # [1, 2, 3, 4, 5]
print(take(5, twoPows()))   # [2, 4, 8, 16, 32]
