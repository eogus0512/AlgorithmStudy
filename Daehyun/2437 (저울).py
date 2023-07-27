N = int(input())
array = list(map(int, input().split()))
array.sort()

result = 1
for arr in array:
    if result < arr:
        break
    result += arr

print(result)