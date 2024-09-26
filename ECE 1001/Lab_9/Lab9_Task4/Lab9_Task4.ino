//
//                        Lab9_Task4
//
//
//Name: Keaton Raymond
//Date:10/24/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//perform a series of turns using one wheel pivot turns
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
//        move both wheels forward 10 inches
//        spin the left wheel forward to turn right
//        forward then right again
//        forward
//        spin right wheel forward to turn left
//        forward
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
    digitalWrite(STBY, LOW);     //turn the motor controller standby pin to off
    delay (10);                 //delay for a few milliseconds before checking the button status again
  }

  digitalWrite(STBY, HIGH); //enable the motor controller

  delay(200);  // pause -- get ready!

  //Forward
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(2000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Turn right
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, LOW);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(1000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Forward
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(2000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Turn right
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, LOW);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(1000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Forward
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(2000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Turn left
  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(1000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Forward
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 130);
  analogWrite(PWMB, 150);
  delay(2000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);
}
