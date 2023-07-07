T=int(input())
for _ in range(T):
    s1 = int(input())
    sArr = set(map(int, input().split()))
    s2 = int(input())
    sArr2 = list(map(int, input().split()))
    for i in sArr2:
        print(1 if i in sArr else 0)