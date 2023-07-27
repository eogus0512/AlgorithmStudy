import heapq

N = int(input())
q = []
for _ in range(N):
    heapq.heappush(q, int(input()))

result = 0
while len(q) > 1:
    a = heapq.heappop(q)
    b = heapq.heappop(q)
    result += a+b
    heapq.heappush(q, a+b)
print(result)