/*
Keaton Raymond
CS 3060-002
Question:
    write a class named Patient that has member variables for the following data:
        first name
        middle name
        last name
        address
        city
        state
        zip code
        phone number
        name of emergency contact
        phone of emergency contact

    the Patient class should have a constructor that accepts an argument for each member variable. 
    the patient class should also have accessor and mutator functions for each member variable

    next, write a class named Procedure that represents a medical procedure that has been performed on a patient. 
    the Procedure class should have member variables for the following data:
        name of the procedure
        date of the procedure
        name of the practitioner 
        charges for the procedure

    the Procedure class should have a constructor that accepts an argument for each member variable. 
    the procedure class should also have accessor and mutator functions for each member variable

    next, write a program that creates an instance of the patient class, initialized with sample data. 
    then, create 3 instances of the procedure class, initialized with the following data:
        procedure 1                     procedure 2                     procedure 3
        name: physical exam             name: X-ray                     name: blood test
        date: 2/20/2023                 2/20/2023                       2/20/2023
        practitioner: Dr. Irvine        practitioner: Dr. Jamison       practitioner: Dr. Smith
        charge: 250.00                  charge: 500.00                  charge: 200.00

    the program should display the patient's information, information about all 3 of the procedures, and the total charge of the 3 procedures
*/

#include <iostream>
#include <string>
using namespace std;

class Patient
{
    private:
        string firstName;
        string middleName;
        string lastName;
        string address;
        string city;
        string state;
        string zipCode;
        string phoneNumber;
        string emergencyName;
        string emergencyPhone;
    
    public:
        //constructor
        Patient(string firstNameInput, string middleNameInput, string lastNameInput, string addressInput, string cityInput, 
                string stateInput, string zipCodeInput, string phoneNumberInput, string emergencyNameInput, string emergencyPhoneInput)
        {
            firstName = firstNameInput;
            middleName = middleNameInput;
            lastName = lastNameInput;
            address = addressInput;
            city = cityInput;
            state = stateInput;
            zipCode = zipCodeInput;
            phoneNumber = phoneNumberInput;
            emergencyName = emergencyNameInput;
            emergencyPhone = emergencyPhoneInput;
        }

        //getters
        string getFirstName()
        {
            return firstName;
        }
        string getMiddleName()
        {
            return middleName;
        }
        string getLastName()
        {
            return lastName;
        }
        string getAddress()
        {
            return address;
        }
        string getCity()
        {
            return city;
        }
        string getState()
        {
            return state;
        }
        string getZipCode()
        {
            return zipCode;
        }
        string getPhoneNumber()
        {
            return phoneNumber;
        }
        string getEmergencyName()
        {
            return emergencyName;
        }
        string getEmergencyPhone()
        {
            return emergencyPhone;
        }

        //setters
        void setFirstName(string input)
        {
            firstName = input;
        }
        void setMiddleName(string input)
        {
            middleName = input;
        }
        void setLastName(string input)
        {
            lastName = input;
        }
        void setAddress(string input)
        {
            address = input;
        }
        void setCity(string input)
        {
            city = input;
        }
        void setState(string input)
        {
            state = input;
        }
        void setZipCode(string input)
        {
            zipCode = input;
        }
        void setPhoneNumber(string input)
        {
            phoneNumber = input;
        }
        void setEmergencyName(string input)
        {
            emergencyName = input;
        }
        void setEmergencyPhone(string input)
        {
            emergencyPhone = input;
        }
};

class Procedure
{
    private:
        string name;
        string date;
        string practitioner;
        double charges;
    
    public:
        //constructor
        Procedure(string nameInput, string dateInput, string practitionerInput, double chargesInput)
        {
            name = nameInput;
            date = dateInput;
            practitioner = practitionerInput;
            charges = chargesInput;
        }

        //getters
        string getName()
        {
            return name;
        }
        string getDate()
        {
            return date;
        }
        string getPractitioner()
        {
            return practitioner;
        }
        double getCharges()
        {
            return charges;
        }

        //setters
        void setName(string input)
        {
            name = input;
        }
        void setDate(string input)
        {
            date = input;
        }
        void setPractitioner(string input)
        {
            practitioner = input;
        }
        void setCharges(double input)
        {
            charges = input;
        }
};

int main()
{
    double totalCharge=0; //keep track of total

    //declare patient information
    Patient patientObj("Kevin", "Scott", "Hall", "1820 Austin Bluffs Pkwy", "Colorado Springs", 
                        "Colorado", "80920", "719-421-0413", "Sandra Hall", "719-493-0428");
    
    //declare 3 procedures
    Procedure procedure1("Physical Exam", "2/20/2023", "Dr. Irvine", 250.00);
    Procedure procedure2("X-ray", "2/20/2023", "Dr. Jamison", 500.00);
    Procedure procedure3("Blood Test", "2/20/2023", "Dr. Smith", 200.00);

    //print patient info
    cout << "Patient Info\n";
    cout << "------------------\n";
    cout << "Patient first name: " << patientObj.getFirstName() << endl;
    cout << "Patient middle name: " << patientObj.getMiddleName() << endl;
    cout << "Patient last name: " << patientObj.getLastName() << endl;
    cout << "Patient address: " << patientObj.getAddress() << endl;
    cout << "Patient city: " << patientObj.getCity() << endl;
    cout << "Patient state: " << patientObj.getState() << endl;
    cout << "Patient zip code: " << patientObj.getZipCode() << endl;
    cout << "Patient phone number: " << patientObj.getPhoneNumber() << endl;
    cout << "Patient emergency contact's name: " << patientObj.getEmergencyName() << endl;
    cout << "Patient emergency contact's phone number: " << patientObj.getEmergencyPhone() << endl << endl;

    //print info about 3 procedures
    cout << "Procedure 1\n";
    cout << "------------------\n";
    cout << "Procedure name: " << procedure1.getName() << endl;
    cout << "Procedure date: " << procedure1. getDate() << endl;
    cout << "Practitioner: " << procedure1.getPractitioner() << endl;
    cout << "Procedure charges: " << procedure1.getCharges() << endl << endl;
    totalCharge += procedure1.getCharges();
    cout << "Procedure 2\n";
    cout << "------------------\n";
    cout << "Procedure name: " << procedure2.getName() << endl;
    cout << "Procedure date: " << procedure2. getDate() << endl;
    cout << "Practitioner: " << procedure2.getPractitioner() << endl;
    cout << "Procedure charges: " << procedure2.getCharges() << endl << endl;
    totalCharge += procedure2.getCharges();
    cout << "Procedure 3\n";
    cout << "------------------\n";
    cout << "Procedure name: " << procedure3.getName() << endl;
    cout << "Procedure date: " << procedure3. getDate() << endl;
    cout << "Practitioner: " << procedure3.getPractitioner() << endl;
    cout << "Procedure charges: " << procedure3.getCharges() << endl << endl;
    totalCharge += procedure3.getCharges();

    //print total charge
    cout << "Total charges incurred: " << totalCharge << endl;

    return 0;
}