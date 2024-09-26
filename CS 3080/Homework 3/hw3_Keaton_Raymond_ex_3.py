'''
Homework 3, exercise 3
Name: Keaton Raymond
Date: 10/7/2022
Description:
    declare an inventory dictionary and define 3 functions
    1. prints the inventory in a nice format
    2. adds an item, if the item is in the inventory increment the counter, 
        otherwise add it to the dict with a value of 1
    3. delete an item, if there is more than 0 of the item, decrement the counter, 
        otherwise if there are 0 items then print an error message. don't delete the item group
'''
inventory = {"Hand sanitizer": 10, "Soap": 6, "Kleenex": 22, "Lotion": 16, "Razors": 12}

#print the contents of the inventory in a nice format
def printInventory(inventory):
    print('INVENTORY'.center(20 + 4, '-'))
    for k, v in inventory.items():
        print(k.ljust(20, '.') + str(v).rjust(4))
    
#add an item to the inventory
#if it is already in the dictionary, add 1 to the count
#if it isn't in the dictionary, add the item with a value of 1
def addItem(inventory, item):
    if(item in inventory):
        inventory[item] += 1
    else:
        inventory[item] = 1
    
#delete an item from the inventory, but don't delete the item group
#if the inventory is 0, print an error
#otherwise remove 1 from the count
def deleteItem(inventory, item):
    if(inventory[item] == 0):
        print("ERROR: that item cannot be deleted any further")
    else:
        inventory[item] -= 1


#testing all functions     
print("beginning inventory")
printInventory(inventory)

print("after adding 1 Kleenex")
addItem(inventory, "Kleenex")
printInventory(inventory)

print("after adding Bread")
addItem(inventory, "Bread")
printInventory(inventory)

print("after removing hand sanitizer")
deleteItem(inventory, "Hand sanitizer")
printInventory(inventory)

print("after removing bread")
deleteItem(inventory, "Bread")
printInventory(inventory)

print("after removing bread again")
deleteItem(inventory, "Bread")
printInventory(inventory)