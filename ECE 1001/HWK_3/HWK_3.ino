//
//                        HWK_3
//
//
//Name: Keaton Raymond
//Date:10/10/2019
//Class: ECE 1001-005
//
//
//Problem Statement:
//1.Wait until the button is pushed--until the button is pushed, nothing happens
//2.turn a light on for 0.75 seconds, off for 0.25 seconds
//3.wait 5 seconds
//4.repeat steps 2 and 3 for 5 times using a for() loop,
//  each time through the loop it should blink the light one more time
//  (first time blinks once–first time thru loop, second time blinks twice–second time thru loop, etc.)
//5.After 5 times through, returns to step 1
//
//
//              ^^^^ Algorithm ^^^^
//
//    define and initialize variables
//        #define button 8
//        #define LED 9
//        int i
//        int count
//
//    setup function
//      initialize buttons to pins
//
//    loop function
//      while loop waiting for button to be pressed
//      when button is pressed enter a for loop
//        in the for loop the light HIGH for .75 sec, low for .25 sec
//        wait 5 seconds
//        blink LED again but this time blinking twice, do this 5 times
//      after 5 loops of blinking the LED 1 more time than the last, go back to the while loop of waiting for the button to be pressed
//

#define button 8
#define LED 9
int i;
int count;

void setup() 
{

pinMode(button, INPUT_PULLUP);
pinMode(LED, OUTPUT);

}

void loop() 
{

while(digitalRead(button) == HIGH)
{
  delay(1);
}

for(count=0; count<5; count++)
{
  for(i=0; i<=count; i++)
  {
    digitalWrite(LED, HIGH);
    delay(750);
    digitalWrite(LED, LOW);
    delay(250);
  }
  delay(5000);
}

}
