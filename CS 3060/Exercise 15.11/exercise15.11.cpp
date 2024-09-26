/*
Keaton Raymond
CS 3060-002
Question:
    in a course, a teacher gives the following tests and assignments:
        a "lab activity" that is observed by the teacher and assigned a numeric score
        a "pass/fail exam" that has 10 questions, the minimum passing score is a 70
        an "essay" that is assigned a numeric score
        a "final exam" that has 50 questions
    write a class named "CourseGrades". the class should have a member named "grades" that is an array of "GradedActivity" pointers
    the "grades" array should have four elements, one of each of the assignments previously described
    the class should have the following member functions:
        "setLab": this function should accept the address of a "GradedActivity" object as its argument. 
            this object should already hold the student's score for the lab activity. element 0 of the "grades" array should reference this object

        "setPassFailExam": this function should accept the address of a "PassFailExam" object as its argument. 
            this object should already hold the student's score for the pass/fail exam. element 1 of the "grades" array should reference this object

        "setEssay": this function should accept the address of an "Essay" object as its argument. 
            (see programming challenge 6 for the Essay class. if you have not completed programming challenge 6, use a GradedActivity object instead) 
            this object should already hold the student's score for the essay. element 2 of the grades array should reference this object

        "setFinalExam": this function should accept the address of a "FinalExam" object as its argument. 
            this object should already hold the student's score for the final exam. element 3 of the grades array should reference this object

        "print": this function should display the numeric scores and grades for each element in the grades array
*/

/*
outline of classes and methods needed:
    CourseGrades
        member grades that is array of GradedActivity pointers
        setLab function
            arg: address of GradedActivity object
            set element 0 of array to this object that holds the grade
        setPassFailExam function
            arg: address of a PassFailExam object as argument
            set element 1 of array to this object that holds the grade
        setEssay function
            arg: address of GradedActivity object since didn't do question 6
            set element 2 of array to this object that holds the grade
        setFinalExam function
            arg: address of a FinalExam object
            set element 3 of array to this object that holds the grade
        print function
            display numeric scores and grades for each element in grades array
        constructor
            args: objects for all 4 grades
            set all 4 elements
        default constructor
            set all grades to zero
    GradedActivity
        holds a double for the grade
        will be extended by each of the activities
        setter and getter
    PassFailExam/Essay/FinalExam
        extends GradedActivity
*/

#include <iostream>
using namespace std;

//base class for grades
class GradedActivity
{
    private:
        double score;
    public:
        GradedActivity(){ score = 0; } //default constructor
        GradedActivity(double s) { score = s; }
        
        void setScore(double s) { score = s; }
        double getScore() { return score; }
        virtual double getGrade(){ return score; } //virtual so that it can be overloaded in base classes
};

//derived class for the pass fail exam
class PassFailExam : public GradedActivity
{
    private:
        double grade;
        void calculateGrade()
        {
            grade = (getScore()/10)*100;
        }

    public:
        PassFailExam(){} //default constructor
        PassFailExam(double s)
        {
            setScore(s);
            calculateGrade();
        }
        double getGrade() { return grade; } //overload getGrade function
};

//derived class for the final exam
class FinalExam : public GradedActivity
{
    private:
        double grade;
        void calculateGrade()
        {
            grade = (getScore()/50)*100;
        }

    public:
        FinalExam(){} //default constructor
        FinalExam(double s)
        {
            setScore(s);
            calculateGrade();
        }
        double getGrade() { return grade; } //overload getGrade function
};

//class for the grade array
class CourseGrades
{
    private:
        GradedActivity *grades[4];
    
    public:
        CourseGrades() //default constructor
        {
            grades[0] = new GradedActivity;
            grades[1] = new PassFailExam;
            grades[2] = new GradedActivity;
            grades[3] = new FinalExam;
        }
        CourseGrades(GradedActivity *lab, PassFailExam *pfExam, GradedActivity *essay, FinalExam *final)
        {
            grades[0] = lab;
            grades[1] = pfExam;
            grades[2] = essay;
            grades[3] = final;
        }

        //set functions
        void setLab(GradedActivity *lab) { grades[0] = lab; }
        void setPassFailExam(PassFailExam *pfexam) { grades[1] = pfexam; }
        void setEssay(GradedActivity *essay) { grades[2] = essay; }
        void setFinalExam(FinalExam *final) { grades[3] = final; }

        //print the grade report
        void print()
        {
            cout << "Assignment\tScore\tGrade\n";
            cout << "Lab\t\t" << grades[0]->getScore() << "\t" << grades[0]->getScore() << "%\n";
            cout << "Pass/Fail Exam\t" << grades[1]->getScore() << "\t" << grades[1]->getGrade() << "%\n";
            cout << "Essay\t\t" << grades[2]->getScore() << "\t" << grades[2]->getScore() << "%\n";
            cout << "Final Exam\t" << grades[3]->getScore() << "\t" << grades[3]->getGrade() << "%\n";
        }
};

int main()
{
    CourseGrades grades;
    GradedActivity *lab = new GradedActivity(10);
    PassFailExam *pfExam = new PassFailExam(5);
    GradedActivity *essay = new GradedActivity(10);
    FinalExam *final = new FinalExam(40);

    cout << "ONLY DEFAULT ARGS\n";
    grades.print();

    cout << "\nUSING SETTERS\n";
    grades.setLab(lab);
    grades.setPassFailExam(pfExam);
    grades.setEssay(essay);
    grades.setFinalExam(final);
    grades.print();

    cout << "\nUSING ARGS IN CONSTRUCTOR\n";
    CourseGrades newGrades(lab, pfExam, essay, final);
    newGrades.print();
}