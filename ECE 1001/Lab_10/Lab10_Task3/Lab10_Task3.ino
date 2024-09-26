//
//                        Lab10_Task3
//
//
//Name: Keaton Raymond and Amyleila Mejia
//Date:11/7/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//display the letter h randomly only on the top row
//and the letter g randomly only on the bottom row,
//display each character for .25 seconds
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      int h and g
//      initialize the lcd
//
//    setup function
//      setup lcd
//
//    loop function
//      h and g = random numbers from 0 to 15
//      set cursor to (h,0) and print h for .25 sec
//      set cursor to (g,0) and print g for .25 sec
//

#define buzzer 5
int h;
int g;
#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  // initialize the lcd display to 2 lines, 16 wide and clear
  lcd.begin(16, 2);
  lcd.clear();
}

void loop()
{
  //h and g random numbers from 0-15
  h=random(16);
  g=random(16);

  //print h on the top row in a random column h
  lcd.setCursor(h,0);
  lcd.print("h");
  delay(250);
  lcd.clear();

  //print g on the bottom row in a random column g
  lcd.setCursor(g,1);
  lcd.print("g");
  delay(250);
  lcd.clear();

}
