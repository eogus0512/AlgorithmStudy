import sys
import heapq

N, K = map(int, sys.stdin.readline().split())

jews = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
bags = [int(sys.stdin.readline()) for _ in range(K)]
jews.sort()
bags.sort()

result = 0
q = []

for bag in bags:
    while jews and bag >= jews[0][0]:
        heapq.heappush(q, -jews[0][1])
        heapq.heappop(jews)
    if q:
        result += heapq.heappop(q)

print(-result)