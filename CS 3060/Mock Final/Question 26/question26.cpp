/*
Keaton Raymond
CS 3060-002
Question:
    a factory you recently wrote code for has received a federal grant that compensates the pay of disabled folk working at hte factory
    the point is to encourage factories to hire those that are disabled and give them an opportunity to work
    design a class named Employee. the class should keep the following information:
        employee name
        employee number
        hire date
        disabled (yes or no)
    write one or more constructors and the appropriate accessor and mutator functions for the class
    next write a class named ProductionWorker that is derived from the Employee class
    the ProductionWorker class should have member variables to hold the following information
        shift (an integer)
        hourly pay rate (a double)
    the workday is divided into two shifts: day and night
    the shift variable will hold an integer value representing the shift that the employee works
    the day shift is shift 1, and the night shift is shift 2
    write one or more constructors and the appropriate accessor and mutator functions for the class
    cemonstrate the classes by writing a program that uses a ProductionWorker object
*/

#include <iostream>
#include <string>
using namespace std;

class Employee
{
    private:
        string name;
        int empNum;
        string hireDate;
        bool disabled;
    public:
        Employee()
        {
            name = "";
            empNum = 0;
            hireDate = "";
            disabled = false;
        }
        Employee(string n, int e, string hire, bool d)
        {
            name = n;
            empNum = e;
            hireDate = hire;
            disabled = d;
        }

        string getName() { return name; }
        int getEmpNum() { return empNum; }
        string getHireDate() { return hireDate; }
        bool getDisabled() { return disabled; }

        void setName(string n) { name = n; }
        void setEmpNum(int e) { empNum = e; }
        void setHireDate(string hire) { hireDate = hire; }
        void setDisabled(bool d) { disabled = d; }
};

class ProductionWorker : public Employee
{
    private:
        int shift;
        double hourlyPay;
    public:
        ProductionWorker() : Employee()
        {
            shift = 0;
            hourlyPay = 0;
        }
        ProductionWorker(string n, int e, string hire, bool d, int s, double h) : Employee(n, e, hire, d)
        {
            shift = s;
            hourlyPay = h;
        }
        int getShift() { return shift; }
        double getHourlyPay() { return hourlyPay; }

        void setShift(int s) { shift = s; }
        void setHourlyPay(double h) { hourlyPay = h; }
};

//tested with employee object, production worker object, both default and normal constructors, all works

int main()
{
    ProductionWorker worker = ProductionWorker();

    cout << worker.getName() << endl;
    cout << worker.getEmpNum() << endl;
    cout << worker.getHireDate() << endl;
    cout << worker.getDisabled() << endl;
    cout << worker.getShift() << endl;
    cout << worker.getHourlyPay() << endl;
    return 0;
}