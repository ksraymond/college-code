/*
Keaton Raymond
CS 3060-002
Question:
    add a function to programming challenge 7 (customer accounts) that allows the user to search the struccture array for a particular customer's account. 
    it should accept part of the customer's name as an argument then search for an account with a name that matches it. 
    all accounts that match should be displayed. if no account matches, a message saying so should be displayed

Exercise 11.7 relevant info:
    write a program that uses a structure to store the following data about a customer account
        name
        address
        city, state, zip
        phone number
        account balance
        date of last payment
    the program should use an array of at least 10 structs. 
    have user input the info for each one
*/

#include <iostream>
#include <string>
using namespace std;

//struct
struct customerAccount
{
    string name;
    string address;
    string city;
    string state;
    string zip;
    string phoneNumber;
    double accountBalance;
    string dateOfPayment;
};

//prototypes
void initializeAccounts(customerAccount*[], int);
void searchForAccount(customerAccount*[], int);
void printAccount(customerAccount*);

int main()
{
    int arraySize = 0;

    //ask user how many accounts to add
    cout << "How many customer accounts would you like to add? ";
    cin >> arraySize;

    //create the array of accounts as an array of pointers to structs
    customerAccount *accounts[arraySize];

    //call to ask user to initialize accounts
    initializeAccounts(accounts, arraySize);
    //call to ask user what name to search for
    searchForAccount(accounts, arraySize);

    return 0;
}

//iterate through the array creating the structs and having the user input the data for each
void initializeAccounts(customerAccount *accounts[], int arraySize)
{
    for(int i=0; i<arraySize; i++)
    {
        accounts[i] = new customerAccount;
        cout << "Enter customer " << i+1 << "'s name: ";
        cin >> accounts[i]->name;
        cout << "Enter customer " << i+1 << "'s address: ";
        cin >> accounts[i]->address;
        cout << "Enter customer " << i+1 << "'s city: ";
        cin >> accounts[i]->city;
        cout << "Enter customer " << i+1 << "'s state: ";
        cin >> accounts[i]->state;
        cout << "Enter customer " << i+1 << "'s zip code: ";
        cin >> accounts[i]->zip;
        cout << "Enter customer " << i+1 << "'s phone number: ";
        cin >> accounts[i]->phoneNumber;
        cout << "Enter customer " << i+1 << "'s account balance: ";
        cin >> accounts[i]->accountBalance;
        cout << "Enter customer " << i+1 << "'s date of last payment: ";
        cin >> accounts[i]->dateOfPayment;
    }
}

//search for the account that the user wants
void searchForAccount(customerAccount *accounts[], int arraySize)
{
    bool accountFound = false;
    string nameSearch = "";
    cout << "Enter the name you would like to search for: ";
    cin >> nameSearch;

    for(int i=0; i<arraySize; i++)
    {
        if(accounts[i]->name.find(nameSearch) != string::npos) //if the name contains the input substring
        {
            cout << endl;
            cout << "Match Found\n";
            printAccount(accounts[i]);
            accountFound = true;
        }
    }

    if(!accountFound)
        cout << "No accounts matching the input were found";
}

//print all details for a found account
void printAccount(customerAccount *account)
{
    cout << "Customer name: " << account->name << endl;
    cout << "Customer address: " << account->address << endl;
    cout << "Customer city: " << account->city << endl;
    cout << "Customer state: " << account->state << endl;
    cout << "Customer zip code: " << account->zip << endl;
    cout << "Customer phone number: " << account->phoneNumber << endl;
    cout << "Customer account balance: " << account->accountBalance << endl;
    cout << "Customer date of last payment: " << account->dateOfPayment << endl;
}