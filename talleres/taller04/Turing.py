def turing(array, length):
    maxi=array[length]
    temp=0
    if length==0:
        maxi= array[0]
    elif length!=0:
        temp= turing(array, length-1)
        if temp>maxi:
            maxi=temp
    return maxi
                
print(turing([1,2,3,8,10,4], 5))