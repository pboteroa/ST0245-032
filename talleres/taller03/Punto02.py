def permutaciones(s):
    out = []

    if len(s) == 1:
        out = [s]
    else:
        for i, let in enumerate(s):
            for perm in permutaciones(s[:i] + s[i + 1:]):
                out += [let + perm]
    return out


print(permutaciones("ABC"))
