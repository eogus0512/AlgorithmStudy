n, m, k = map(int, input().split())
array = list(map(int, input().split()))

array.sort()

first = array[n-1]
second = array[n-2]
result = 0
while True:
    for _ in range(k):
        result += first
        m -= 1
    if m == 0:
        break
    result += second
    m -= 1
    if m == 0:
        break

print(result)