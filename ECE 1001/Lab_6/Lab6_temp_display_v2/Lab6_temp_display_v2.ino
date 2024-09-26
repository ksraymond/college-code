/*
      ECE 1001/1002  Lab 6 analog voltage display
           John Lindsey   June 2019
*/

// this next line makes the liquid cyrstal display library available to the program
#include <LiquidCrystal.h>

// configure the liquid crystal and Arduino pin connections
// LiquidCrystal(rs, enable, d4, d5, d6, d7)
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
// declare variables for voltage and temp
float voltage = 0.0;
float TemperatureInC = 0.0;
float TemperatureInF = 0.0;

void setup()
{
  lcd.begin(16, 2);   //starting the LCD as a 16 character, 2 line display
  lcd.clear();
}

void loop()
{ 
  // Check TMP36 voltage, convert to C and F
  voltage = analogRead(A0) * 4.8828125;
  TemperatureInC = (voltage - 500)/10;
  TemperatureInF = TemperatureInC * (9.0 / 5.0) + 32.0;
  // Display temp in C for 0.5 sec
  lcd.clear();
  lcd.setCursor(0, 1);
  lcd.print(voltage);
  lcd.setCursor(11, 1);
  lcd.print("mV");
  lcd.setCursor(0, 0);
  lcd.print(TemperatureInC);
  lcd.setCursor(11, 0);
  lcd.print("deg C");
  delay (1000);
  // Display temp in F for 0.5 sec
  lcd.clear();
  lcd.setCursor(0, 1);
  lcd.print(voltage);
  lcd.setCursor(11, 1);
  lcd.print("mV");
  lcd.setCursor(0, 0);
  lcd.print(TemperatureInF);
  lcd.setCursor(11, 0);
  lcd.print("deg F");
  delay (1000);
}
