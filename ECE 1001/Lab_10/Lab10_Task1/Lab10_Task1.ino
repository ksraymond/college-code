//
//                        Lab10_Task1
//
//
//Name: Keaton Raymond and Amyleila Mejia
//Date:11/7/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//write a program using while loops that displays the letter "h" in the lower left corner
//of the display for .75 sec then erase the display, write an h in each
//column of the bottom row from right to left then do the same to the top row
//after the top row is done, loop back to where you started and do it again
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      int y = 1 and x = 0
//      initialize the lcd display
//
//    setup function
//      setup the lcd
//
//    loop function
//      while loop for the bottom y row
//        while loop for the x position
//          set the cursor to x,y
//          print h for .75 sec then clear
//          add one to x
//        when x reaches the end of the display, 15, exit x while loop
//        subtract 1 from y and set x back equal to 0
//      after y finishes the top row, y=0, exit y while loop and set y equal to 1
//

int y = 1;
int x = 0;
#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  lcd.begin(16, 2);
  lcd.clear();
}

void loop()
{
  while(y >= 0)   //while loop for the y coordinate
  {
    while(x <= 15)    //while loop to print the location of h, then move it one to the right
    {
      lcd.setCursor(x,y);
      lcd.print("h");
      delay(750);
      lcd.clear();
      x++;
    }
    y--;    //subtract 1 from y, move it up a row
    x=0;    //reset x
  }
  y=1;    //reset y
}
