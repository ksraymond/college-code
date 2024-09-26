/*
      ECE 1001/1002  Lab 4 simple text display
           John Lindsey   June 2019
           V2 add clear, and else default with delay 
*/

// this next line makes the liquid cyrstal display library available to the program
#include <LiquidCrystal.h>

// configure the liquid crystal and Arduino pin connections
// LiquidCrystal(rs, enable, d4, d5, d6, d7)
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  lcd.begin(16, 2);   //starting the LCD as a 16 character, 2 line display
  lcd.clear();
  pinMode(7, INPUT_PULLUP);
}

void loop()
{
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("time ms:");
  lcd.setCursor(9, 0);
  lcd.print(millis());
  if (digitalRead(7) == 0)
  {
    lcd.setCursor(0, 1);
    lcd.print("lap time:");
    lcd.setCursor(9, 1);
    lcd.print(millis());
    delay(500);
  }
  else
  {
    delay(10);
  }
}
