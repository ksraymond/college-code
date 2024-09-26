/*
       ECE 1001/1002  Lab 5
       John Lindsey   June 2019
*/
int loopyCounter;

void setup()
{
  pinMode(9, OUTPUT);   // initialize pin 9 as digital output to control the Red LED
  pinMode(10, OUTPUT);  // initialize pin 10 as digital output to control the Green LED
  pinMode(11, OUTPUT);  // initialize pin 11 as digital output to control the Blue LED
}

void loop()
{
  loopyCounter = 0;
  while (loopyCounter < 100)
  {
    analogWrite(9, 255-loopyCounter);
    analogWrite(10, loopyCounter);
    analogWrite(11, loopyCounter);
    delay((255-loopyCounter));
    loopyCounter = loopyCounter + 1;
  }
}
