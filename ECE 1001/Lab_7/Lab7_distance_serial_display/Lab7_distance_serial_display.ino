/*
      ECE 1001/1002  Lab 7 Distance serial display
           John Lindsey   June 2019
*/
float distance = 0.0;

void setup()
{
  Serial.begin(9600);  //start the serial monitor at 9600 baud; check setting in IDE matches
  pinMode(11, OUTPUT);  //connected to trigger pin
  pinMode(8, INPUT);    //connected to echo pin
}

void loop()
{ 
//set the trigger pin high for 10 microseconds
digitalWrite(11, HIGH);
delayMicroseconds(10);
digitalWrite(11, LOW);  

//PulseIn measures the time for the echo pin to go from LOW to HIGH in microseconds
//distance is half the pulse time multiplied by speed of sound at 6000 feet altitude
// in inches per microsecond
distance=pulseIn(8,HIGH)/2*0.01242;

Serial.print(distance);
Serial.println("     inches");

}
