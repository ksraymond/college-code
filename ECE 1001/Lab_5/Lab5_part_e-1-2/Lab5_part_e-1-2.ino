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
  analogWrite(9, 20);
  analogWrite(10, 0);
  analogWrite(11, 20);
//  delay(1000);
//  analogWrite(9, 0);
//  analogWrite(10, 0);
//  analogWrite(11, 0);
//  delay(200);
}
