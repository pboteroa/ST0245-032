import csv
import time
import os
import psutil  # psutil package may need to be installed

t1 = time.time()


def readFile(file):
    data = []
    with open(file, encoding="utf-8") as hello:
        read = csv.reader(hello, delimiter=";")
        for line in read:
            data.append(line)
        print(data)


readFile(r"C:\Users\samue\PycharmProjects\entrega02\datos.csv")  # Insert data file path
process = psutil.Process(os.getpid())
print("Memory consumed in megabytes:", round((process.memory_info()[0] / 1000000), 2))
t2 = time.time()
time = (t2 - t1) * 1000
print("Time in ms:", round(time, 2))
