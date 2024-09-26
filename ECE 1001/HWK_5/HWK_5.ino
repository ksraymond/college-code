//
//                        HWK_5
//
//
//Name: Keaton Raymond
//Date:10/31/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//RANDOM DANCE -Write a program that fills two arrays–both size 32
//–with random numbers. Experimentally determine the time needed to 
//drive ~10 inches for a fixed power level you pick. Fill one array 
//with random numbers between -time and +time to drive.
//Experimentally determine the time to turn -270 and +270 degrees. 
//Fill the second array with random numbers between these two values.
//At the start of the program, delay 1 second to remove your finger
//from the Arduino board. Then using a for loop, loop 32 times. In the 
//loop, read the random time to drive and drive. Then read the random
//time to turn and turn. No delay between drive and turn. A random dance.
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      initialize variables for robot
//      initialize button
//      int count for drive, turn loop
//      int d for assigning random numbers to drive array
//      int t for assigning random numbers to turn array
//      int drive and turn for the amount of time it has to drive or turn
//      array turn 32
//      array drive 32
//
//    setup function
//      setup pins for robot and button
//
//    loop function
//      while loop waiting for button to be pressed
//      when button is pressed delay 1000
//      for loop to assign a random number between -2000 and 2000 to drive array
//      for loop to assign a random number between -3000 and 3000 to turn array
//      for loop to do drive then turn 32 times
//        if the value is less than 0 turn left the absolute value of the time
//        if the value is more than or equal to 0 turn right the value of time
//        repeat the ifs but for drive forward or straight
//

const int AIN1 = 11;
const int AIN2 = 12;
const int PWMA = 10;
const int BIN1 = 8;
const int BIN2 = 7;
const int PWMB = 9;
const int STBY = 6;
const int startButton = 5;
int count;
int d;
int t;
int drive;
int turn;
int randomDrive[32] = {};
int randomTurn[32] = {};

void setup() 
{
  pinMode(AIN1, OUTPUT);
  pinMode(AIN2, OUTPUT);
  pinMode(PWMA, OUTPUT);
  pinMode(BIN1, OUTPUT);
  pinMode(BIN2, OUTPUT);
  pinMode(PWMB, OUTPUT);
  pinMode(STBY, OUTPUT);
  pinMode(startButton, INPUT_PULLUP);
}

void loop() 
{
  //assigning random numbers to drive array
  for(d=0; d<32; d++)
  {
    randomDrive[d] = random(-2000, 2001);
  }
  //assigning random numbers to turn array
  for(t=0; t<32; t++)
  {
    randomTurn[t] = random(-3000, 3000);
  }

  //waiting for button to be pressed
  while (digitalRead(startButton) == HIGH)
  {
    digitalWrite(STBY, LOW);
    delay(10);
  }
  
  delay(1000);

  //overarching for loop cycling through each of the random numbers in each array
  for(count = 0; count<32; count++)
  {
    drive = randomDrive[count];
    //if the amount of time is less than 0, it will drive backwards for that positive amount of time
    if(drive < 0)
    {
      //backwards
      digitalWrite(AIN1, LOW);
      digitalWrite(AIN2, HIGH);
      digitalWrite(BIN1, LOW);
      digitalWrite(BIN2, HIGH);
      analogWrite(PWMA, 130);
      analogWrite(PWMB, 150);
      delay(abs(drive));
      //stop
      analogWrite(PWMA, 0);
      analogWrite(PWMB, 0);
    }
    //if the amount of time is greater than or equal to 0, it will drive forward for that amount of time
    else if(drive >= 0)
    {
      //Forward
      digitalWrite(AIN1, HIGH);
      digitalWrite(AIN2, LOW);
      digitalWrite(BIN1, HIGH);
      digitalWrite(BIN2, LOW);
      analogWrite(PWMA, 130);
      analogWrite(PWMB, 150);
      delay(drive);
      //stop
      analogWrite(PWMA, 0);
      analogWrite(PWMB, 0);
    }
    turn = randomTurn[count];
    //if the amount of time is less than 0, it will turn left for that positive amount of time
    if(turn < 0)
    {
      //Turn left
      digitalWrite(AIN1, LOW);
      digitalWrite(AIN2, LOW);
      digitalWrite(BIN1, HIGH);
      digitalWrite(BIN2, LOW);
      analogWrite(PWMA, 130);
      analogWrite(PWMB, 150);
      delay(abs(turn));
      //stop
      analogWrite(PWMA, 0);
      analogWrite(PWMB, 0);
    }
    //if the amount of time is greater than or equal to 0, it will turn right for that amount of time 
    else if(turn >= 0)
    {
      //Turn right
      digitalWrite(AIN1, HIGH);
      digitalWrite(AIN2, LOW);
      digitalWrite(BIN1, LOW);
      digitalWrite(BIN2, LOW);
      analogWrite(PWMA, 130);
      analogWrite(PWMB, 150);
      delay(turn);
      //stop
      analogWrite(PWMA, 0);
      analogWrite(PWMB, 0);
    }
  }
}
