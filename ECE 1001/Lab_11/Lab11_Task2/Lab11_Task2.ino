//
//                        Lab11_Task2
//
//
//Name: Keaton Raymond and Amyleila Mejia
//Date:11/5/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//have the user calibrate a photoresistor using a button
//only run the calibration code one time
//then infinitely tell the user what percentage of the maximum brightness
//it is reading, using the map() command
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      initialize lcd
//      define button 5
//      int fromHigh, fromLow, brightness
//      bool infinite = true
//      
//
//    setup function
//      setup lcd
//      button input pullup
//      A1 input
//
//    loop function
//      tell user to press button in the dark
//      wait for user to press button and record that light value as fromLow
//      delay(500)
//      tell user to press button in bright and record that light value as fromHigh
//      
//      enter infinite loop
//        map and constrain brightness to 100
//        
//

#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

#define button 5
int fromHigh;
int fromLow;
int brightness;
bool infinite = true;   //bool for infinite loop


void setup()
{
  lcd.begin(16, 2);
  lcd.clear();
  pinMode(button, INPUT_PULLUP);
  pinMode(A1, INPUT);
  Serial.begin(9600);
}

void loop()
{
  //ask user to press button in dark
  lcd.setCursor(0,0);
  lcd.print("Press button in");
  lcd.setCursor(0,1);
  lcd.print("the dark");
  
  do
  {
    fromLow = analogRead(A1);
  } while(digitalRead(button) == HIGH); //end darkness do while loop
  Serial.println(fromLow);

  //ask user to press button in the light
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Press button in");
  lcd.setCursor(0,1);
  lcd.print("brightest area");
  
  delay(500); //500 ms debounce
  
  do
  {
    fromHigh = analogRead(A1);
  } while(digitalRead(button) == HIGH); //end light do while loop
  Serial.println(fromHigh);

  //print text to tell people the brightness
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("The brightness");
  lcd.setCursor(0,1);
  lcd.print("is at");

  
  
  while(infinite == true)
  {
    //read brightness and map it to a percentage
    brightness = analogRead(A1);
    brightness = map(brightness, fromHigh, fromLow, 0, 100);
    brightness = constrain(brightness, 0, 100);

    //clear last number and put a "%" sign
    lcd.setCursor(6,1);
    lcd.print("   ");
    lcd.setCursor(6,1);
    lcd.print(brightness);
    lcd.setCursor(9,1);
    lcd.print("%"); 
    
    delay(750);
    
    Serial.println(brightness);
  } //end infinite loop
} //end loop function
