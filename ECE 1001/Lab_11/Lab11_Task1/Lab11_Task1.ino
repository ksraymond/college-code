//
//                        Lab11_Task1
//
//
//Name: Keaton Raymond and Amyleila Mejia
//Date:11/5/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//display 3 temperatures from newest to oldest with the newest being on the left
//if the average of the three temps is .15 deg higher compared to the previous avg
//display rising on the right side of the botttom row
//if the average is .15 deg lower compared to the previous avg display falling
//on the left side of the bottom row
//if it is within .15 of the previous avg display stable in the middle
//delay 1.25 sec between each temp read
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//      float voltage, tempRead, temp1-3, old avg, new avg
//      initialize lcd
//
//    setup function
//      setup lcd
//      pinMode(A0, INPUT) (temp sensor)
//
//    loop function
//      read voltage and convert to deg celsius
//      temp3 = temp2
//      temp2 = temp1
//      temp1 = tempRead
//      
//      print the three temperatures with temp1 being on the left and temp3 being on the right
//     
//      calculate new average
//      if statements comparing if the old avg is higher than the new avg and by how much
//        and what to display on the bottom row of the lcd
//
//      oldAvg = newAvg
//      delay(1250)
//

#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

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
  pinMode(A0, INPUT);
} //end setup

void loop()
{
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
  } //end if new avg is lower

  //if the new avg is at least .15 deg more than the previous avg, display rising on the right
  else if(newAvg - oldAvg >= 0.15)
  {
    lcd.setCursor(0,1);
    lcd.print("          rising");
  } //end of new avg is higher

  //if the new avg is within .15 deg than the previous avg, display stable in the middle
  else
  {
    lcd.setCursor(0,1);
    lcd.print("     stable     ");
  } //end if new avg is within 0.15

  oldAvg = newAvg;  //make the new avg the old avg so you can store it as the last average
  delay(1250);
} //end loop function
