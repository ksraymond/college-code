//program to print a 4x4 grid of * using loops



#include ldc    //include LCD Library, not actual function, placeholder for example code

int i;
int j;


void setup()
{

}

void loop()
{

for(i=1; i<=4; i++)
{
  
  lcd.setCursor(i-1,0);

  for(j=1; j<=4; j++)
  {

    lcd.print('*');
    
  }
  
}

}
