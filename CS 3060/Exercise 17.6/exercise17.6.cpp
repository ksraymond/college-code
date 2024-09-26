/*
Keaton Raymond
CS 3060-002
Question:
    write a program that reads the contents of a text file. 
    the program should create a map in which the keys are 
    the individual words found in the file and the values are the number of times each word appears. 
    for example, if the word "the" appears 128 times, 
    the map would contain an element with "the" as the keyword and 128 as the value. 
    the program should either display the frequency of each word or create a second file 
    containing a list of each word and its frequency
*/

#include <iostream>
#include <map>
#include <string>
#include <iterator>
#include <sstream>
#include <fstream>
using namespace std;

int main()
{
    ifstream inputFile; //file object for user input
    string inputString = ""; //file converted to string
    string input = ""; //user inputted string
    map<string, int> wordCount; //define map for the word count
    string word = ""; //used for iterating through file

    //take file input from user
    cout << "Please input the file you would like to read from: ";
    cin >> input;

    inputFile.open(input); //open the file

    if (inputFile.is_open()) //iterate through converting the file to a string
    {
        while (inputFile)
            inputString += tolower(inputFile.get()); //tolower is to do a case insenstive search
    }

    //remove null character from end of input
    if (!inputString.empty())
        inputString.pop_back();

    istringstream stream(inputString); //define input stream for iterating through string
    while (stream>>word) //while loop iterating through the input stream
    {
        if (wordCount.find(word) != wordCount.end()) //if the word is in the map, add one to the count
            wordCount[word] += 1;
        else //if the word isn't in the map, add it
            wordCount[word] = 1;
    }


    map<string, int>::iterator it = wordCount.begin(); //define an iterator for the map
    while (it != wordCount.end()) //iterate through the map, printing the results
    {
        cout << it->first << " was found " << it->second << " times\n";
        ++it;
    }

    inputFile.close();
    return 0;
}