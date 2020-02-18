import time

def insertionSort(a): 
    for i in range(1, len(a)): 
        key = a[i] 
        j = i-1
        while j >=0 and key < a[j] : 
                a[j+1] = a[j] 
                j -= 1
        a[j+1] = key  
    
def printArray(a, n):
    for i in range(n):
        print (a[i])
        
def counter():
    start= time.perf_counter()
    insertionSort(a)
    end= time.perf_counter()
    print(end-start)
    
def createArray(a):
    for i in range(15000000):
        a[i]=i
        
a= [0]*15000000
createArray(a)
n= len(a)
insertionSort(a)
counter()