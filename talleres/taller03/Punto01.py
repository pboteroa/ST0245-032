def Hanoi(n, rod1, rod3, rod2):
    if n == 1:
        print("Move disk 1 from rod", rod1, "to rod", rod3)

    else:
        Hanoi(n - 1, rod1, rod2, rod3)
        print("Move disk", n, "from rod", rod1, "to rod", rod3)
        Hanoi(n - 1, rod2, rod3, rod1)


n = 3
Hanoi(n, 'A', 'C', 'B')
