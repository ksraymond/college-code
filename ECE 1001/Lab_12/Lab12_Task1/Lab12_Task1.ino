#include <LiquidCrystal.h>
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
int lightPress, lightRead, lightTotal, lightAvg;
#define button 5
bool infinite = true;

void setup() 
{
  lcd.begin(16, 2);
  lcd.clear();
  pinMode(A0, INPUT);
  pinMode(button, INPUT_PULLUP);
  Serial.begin(9600);
}

void loop() 
{
  
  lcd.setCursor(0,0);
  lcd.print("Average  Press");
  
  
  for(int k=0; k < 3; k--)
  {

    if(k == 0)
    {
      lcd.setCursor(15,0);
      lcd.print("B");
    } //tells user it is reading for black
    else if(k == 1)
    {
      lcd.setCursor(15,0);
      lcd.print("R");
    } //tells user it is reading for red
    else
    {
      lcd.setCursor(15,0);
      lcd.print("Y");
    } //tells user it is reading for yellow
 
    for(int j=0; j < 15; j++)
    {
      while (digitalRead(button) == HIGH)
      {
        delay (10);
        lcd.setCursor(15,1);
        lcd.print("R");
      } //end reset while loop
      //delay(250);

      lcd.setCursor(15,1);
      lcd.print(" ");
      lightTotal = 0;
      lightAvg = 0;
      
      for(int i=0; i < 5; i++)
      {
        lightRead = analogRead(A0);
        lightTotal += lightRead;
      } //end avg for loop
      
      lightAvg = lightTotal/5;
      lcd.setCursor(0,1);
      lcd.print("   ");
      lcd.print(lightAvg);
      Serial.println(lightAvg);
  
      while (digitalRead(button) == HIGH)
      {
        delay(10);
      } //end press while loop
      //delay(250);
  
      lightPress = analogRead(A0);
      lcd.setCursor(9,1);
      lcd.print("   ");
      lcd.print(lightPress); 
      Serial.println(lightPress);   
    } //end 10 averages for loop
    
  } //end looping the 10 averages 3 times

  lcd.setCursor(15,1);
  lcd.print("D");
  
  while(infinite == true)
  {
    delay(10);
  }
    
}
