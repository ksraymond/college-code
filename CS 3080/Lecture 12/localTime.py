# time.gmtime(secs) and time.localtime(secs)
import time

secs = time.time()
# seconds since Unix epoch 1/1/1970

print(time.gmtime(secs))  # in UTC
# time.struct_time(tm_year=2022, tm_mon=11, tm_mday=22, tm_hour=1,
# tm_min=51, tm_sec=15, tm_wday=6, tm_yday=327, tm_isdst=0)

print(time.localtime(secs))  # in local time
# time.struct_time(tm_year=2022, tm_mon=11, tm_mday=21, tm_hour=18,
# tm_min=51, tm_sec=15, tm_wday=5, tm_yday=326, tm_isdst=0)


# Misc time functions
# time.sleep()
for _ in range(3):
    print('Tick')
    time.sleep(1)
    print('Tock')
    time.sleep(1)


# Tick
# Tock
# Tick
# Tock
# Tick
# Tock

