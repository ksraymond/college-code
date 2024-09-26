# Second example
from datetime import datetime


def notDuringTheNight(func):
    def wrapper():
        if 7 <= datetime.now().hour < 22:
            func()
        else:
            pass  # Hush, the neighbors are asleep
    return wrapper


def sayWhee():
    print("Whee!")


decoratedSayWhee = notDuringTheNight(sayWhee)
decoratedSayWhee()
