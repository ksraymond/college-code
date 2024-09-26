#define LED_Output 6
#define LED_Input 9

void setup()
{
  pinMode(LED_Output, OUTPUT);
  pinMode(LED_Input, INPUT);
}
  void loop ()
  {
  if (digitalRead(LED_Input) == LOW)
  {
    digitalWrite(LED_Output, HIGH);
  }
  else
  {
    digitalWrite(LED_Output, LOW);
  }
}
