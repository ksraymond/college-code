// ECE 1001 - 005
// Lab 1, Blink Lights
// Keaton Raymond
// Sept 5, 2019

void setup() {
pinMode(13, OUTPUT); // Initializes pin 13 as an output
}

void loop() 
{
// Utilizes delays and pin 13 to blink the LED
digitalWrite(13, HIGH);
delay(500);
digitalWrite(13, LOW);
delay(500);
}
