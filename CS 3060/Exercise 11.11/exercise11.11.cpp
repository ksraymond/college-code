/*
Keaton Raymond
CS 3060-002
Question:
    a student has established the following monthly budget:
    housing                 $500
    utilities               $150
    household expenses      $65
    transportation          $50
    food                    $250
    medical                 $30
    insurance               $100
    entertainment           $150
    clothing                $75
    miscellaneous           $50
    write a program that has a MonthlyBudget struct designed to hold each of these expense categories. 
    the program should pass the structure to a function that asks the user to enter the amounts spent in each budget category during a month. 
    the program should then pass the structure to a function that displays a report indicating the amount over or under in each category, 
    as well as the amount over or under for the entire monthly budget
*/

#include <iostream>
#include <iomanip>
using namespace std;

//struct with all defined vars
struct MonthlyBudget
{
    double housing;
    double utilities;
    double householdExpenses;
    double transportation;
    double food;
    double medical;
    double insurance;
    double entertainment;
    double clothing;
    double misc;
};

//prototypes
void initializeAmountAllocated(MonthlyBudget*);
void getAmountSpent(MonthlyBudget*);
void generateReport(MonthlyBudget*, MonthlyBudget*);

int main()
{
    //initialize the allocated values in the budget to a struct
    MonthlyBudget *amountAllocated = new MonthlyBudget;
    initializeAmountAllocated(amountAllocated);

    //get the amount spent in each category
    MonthlyBudget *amountSpent = new MonthlyBudget;
    getAmountSpent(amountSpent);

    //call function to generate the report
    generateReport(amountAllocated, amountSpent);

    return 0;
}

//initialize the amount of money allocated to each category in the proper struct
void initializeAmountAllocated(MonthlyBudget *amountAllocated)
{
    amountAllocated->housing = 500;
    amountAllocated->utilities = 150;
    amountAllocated->householdExpenses = 65;
    amountAllocated->transportation = 50;
    amountAllocated->food = 250;
    amountAllocated->medical = 30;
    amountAllocated->insurance = 100;
    amountAllocated->entertainment = 150;
    amountAllocated->clothing = 75;
    amountAllocated->misc = 50;
}

//ask user to input the actual amount spent in each category
void getAmountSpent(MonthlyBudget *amountSpent)
{
    cout << "Enter the amount spent on housing this month: $";
    cin >> amountSpent->housing;

    cout << "Enter the amount spent on utilities this month: $";
    cin >> amountSpent->utilities;

    cout << "Enter the amount spent on household expenses this month: $";
    cin >> amountSpent->householdExpenses;

    cout << "Enter the amount spent on transportation this month: $";
    cin >> amountSpent->transportation;

    cout << "Enter the amount spent on food this month: $";
    cin >> amountSpent->food;

    cout << "Enter the amount spent on medical this month: $";
    cin >> amountSpent->medical;

    cout << "Enter the amount spent on insurance this month: $";
    cin >> amountSpent->insurance;

    cout << "Enter the amount spent on entertainment this month: $";
    cin >> amountSpent->entertainment;

    cout << "Enter the amount spent on clothing this month: $";
    cin >> amountSpent->clothing;

    cout << "Enter the amount spent on miscellaneous this month: $";
    cin >> amountSpent->misc;
}

//print the formatted report and calculate the total difference
void generateReport(MonthlyBudget *amountAllocated, MonthlyBudget *amountSpent)
{
    double totalDifference = 0;
    cout << fixed << showpoint << setprecision(2);
    cout << "Category\t\t|Difference between amount allocated and spent\n";
    cout << "-----------------------------------------------------------\n";

    cout << "Housing\t\t\t|$" << amountAllocated->housing - amountSpent->housing << endl;
    totalDifference += (amountAllocated->housing - amountSpent->housing);

    cout << "Utilities\t\t|$" << amountAllocated->utilities - amountSpent->utilities << endl;
    totalDifference += (amountAllocated->utilities - amountSpent->utilities);

    cout << "Household Expenses\t|$" << amountAllocated->householdExpenses - amountSpent->householdExpenses << endl;
    totalDifference += (amountAllocated->householdExpenses - amountSpent->householdExpenses);

    cout << "Transportation\t\t|$" << amountAllocated->transportation - amountSpent->transportation << endl;
    totalDifference += (amountAllocated->transportation - amountSpent->transportation);

    cout << "Food\t\t\t|$" << amountAllocated->food - amountSpent->food << endl;
    totalDifference += (amountAllocated->food - amountSpent->food);

    cout << "Medical\t\t\t|$" << amountAllocated->medical - amountSpent->medical << endl;
    totalDifference += (amountAllocated->medical - amountSpent->medical);

    cout << "Insurance\t\t|$" << amountAllocated->insurance - amountSpent->insurance << endl;
    totalDifference += (amountAllocated->insurance - amountSpent->insurance);

    cout << "Entertainment\t\t|$" << amountAllocated->entertainment - amountSpent->entertainment << endl;
    totalDifference += (amountAllocated->entertainment - amountSpent->entertainment);

    cout << "Clothing\t\t|$" << amountAllocated->clothing - amountSpent->clothing << endl;
    totalDifference += (amountAllocated->clothing - amountSpent->clothing);

    cout << "Miscellaneous\t\t|$" << amountAllocated->misc - amountSpent->misc << endl;
    totalDifference += (amountAllocated->misc - amountSpent->misc);

    cout << "Total\t\t\t|$" << totalDifference << endl;
}