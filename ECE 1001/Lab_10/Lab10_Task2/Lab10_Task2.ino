//
//                        Lab10_Task2
//
//
//Name: Keaton Raymond and Amyleila Mejia
//Date:11/7/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//use the random command to display the letter h
//randomly on any row or column, the letter h
//should remain visible for 0.5 sec then clear,
//if the coordinates (15,0) are randomly chosen,
//the h should remain visible for 1.5 seconds then clear,
//the program should run forever
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      int x and y
//      initialize lcd
//
//    setup function
//      setup lcd
//
//    loop function
//      y = a random number from 0 to 1
//      x = a random number from 0 to 15
//      set cursor to (x,y) and print h for .5 sec
//      if x = 15 & y = 0
//        set cursor to (x,y) and print h for 1.5 sec
//

int y;
int x;
#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  lcd.begin(16, 2);
  lcd.clear();
}

void loop()
{
  y=random(2);    //random number from 0-1
  x=random(16);   //random number from 0-15

  //print h at the random coordinates x,y
  lcd.setCursor(x,y);
  lcd.print("h");
  delay(500);
  lcd.clear();

  //if x = 15 and y = 0 display h for 1.5 sec
  if(x == 15 && y == 0)
  {
    lcd.setCursor(x,y);
    lcd.print("h");
    delay(1500);
    lcd.clear();
  }
}
