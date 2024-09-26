  /*
      ECE 1001/1002  Lab 6 analog voltage display
           John Lindsey   June 2019
*/

// this next line makes the liquid crystal display library available to the program
#include <LiquidCrystal.h>

// configure the liquid crystal and Arduino pin connections
// LiquidCrystal(rs, enable, d4, d5, d6, d7)
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  lcd.begin(16, 2);   //starting the LCD as a 16 character, 2 line display
  lcd.clear();
  pinMode(A1, INPUT);
}

void loop()
{
  lcd.setCursor(0, 0);
  lcd.print("Raw Value:");
  lcd.setCursor(11, 0);
  lcd.print(analogRead(A1));
  lcd.setCursor(0, 1);
  lcd.print("mV:");
  lcd.setCursor(4, 1);
  lcd.print(analogRead(A1) * 4.8828);  // ADC reads 1024 steps, convert to mV
  delay (500); //delay so the reading doesn't change too often
  lcd.clear();
}
