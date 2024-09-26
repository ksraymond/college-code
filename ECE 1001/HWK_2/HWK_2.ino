//
//                        HWK_2
//
//
//Name: Keaton Raymond
//Date:9/24/2019
//Class: ECE 1001-005
//
//
//Problem Statement:  Write a program for an up/down counter. Initialize the counter to +10. If up-
//count button is pressed –increment the counter by only one and writethe new value to the LCD.
//Ifdown-count button is pressed –decrement the counter by only one and writethe value to the
//LCD.If youpush and hold either button down –the counter should only change by one.
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      liquidCrystal
//      bool upFlag true
//      bool downFlag true
//      int count = 10
//      #define upButton 6
//      #define downButton 7
//
//    setup function
//      initialize buttons to pins
//      setup LCD
//
//    loop fuction
//      if upButton high and upFlag true
//        count = count + 1
//        update LCD display
//        upFlag = false
//      if upButton low and upFlag false
//        upFlag = true
//      if downButton high and downFlag true
//        count = count - 1
//        update LDC display
//        downFlag = false
//      if downButton low and downFlag false
//        downFlag = true
//
//    end loop function
//

#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

#define upButton 6
#define downButton 7

bool upFlag = true;
bool downFlag = true;

int count = 10;


void setup() 
{
 lcd.begin(16, 1);
 lcd.clear();
 pinMode(upButton, INPUT);
 pinMode(downButton, INPUT);
 lcd.setCursor(0, 0); 
}

void loop() 

{
  if(upButton == HIGH && upFlag == true)
{
    count = count + 1;
    lcd.print(count);
    upFlag == false;
}
  if(upButton == LOW && upFlag == false)
{
    upFlag == true;
}
  if(downButton == HIGH && downFlag == true)
{
    count = count - 1;
    lcd.print(count);
    downFlag == false;
}
  if(downButton == LOW && downFlag == false)
{
    downFlag == true;
}
}
