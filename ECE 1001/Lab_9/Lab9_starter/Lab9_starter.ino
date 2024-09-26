/*
    Your info goes here!
*/
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
  while (digitalRead(StartButton) == HIGH)   // does nothing but repeats endlessly until the button is pushed; a push makes pin 7 LOW
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
  analogWrite(PWMA, 85);
  analogWrite(PWMB, 85);
  delay(1000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //Turn one way
  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, LOW);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 150);
  analogWrite(PWMB, 150);
  delay(250);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);

  //backwards
  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, HIGH);
  digitalWrite(BIN1, LOW);
  digitalWrite(BIN2, HIGH);
  analogWrite(PWMA, 150);
  analogWrite(PWMB, 150);
  delay(1000);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);

   //Turn other way
  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, HIGH);
  digitalWrite(BIN1, HIGH);
  digitalWrite(BIN2, LOW);
  analogWrite(PWMA, 150);
  analogWrite(PWMB, 150);
  delay(250);
  //stop
  analogWrite(PWMA, 0);
  analogWrite(PWMB, 0);
  delay(250);
}
