/*
      ECE 1001/1002  Lab 3 four key instrument
           John Lindsey   June 2019
*/
void setup()
{
  // initialize pin 9 as an output for the speaker
  pinMode(9, OUTPUT);   

  //initialize pins 4, 5, 6, 7 as button inputs with internal pullup resistors
  pinMode(4, INPUT_PULLUP);
  pinMode(5, INPUT_PULLUP);
  pinMode(6, INPUT_PULLUP);
  pinMode(7, INPUT_PULLUP);
}

void loop ()
{
  if (digitalRead(4) == LOW)
  {
    tone(9, 247, 250);
  }
  else if (digitalRead(5) == LOW)
  {
    tone(9, 261, 250);
  }
  else if (digitalRead(6) == LOW)
  {
    tone(9, 294, 250);
  }
  else if (digitalRead(7) == LOW)
  {
    tone(9, 330, 250);
  }
  else
  {
    noTone(9);
  }
}
