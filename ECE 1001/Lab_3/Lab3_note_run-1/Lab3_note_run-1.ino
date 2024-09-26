/*
      ECE 1001/1002  Lab 3 note run
           John Lindsey   June 2019
*/
void setup()
{
  pinMode(9, OUTPUT);   // initialize pin 9 as an output for the speaker

}
void loop ()
{
  tone(9, 220, 250);
  delay(250);
  tone(9, 247, 250);
  delay(250);
  tone(9, 261, 250);
  delay(250);
  tone(9, 294, 250);
  delay(250);
  tone(9, 330, 250);
  delay(250);
  tone(9, 349, 250);
  delay(250);
  tone(9, 392, 250);
  delay(250);
  tone(9, 220, 250);
  delay(250);
  tone(9, 420, 250);
  delay(250);
}
