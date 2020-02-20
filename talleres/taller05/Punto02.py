import time
t1 = time.time()


def sumArray(array):
    sum = 0
    for i in array:
        sum = sum + i
    return sum


print(sumArray([]))

t2 = time.time()
print(str(t2 - t1))

