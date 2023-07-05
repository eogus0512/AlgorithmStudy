T = int(input())
for _ in range(T):
    N = int(input())
    arrN = set(map(int, input().split())) # list로 하면 시간초과
    M = int(input())
    arrM = list(map(int, input().split()))
    for n in arrM:
        if n in arrN:
            print(1)
        else:
            print(0)

