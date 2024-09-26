/*
      ECE 1001/1002  Lab 8 bot moves
           John Lindsey   June 2019
*/
const int AIN1 = 11;
const int AIN2 = 12;
const int PWMA = 10;
const int BIN1 = 8;
const int BIN2 = 7;
const int PWMB = 9;

void setup()
{
  pinMode(AIN1, OUTPUT);
  pinMode(AIN2, OUTPUT);
  pinMode(PWMA, OUTPUT);
  pinMode(BIN1, OUTPUT);
  pinMode(BIN2, OUTPUT);
  pinMode(PWMB, OUTPUT);
}

void loop()
{
  // pause for 1/2 second--get ready!
  delay(500);
  //"Forward"
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);

  analogWrite(PWMA, 256 / 2);
  analogWrite(PWMB, 256 / 2);
  delay(500);

  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Turn one way or the other
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, LOW);
  digitalWrite(BIN2, HIGH);

  analogWrite(PWMA, 256 / 2);
  analogWrite(PWMB, 256 / 2);
  delay(250);

  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);


  //"Reverse"

  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, HIGH);
  digitalWrite(BIN1, LOW);
  digitalWrite(BIN2, HIGH);

  analogWrite(PWMA, 256 / 2);
  analogWrite(PWMB, 256 / 2);
  
  delay(250);
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);

  //infinite while loop to stop the program
  while (true)
  {
    delay(10);
  }
}
