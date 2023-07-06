n = int(input())
li = list(map(int, input().split()))
li.sort()
res = 0

for i in range(n):
    new_li = li[:i] + li[i+1:]
    s = 0
    e = n-2
    while s < e:
        total = new_li[s] + new_li[e]
        if total == li[i]:
            res += 1
            break
        elif total > li[i]:
            e -= 1
        else:
            s += 1
print(res)
