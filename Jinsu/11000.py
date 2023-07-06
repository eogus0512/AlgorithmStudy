import heapq
import sys
input = sys.stdin.readline

n = int(input())
li = []
q = []

for _ in range(n):
    li.append(tuple(map(int, input().split())))
li.sort()
heapq.heappush(q, li[0][1])
for i in range(1, n):
    if li[i][0] < q[0]:
        heapq.heappush(q, li[i][1])
    else:
        heapq.heappop(q)
        heapq.heappush(q, li[i][1])
print(len(q))
