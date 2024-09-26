//
//                        Lab11_Task3
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
//it is reading, using the map() command for 10 seconds
//then repeat the temperature code for 10 seconds
//infinitely loop the brightness and temperature code
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      initialize lcd
//      define button 5
//      int fromHigh, fromLow, brightness
//      float voltage, tempRead, temp1-3, old avg, new avg
//      bool infinite = true
//      
//
//    setup function
//      setup lcd
//      button input pullup
//      A1 input (photoresistor)
//      pinMode(A0, INPUT) (temp sensor)
//
//    loop function
//      tell user to press button in the dark
//      wait for user to press button and record that light value as fromLow
//      delay(500)
//      tell user to press button in bright and record that light value as fromHigh
//      
//      enter infinite loop
//        map and constrain brightness to 100
//        delay(750)
//        loop for 10 seconds
//        
//        read voltage and convert to deg celsius
//        temp3 = temp2
//        temp2 = temp1
//        temp1 = tempRead
//      
//        print the three temperatures with temp1 being on the left and temp3 being on the right
//     
//        calculate new average
//        if statements comparing if the old avg is higher than the new avg and by how much
//          and what to display on the bottom row of the lcd
//
//        oldAvg = newAvg
//        delay(1250)
//        repeat for 10 seconds
//        
//

#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

#define button 5
int fromHigh;
int fromLow;
int brightness;
bool infinite = true; //bool for infinite loop
float voltage = 0.0;
float tempRead = 0.0;
float temp1 = 0.0;    //left temp
float temp2 = 0.0;    //middle temp
float temp3 = 0.0;    //right temp
float oldAvg = 0.0;
float newAvg = 0.0;


void setup()
{
  lcd.begin(16, 2);
  lcd.clear();
  pinMode(button, INPUT_PULLUP);
  pinMode(A0, INPUT);
  pinMode(A1, INPUT);
  Serial.begin(9600);
} //end setup

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
  
  while(infinite == true)
  {
    for(int i=0; i<13; i++)
    {
      //print text to tell people the brightness
      lcd.clear();
      lcd.setCursor(0,0);
      lcd.print("The brightness");
      lcd.setCursor(0,1);
      lcd.print("is at");

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
    } //end 10 second brightness loop
    
    lcd.clear(); //clear text from brightness loop
    
    for(int j=0; j<8; j++) {
      //read the temp, convert to celsius
      voltage = analogRead(A0) * 4.8828125;
      tempRead = (voltage - 500)/10;
      //move old temps over, new temp on the left
      temp3 = temp2;
      temp2 = temp1;
      temp1 = tempRead;
    
      //display each temp in the appropriate position
      lcd.setCursor(0,0);
      lcd.print(temp1);
      lcd.setCursor(6,0);
      lcd.print(temp2);
      lcd.setCursor(12,0);
      lcd.print(temp3);
    
      //calculate average temp
      newAvg = (temp1+temp2+temp3)/3;
    
      //if the new avg is at least .15 deg less than the previous avg, display falling on the left
      if(oldAvg - newAvg >= 0.15)
      {
        lcd.setCursor(0,1);
        lcd.print("falling         ");
      } //end if new avg is less than old avg
    
      //if the new avg is at least .15 deg more than the previous avg, display rising on the right
      else if(newAvg - oldAvg >= 0.15)
      {
        lcd.setCursor(0,1);
        lcd.print("          rising");
      } //end if new avg is more than the old avg
    
      //if the new avg is within .15 deg than the previous avg, display stable in the middle
      else
      {
        lcd.setCursor(0,1);
        lcd.print("     stable     ");
      } //end else new avg is within .15 deg of old avg
    
      oldAvg = newAvg;  //make the new avg the old avg so you can store it as the last average
      delay(1250);
    } //end 10 second brightness loop
    
    lcd.clear(); //clear temperature text
    
  } //end infinite loop
  
} //end loop
