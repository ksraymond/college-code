def kelvinToFahrenheit(temp):
   assert (temp >= 0), "Colder than absolute zero!"
   return ((temp-273)*1.8)+32


print(kelvinToFahrenheit(273))
print(int(kelvinToFahrenheit(505.78)))
print(kelvinToFahrenheit(-5))
# 32.0
# 451
# AssertionError: Colder than absolute zero!
