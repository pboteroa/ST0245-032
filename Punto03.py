def combinations(var, s):
    if len(s) == 0:
        print(var)
    else:
        combinations(var + s[0], s[1:])
        combinations(var, s[1:])


combinations("", "123")
