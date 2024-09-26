/*
   Lab 10
   Use while() loops and variables
   I/O setup JL October 2019
*/

#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  // speaker + terminal connected to pin 5
  pinMode(5, OUTPUT);
  // initialize the lcd display to 2 lines, 16 wide and clear
  lcd.begin(16, 2);
  lcd.clear();
}

void loop()
{


}
