def groupSum(x, y, z):
    if x >= len(y):
        return z == 0
    if groupSum(x+1, y, z-y[x]):
        return True
    if groupSum(x+1, y, z):
        return True
    else:
        return False

print(groupSum(0, [2, 4, 8], 10))