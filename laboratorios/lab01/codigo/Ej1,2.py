def formas(n):
    if n<=2:
        return n;
    return formas(n-1) + formas(n-2)

print(formas(4))