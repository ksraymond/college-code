const int AIN1 = 11;
const int AIN2 = 12;
const int PWMA = 10;
const int BIN1 = 8;
const int BIN2 = 7;
const int PWMB = 9;
const int STBY = 6;
#define button 5
int maxBlack = 30;
int maxRed = 145;
int minRed = 70;
int minYellow = 200;
bool infinite = true;
bool start = true;

void setup()
{
  pinMode(AIN1, OUTPUT);
  pinMode(AIN2, OUTPUT);
  pinMode(PWMA, OUTPUT);
  pinMode(BIN1, OUTPUT);
  pinMode(BIN2, OUTPUT);
  pinMode(PWMB, OUTPUT);
  pinMode(STBY, OUTPUT);
  pinMode(button, INPUT_PULLUP);
  pinMode(A1, INPUT);
  Serial.begin(9600);
}

void loop()
{

  while (digitalRead(button) == HIGH && start == true)
  {
    digitalWrite(STBY, LOW);
    delay(10);
  }
  start = false;
  digitalWrite(STBY, HIGH);

  Serial.println(analogRead(A1));
  delay(250);
  
  if(analogRead(A1) >= minRed && analogRead(A1) < minYellow)
  {
    digitalWrite(AIN1, HIGH);
    digitalWrite(AIN2, LOW);
    digitalWrite(BIN1, HIGH);
    digitalWrite(BIN2, LOW);
    analogWrite(PWMA, 80);
    analogWrite(PWMB, 150);
  }
  
//  else if(color < minRed)
//  {
//    //analogWrite(PWMA, 0);
//    //turn right
//    digitalWrite(AIN1, LOW);
//    digitalWrite(AIN2, LOW);
//    digitalWrite(BIN1, HIGH);
//    digitalWrite(BIN2, LOW);
//    analogWrite(PWMA, 0); //right wheel
//    analogWrite(PWMB, 150); //left wheel
//    delay(500);
//    color = analogRead(A1);
//  }
  
  else if(analogRead(A1) < minRed)
  {
    //turn left
    digitalWrite(AIN1, HIGH);
    digitalWrite(AIN2, LOW);
    digitalWrite(BIN1, HIGH);
    digitalWrite(BIN2, LOW);
    analogWrite(PWMA, 150);
    analogWrite(PWMB, 80);
    //delay(500);
  }
  
  else //(analogRead(A1) > maxRed)
  {
    //stop
    analogWrite(PWMA, 0);
    analogWrite(PWMB, 0);
    
    delay(250);
    
    //re read color
    if(analogRead(A1) >= minYellow)
    {
      while(infinite == true)
      {
        Serial.println(analogRead(A0));
        delay(10);
      }
    }
  }
}
