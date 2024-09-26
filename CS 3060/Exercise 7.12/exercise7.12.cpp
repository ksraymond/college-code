/*
Keaton Raymond
CS 3060-002
Question:
    a teacher has 4 students who have taken 4 tests. 
    the teacher uses the following grading scale to assign a letter grade to a student, 
    based on the average of his or her 4 test scores:
        90-100: A
        80-89: B
        70-79: C
        60-69: D
        0-59: F

    write a program that uses:
        an array of string objects to hold the 5 student names, 
        an array of 5 chars to hold the 5 students letter grades, 
        and 5 arrays of 4 doubles to hold each student's set of test scores
        
    the program should allow the user to enter each student's name and his or her 4 test scores. 
    it should then calculate and display each student's average test score, and a letter grade based on the average.

    input validation: do not accept test scores less than 0 or greater than 100
*/

#include <iostream>
#include <string>
using namespace std;

const int NUM_STUDENTS = 5;
const int NUM_TESTS = 4;

int main()
{
    string names[NUM_STUDENTS];
    char letterGrades[NUM_STUDENTS];
    double testScores[NUM_STUDENTS][NUM_TESTS]; //change to 2d array becuase it just makes more sense
    double averageScore[NUM_STUDENTS]; //basically nullifies point of above array but whatever its more efficient
    double testScore;

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
                if(testScore <=0 || testScore >=100)
                    cout << "Please input a score between 0 and 100.\n";
            }while(testScore <=0 || testScore >=100);
            totalScore+=testScore; //accumulate total score
        }
        averageScore[i] = totalScore/4; //add average score to array
    }

    //assign letter grades
    for(int i=0; i<NUM_STUDENTS; i++)
    {
        if(averageScore[i] >= 90)
            letterGrades[i] = 'A';
        else if(averageScore[i] >=80 && averageScore[i]<90)
            letterGrades[i] = 'B';
        else if(averageScore[i] >=70 && averageScore[i]<80)
            letterGrades[i] = 'C';
        else if(averageScore[i] >=60 && averageScore[i]<70)
            letterGrades[i] = 'D';
        else
         letterGrades[i] = 'F';
    }

    //print report
    cout << "Student Average Test Scores with Letter Grade\n";
    cout << "--------------------------\n";

    for(int i=0; i<NUM_STUDENTS; i++)
    {
        cout << names[i] << "\t\t" << averageScore[i] << "\t\t" << letterGrades[i] << endl;
    }

}