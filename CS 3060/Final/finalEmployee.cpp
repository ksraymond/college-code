/*
Keaton Raymond
CS 3060-002
*/

#include <iostream>
using namespace std;

//employee class
class Employee
{
    //private class variables
    private:
        string name;
        int empNum;
        string hireDate;
        bool disabled;
    public:
        Employee() //default constructor
        {
            name = "";
            empNum = 0;
            hireDate = "";
            disabled = false;
        }
        Employee(string n, int e, string hire, bool d) //constructor
        {
            name = n;
            empNum = e;
            hireDate = hire;
            disabled = d;
        }

        //accessor functions
        string getName() { return name; }
        int getEmpNum() { return empNum; }
        string getHireDate() { return hireDate; }
        bool getDisabled() { return disabled; }

        //mutator functions
        void setName(string n) { name = n; }
        void setEmpNum(int e) { empNum = e; }
        void setHireDate(string hire) { hireDate = hire; }
        void setDisabled(bool d) { disabled = d; }
};

//production worker class which is a subclass of employee
class ProductionWorker : public Employee
{
    //private class vars
    private:
        int shift;
        double hourlyPay;
    public:
        //default constructor
        ProductionWorker() : Employee()
        {
            shift = 0;
            hourlyPay = 0;
        }
        //normal constructor
        ProductionWorker(string n, int e, string hire, bool d, int s, double h) : Employee(n, e, hire, d)
        {
            shift = s;
            hourlyPay = h;
        }

        //accessor functions
        int getShift() { return shift; }
        double getHourlyPay() { return hourlyPay; }

        //mutator functions
        void setShift(int s) { shift = s; }
        void setHourlyPay(double h) { hourlyPay = h; }
};

//tested with employee object, production worker object, both default and normal constructors, all works

int main()
{
    //default production worker constructor
    ProductionWorker defaultWorker = ProductionWorker();
    cout << "Default production worker constructor\n";
    cout << "Name: " << defaultWorker.getName() << endl;
    cout << "Employee Number: " << defaultWorker.getEmpNum() << endl;
    cout <<  "Hire Date: " << defaultWorker.getHireDate() << endl;
    cout << "Disabled: " << defaultWorker.getDisabled() << endl;
    cout << "Shift: " << defaultWorker.getShift() << endl;
    cout << "Hourly Pay: " << defaultWorker.getHourlyPay() << endl;

    //production worker with args
    ProductionWorker worker = ProductionWorker("Jeff", 13423, "Jan 4, 2023", true, 1, 12.50);
    cout << "Production worker constructor with args\n";
    cout << "Name: " << worker.getName() << endl;
    cout << "Employee Number: " << worker.getEmpNum() << endl;
    cout <<  "Hire Date: " << worker.getHireDate() << endl;
    cout << "Disabled: " << worker.getDisabled() << endl;
    cout << "Shift: " << worker.getShift() << endl;
    cout << "Hourly Pay: " << worker.getHourlyPay() << endl;

    //employee default constructor
    Employee defaultEmployee = Employee();
    cout << "Default employee constructor\n";
    cout << "Name: " << defaultEmployee.getName() << endl;
    cout << "Employee Number: " << defaultEmployee.getEmpNum() << endl;
    cout <<  "Hire Date: " << defaultEmployee.getHireDate() << endl;
    cout << "Disabled: " << defaultEmployee.getDisabled() << endl;

    //employee with args
    Employee employee = Employee("Bill", 94243, "May 4, 2021", false);
    cout << "Employee constructor with args\n";
    cout << "Name: " << employee.getName() << endl;
    cout << "Employee Number: " << employee.getEmpNum() << endl;
    cout <<  "Hire Date: " << employee.getHireDate() << endl;
    cout << "Disabled: " << employee.getDisabled() << endl;
    return 0;
}