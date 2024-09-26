# Getting the traceback as a string 1
def spam():
    bacon()


def bacon():
    raise Exception('This is the error message.')


#spam()
# Traceback (most recent call last):
#   File "/Users/yyzh/PycharmProjects/CS3080/Lec11/traceBack.py", line 10, in <module>
#     spam()
#   File "/Users/yyzh/PycharmProjects/CS3080/Lec11/traceBack.py", line 3, in spam
#     bacon()
#   File "/Users/yyzh/PycharmProjects/CS3080/Lec11/traceBack.py", line 7, in bacon
#     raise Exception('This is the error message.')
# Exception: This is the error message.


# Getting the traceback as a string 2
import traceback

try:
    raise Exception('This is the error message.')
except:
    errorFile = open('errorInfo.txt', 'w')
    errorFile.write(traceback.format_exc())
    errorFile.close()
    print('The traceback info was written to errorInfo.txt.')
# The traceback info was written to errorInfo.txt.

