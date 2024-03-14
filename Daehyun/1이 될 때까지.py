n, k = map(int, input().split())
result = 0

# while True:
#     if n % k == 0:
#         n /= k
#     else:
#         n -= 1
#     result += 1
#     if n == 1:
#         break

while True:
    temp = n % k
    result += temp
    n -= temp
    if n < k:
        break
    result += 1
    n //= k

result += n-1
print(result)