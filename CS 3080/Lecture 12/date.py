import datetime
import time

print(type(datetime.datetime.now()))
# <class 'datetime.datetime'>
print(datetime.datetime.now())
# 2022-11-12 16:48:46.877234 (your actual time)
dt = datetime.datetime(2015, 10, 21, 16, 29, 0)
print(dt.year, dt.month, dt.day)
# 2015 10 21
print(dt.hour, dt.minute, dt.second)
# 16 29 0


print(datetime.datetime.fromtimestamp(1000000))
# 1970-01-12 06:46:40
print(datetime.datetime.fromtimestamp(time.time()))
# 2022-11-12 16:48:46.877289


thanksgiving2022 = datetime.datetime(2022, 11, 24, 0, 0, 0)
newyears2023 = datetime.datetime(2023, 1, 1, 0, 0, 0)
nov24_2022 = datetime.datetime(2022, 11, 24, 0, 0, 0)

print(thanksgiving2022 == nov24_2022)	# True
print(thanksgiving2022 > newyears2023)	# False
print(newyears2023 > thanksgiving2022)	# True
print(newyears2023 != nov24_2022)	# True


christmas2022 = datetime.datetime(2022, 12, 25, 0, 0, 0)
while datetime.datetime.now() < christmas2022:
    print(datetime.datetime.now())
    time.sleep(1)

# --code-- do something after that date