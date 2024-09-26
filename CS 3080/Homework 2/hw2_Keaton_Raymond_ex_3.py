'''
Homework 2, exercise 3
Name: Keaton Raymond
Date: 9/23/2022
Description:
    practice with lists
    do 12 actions to a list, with the last one calling a function that formats the list into a string
'''
#function that takes the list and converts it to a string of format: item1, item2, ... , and itemN
#str() cast to make it work for any list passed to it, not only string lists
def strList(myList):
    listString = ""
    for i in range(len(myList)):
        if i == len(myList)-1:
            listString += ("and " + str(myList[i]) + ".")
        else:
            listString += (str((myList[i])) + ", ")
    return listString


#create and print the list
items = ["Wallet", "Phone", "Keys"]
print(items)

#sort and print the list
items.sort()
print(items)

#print everything except the last item in the list using slicing
print(items[1::])

#print the last item with a negative index
print(items[-1])

#print the index of "Keys" using index()
print(items.index("Keys"))

#append "Tablet" to the list, and print
items += ["Tablet"]
print(items)

#insert "Mask" to the list as the second item in the list, then print the list
items.insert(1, "Mask")
print(items)

#remove phone from list and print
items.remove("Phone")
print(items)

#reverse the list, then print
items.reverse()
print(items)

#print return statement for above function
print(strList(items))