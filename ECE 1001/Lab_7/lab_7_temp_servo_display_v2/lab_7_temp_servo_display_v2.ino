/*
      ECE 1001/1002  Lab 7 analog temp display with servo
           John Lindsey   June 2019
           September 2019 add average and rounding
*/

#include <Servo.h>


// declare variables for voltage and temp and Servo
float voltage = 0.0;
float voltage1 = 0.0;
float voltage2 = 0.0;
float TemperatureInC = 0.0;
float TemperatureInF = 0.0;
int TemperaturePosition = 0;
int ServoPosition = 0;
Servo myservo;

void setup()
{
  pinMode(A0, INPUT);
  pinMode(9, OUTPUT);
  // the servo control wire is attached to pin 9
  myservo.attach(9);
  Serial.begin(9600);
}

void loop()
{
  // Check TMP36 voltage, average two readings to reduce noise, convert to C and F
  voltage1 = analogRead(A0) * 4.8828125;
  delay(100);
  voltage2 = analogRead(A0) * 4.8828125;
  voltage = (voltage1 + voltage2) / 2;

  TemperatureInC = (voltage - 500) / 10;
  TemperatureInF = TemperatureInC * (9.0 / 5.0) + 32.0;
  Serial.print("TemperatureInC: ");
  Serial.print(TemperatureInC);

  // change from the float variable TemperatureInC to the integer variable TemperaturePosition with a type cast (int)
  // multiply by 100 to move decimals into a integer position
  TemperaturePosition = (int)(TemperatureInC * 100);
  Serial.print(" TemperaturePosition: ");
  Serial.print(TemperaturePosition);

  // map the temperature to the servo postion
  ServoPosition = map(TemperaturePosition, 1500, 3000, 0, 180);
  Serial.print(" servoPosition:  ");
  Serial.println(ServoPosition);
  myservo.write(ServoPosition);
  delay (100);
}
