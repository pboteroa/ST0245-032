class arraylist:
    def size(A):
        print ("The size of the list is equal to ", len(A))
    
    def get(i):
        if i <= len(A):
            print ("The character in position ", i, " is ", A[i])
        else:
            raise IndexError("Index out of bounds=", i)
    
    def add(i, n):
        B = [0]*(len(A)*2)
        if i <= len(A):
            A.insert(i, n)
            print ("List: ", A)
        else:
            raise IndexError("Index out of bounds=", i)
        
    def remove(i):
        if i < len(A):
            A.pop(i)
            print ("List: ", A)
        else:
            raise IndexError("Index out of bounds=", i)
    
    def contains(n):
        if A.contains(n):
            return True
        else:
            return False
        
A = [0, 1, 2, 3, 4]
get(1)
add(6,5)