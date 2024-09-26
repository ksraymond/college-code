# Nested dictionaries and lists
allGuests = {'Alice': {'apples': 5, 'pretzels': 12},
             'Bob': {'ham sandwiches': 3, 'apples': 2},
             'Carol': {'cups': 3, 'apple pies': 1}}


def totalBrought(guests, item):
    numBrought = 0
    for key, value in guests.items():
        #print(key, value)
        numBrought += value.get(item, 0)

    return numBrought


print("Number of things being brought")
print("apples - " + str(totalBrought(allGuests, "apples")))
print("cups - " + str(totalBrought(allGuests, "cups")))
print("cakes - " + str(totalBrought(allGuests, "cakes")))
print("ham sandwiches - " + str(totalBrought(allGuests, "ham sandwiches")))
print("apple pies - " + str(totalBrought(allGuests, "apple pies")))
