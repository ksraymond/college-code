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
  //all three on
  digitalWrite(9, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(11, HIGH);
  delay(14);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW);
  delay(1);
}
