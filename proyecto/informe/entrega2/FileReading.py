import csv

def readFile(file):
    data= []
    with open(file, encoding="utf-8") as hello:
        read = csv.reader(hello, delimiter=";")
        for line in read:
            data.append(line)
        print(data)
        
readFile("C:/Users/Pedro/Documents/EAFIT/Segundo Semestre/Datos y Algoritmos 1/datos.csv")