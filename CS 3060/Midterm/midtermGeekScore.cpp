/*
Keaton Raymond
CS 3060-002
Geek Score Midterm Coding Challenge
*/

#include <iostream>
#include <string>
using namespace std;

const int NUM_STUDENTS = 7;

const int NUM_TESTS = 4;

int main()
{
    //declare student array
    string names[NUM_STUDENTS];

    //declare score array
    string degreeOfGeek[NUM_STUDENTS];

    //declare 7 test arrays
    //changed to a 2d array because it makes more sense than 7 separate arrays
    double testScores[NUM_STUDENTS][NUM_TESTS];

    //average score array, basically nullifies need for a test scores array but makes it easier to code
    double averageScore[NUM_STUDENTS];

    //used in for loop below
    double testScore = 0;

    //take input for names
    for(int i=0; i<NUM_STUDENTS; i++)
    {
        cout << "Please enter student " << i+1 << "'s name: ";
        cin >> names[i];
    }

    //iterate through score array asking for the scores
    for(int i=0; i<NUM_STUDENTS; i++)
    {
        double totalScore = 0.0; //reset the total score
        for(int j=0; j<NUM_TESTS; j++)
        {
            do
            {
                cout << "Please input " << names[i] << "'s score for test " << j+1 << ": ";
                cin >> testScore;
                if(testScore <0 || testScore >100)
                    cout << "Please input a score between 0 and 100.\n";
            }while(testScore <0 || testScore >100);
            totalScore+=testScore; //accumulate total score
        }
        averageScore[i] = totalScore/4; //add average score to array
    }

    //assign letter grades
    for(int i=0; i<NUM_STUDENTS; i++)
    {
        if(averageScore[i] >= 95) //90-100
            degreeOfGeek[i] = "Superkalifragilistic Superfly Geek";
        else if(averageScore[i] >=90 && averageScore[i]<95) //90-94
            degreeOfGeek[i] = "Uber Geek";
        else if(averageScore[i] >=85.2 && averageScore[i]<90) //85.2-89
            degreeOfGeek[i] = "Geek";
        else if(averageScore[i] >=80 && averageScore[i]<85.2) //80-85.1
            degreeOfGeek[i] = "SmartDude";
        else if(averageScore[i] >=70 && averageScore[i]<80) //70-79
            degreeOfGeek[i] = "HighBrow";
        else if(averageScore[i] >=60 && averageScore[i]<70) //60-69
            degreeOfGeek[i] = "Calculus Challenged";
        else //0-59
         degreeOfGeek[i] = "LowBrow";
    }

    //print report
    cout << "Student Average Test Scores with Degree Of Geek\n";
    cout << "-------------------------------------------------\n";
    for(int i=0; i<NUM_STUDENTS; i++)
        cout << names[i] << "\t\t" << averageScore[i] << "\t\t" << degreeOfGeek[i] << endl;

    return 0;
}