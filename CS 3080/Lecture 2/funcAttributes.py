def say_whee():
    say_whee.count += 1
    print("Whee!")

say_whee.count = 0
say_whee()
say_whee()

print(say_whee.count)


def add_exclamation(s):
    add_exclamation.some_attribute = 'Function attribute'
    print(s + '!')


add_exclamation('burma')
add_exclamation.another_attribute = "Another function attribute"
print(add_exclamation.some_attribute)
print(add_exclamation.another_attribute)
