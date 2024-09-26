/*
Keaton Raymond
CS 3060-002
Question:
    write a class named TestScores. 
    the class constructor should accept an array of test scores as its argument
    the class should have a member function that returns the average of the test scores
    if any test score in the array is negative or greater than 100
    the class should throw an exception
*/

#include <iostream>
using namespace std;

class TestScores
{
    private:
        double *scores;
        int size;
    
    public:
        TestScores(double s[], int si) 
        {
            scores = s;
            size = si;
        }

        //calculate the average
        double average()
        {
            double total = 0;
            try
            {
                for(int i=0; i<size; i++)
                {
                    //if score is invalid, throw an exception
                    if(scores[i]>=0 && scores[i]<=100)
                        total+=(scores[i]);
                    else
                        throw(scores[i]);
                }
                return total/size;
            }
            catch(double score) //catch exception
            {
                cout << "Score must be between 0 and 100, score was " << score << endl;
                return 0;
            }
        }
};

int main()
{
    //test average with no exception
    double scoreArrayValid[] = {1, 2, 3, 4, 5};
    TestScores validScores(scoreArrayValid, sizeof(scoreArrayValid)/sizeof(scoreArrayValid[0]));
    cout << validScores.average() << endl;

    //test average with an exception
    double scoreArrayInvalid[] = {1, 2, 3, 103, 4, 5};
    TestScores invalidScores(scoreArrayInvalid, sizeof(scoreArrayInvalid)/sizeof(scoreArrayInvalid[0]));
    cout << invalidScores.average();

    return 0;
}