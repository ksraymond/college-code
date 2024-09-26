//
//                        Lab10_Task4
//
//
//Name: Keaton Raymond and Amyleila Mejia
//Date:11/7/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//the buzzer plays a 200 hz sound for .25 seconds with the first h displayed
//frequency increases by 50 hz for each "h" displayed 
//when g displays increase by 25 hz
//display h for .75 sec
//display g for .25 sec
//when the tone reaches 3500 hz, enter an infinite loop
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      define buzzer 5
//      int h and g
//      int sound 200
//      initialize LCD
//
//    setup function
//      set pin mode for buzzer and setup LDC
//
//    loop function
//      h and g random 16
//      set cursor to h, 0 and print h
//      play the buzzer sound and keep h displayed for .75 sec
//      add 50 to sound
//      clear lcd
//
//      set cursor to g, 1 and print g
//      play buzzer sound and keep g displayed for .25 sec
//      add 25 to sound
//      clear ldc
//
//      while sound >= 3500 delay 10
//

#define buzzer 5
int h;
int g;
int sound = 200;
#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup()
{
  pinMode(buzzer, OUTPUT);
  // initialize the lcd display to 2 lines, 16 wide and clear
  lcd.begin(16, 2);
  lcd.clear();
}

void loop()
{
  h=random(16);
  g=random(16);

  //display h in a random position on the top line and play sound for .75 sec
  lcd.setCursor(h,0);
  lcd.print("h");
  tone(buzzer, sound, 750);
  delay(750);
  sound += 50; //add 50 to sound value
  lcd.clear();

  //display g in a random position on the bottom line and play a sound for .25 sec
  lcd.setCursor(g,1);
  lcd.print("g");
  tone(buzzer, sound, 250);
  delay(250);
  sound += 25; //add 25 to sound value
  lcd.clear();

  //infinite while loop for when the sound reaches 3500
  while(sound >= 3500)
  {
    delay(10);
  }

}
