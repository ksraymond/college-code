/*
      ECE 1001/1002  Lab 4 simple text display
           John Lindsey   June 2019
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
}

void loop()
{
  lcd.setCursor(0, 0);         //position 0,0 is the top left corner
  lcd.print("Keaton");        //the display will print what is between the double quotes

  lcd.setCursor(0, 1);         //Set the x, y position for the next print command; x=0 is left, y=0 is top
  lcd.print("Raymond");

  //delay(1000);

  //lcd.clear();

  //delay(1000);
}
