//
//                        Lab9_Task6
//
//
//Name: Keaton Raymond
//Date:10/24/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//move the bot from 1 corner to the opposite corner in a smooth arc
//
//
//              ^^^^ Algorithm ^^^^
//
//    define variables
//
//    setup function
//      initialize all variables for robot to output
//      initialize button to input
//
//    loop function
//        wait for button to be pressed
//        move both wheels forward, giving more power to one wheel to give it an arc
//        test for proper amount of time it takes, then stop the robot
//

//name robot control pins as variables--wire the Arduino according to the following
const int AIN1 = 11;
const int AIN2 = 12;
const int PWMA = 10;
const int BIN1 = 8;
const int BIN2 = 7;
const int PWMB = 9;
const int STBY = 6;
//connect a button between ground and pin 5
const int StartButton = 5;

void setup()
{
  //assign control pins
  pinMode(AIN1, OUTPUT);
  pinMode(AIN2, OUTPUT);
  pinMode(PWMA, OUTPUT);
  pinMode(BIN1, OUTPUT);
  pinMode(BIN2, OUTPUT);
  pinMode(PWMB, OUTPUT);
  pinMode(STBY, OUTPUT);
  pinMode(StartButton, INPUT_PULLUP);
}

void loop()
{
  //waiting for button to be pressed
  while (digitalRead(StartButton) == HIGH)
  {
    digitalWrite(STBY, LOW);
    delay (10);
  }

  digitalWrite(STBY, HIGH);

  delay(200);
  
  //Forward at an arc
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 85);
  analogWrite(PWMB, 150);
  delay(5000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

}
