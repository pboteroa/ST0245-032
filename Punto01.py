def euclides(x, y):
    if y == 0:
        return x
    else:
        return euclides(y, x % y)


print(euclides(345, 150))
