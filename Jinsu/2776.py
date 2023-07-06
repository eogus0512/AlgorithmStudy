def bSearch(arr, s, e, t):
    if s > e:
        return 0
    mid = (s + e) // 2    
    if arr[mid] == t:
        return 1
    elif arr[mid] > t:
        return bSearch(arr, s, mid-1, t)
    elif arr[mid] < t:
        return bSearch(arr, mid+1, e, t)

t = int(input())
for _ in range(t):
    n = int(input())
    li_1 = sorted(set(map(int, input().split())))
    li_1_len = len(li_1)
    m = int(input())
    li_2 = list(map(int, input().split()))
    for i in range(m):
        print(bSearch(li_1, 0, li_1_len-1, li_2[i]))
