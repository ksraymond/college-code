/*
       ECE 1001/1002  Lab 5
       John Lindsey   June 2019
*/
void setup()
{
  pinMode(9, OUTPUT);   // initialize pin 9 as digital output to control the Red LED
  pinMode(10, OUTPUT);  // initialize pin 10 as digital output to control the Green LED
  pinMode(11, OUTPUT);  // initialize pin 11 as digital output to control the Blue LED
}

void loop()
{
  //blink red
  digitalWrite(9, HIGH);
  delay(250);
  digitalWrite(9, LOW);
  delay(250);

  // blink green
  digitalWrite(10, HIGH);
  delay(250);
  digitalWrite(10, LOW);
  delay(250);

  // blink blue
  digitalWrite(11, HIGH);
  delay(250);
  digitalWrite(11, LOW);
  delay(250);

  //all three on
  digitalWrite(9, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(11, HIGH);
  delay(1000);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW);
  delay(250);
}
