n, m = map(int, input().split())
result = 0

for i in range(n):
    array = list(map(int, input().split()))

    minData = min(array)
    result = max(minData, result)
print(result)
