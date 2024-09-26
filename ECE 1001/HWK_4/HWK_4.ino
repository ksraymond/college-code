//
//                        HWK_4
//
//
//Name: Keaton Raymond
//Date:10/22/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//use if else statements and looping structures to blink an LED based on the position of the potentiometer
//blink 1 time if it is less than 600
//blink 2 times if it is between 600 and 650, including 600 and 650
//blink 3 times if it is above 650
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//        define potPin A1 and ledPin 13
//        int value and count
//        bool testOne, testTwo, and testThree all true
//
//    setup function
//        initialize pins and Serial.begin(9600) to read the pot value
//
//    loop function
//        value = analogRead(potPin)
//        serial.println(value)
//        if the value is less than 600
//          set test 2 and 3 to true
//          blink light 1 time
//          set test 1 to false
//        else if the value is between 600 and 650
//          set test 1 and 3 to true
//          use for loop to blink led 2 times
//          set test 2 to false
//        else if the value is more than 650
//          set test 1 and 2 to true
//          use for loop to blink led 3 times
//          set test 3 to false
//

#define potPin A1
#define ledPin 13
int value;
int count;
bool testOne = true;
bool testTwo = true;
bool testThree = true;

void setup()
{
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
  pinMode(potPin, INPUT);
}

void loop()
{
  value = analogRead(potPin);
  Serial.println(value);
  
  if(value < 600)
  {
    testTwo = true;
    testThree = true;
    
    if(testOne)
    {
      digitalWrite(ledPin, HIGH);
      delay(250);
      digitalWrite(ledPin, LOW);
      delay(250);
      testOne = false;
    }
  }

  else if(value >= 600 && value <= 650)
  {
    testOne = true;
    testThree = true;
    
    if(testTwo)
    {
      for(count=0; count<2; count++)
      {
        digitalWrite(ledPin, HIGH);
        delay(250);
        digitalWrite(ledPin, LOW);
        delay(250);
      }
      testTwo = false;
    }
  }
  
  else if(value > 650)
  {
    testOne = true;
    testTwo = true;
    
    if(testThree)
    {
      for(count=0; count<3; count++)
      {
        digitalWrite(ledPin, HIGH);
        delay(250);
        digitalWrite(ledPin, LOW);
        delay(250);
      }
      testThree = false;
    }
  }
  
}
