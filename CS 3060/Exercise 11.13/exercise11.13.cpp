/*
Keaton Raymond
CS 3060-002
Question:
    write a program that simulates a soft drink machine. the program should use a struct that stores the following data:
        drink name
        drink cost
        number of drinks in machine
    the program should create an array of five structs. the elements should be initialized with the following data:
        drink name          cost            number in machine
        cola                .75             20
        root beer           .75             20
        lemon-lime          .75             20
        grape soda          .80             20
        cream soda          .80             20
    each time the program runs, it should enter a loop that performs the following steps:
        a list of drinks is displayed on the screen
        the user should be allowed to either quit the program or pick a drink
        if the user selects a drink, he or she will next enter the amount of number that is to be inserted into the drink machine
        the program should display the amount of change that would be returned, and subtract one from the number of that drink left in the machine.
        if the user selects a drink that has sold out, a message should be displayed
        the loop repeats
        when the user chooses to quit the program, it should display the total amount of money the machine earned
    input validation: when the user enters an amount of money, do not accept negative values or values greater than $1.00
*/