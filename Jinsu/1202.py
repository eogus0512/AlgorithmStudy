# 1202 보석 도둑
import sys
from heapq import heappush, heappop
input = sys.stdin.readline

n, k = map(int, input().split())
j = [] # 보석
b = [] # 가방
res = 0
for _ in range(n):
    j.append(tuple(map(int, input().split())))
for _ in range(k):
    b.append(int(input()))
j.sort()
b.sort()

temp = [] # 가방이 있다면 넣을 수 있는 보석 max heap(가치)
idx = 0 # 현재 보석 인덱스
for back in b:
    # 현재 가방에 넣을 수 있는 무게의 보석을 힙에 넣기
    while idx != n and back >= j[idx][0]:
        heappush(temp, -j[idx][1])
        idx += 1
    if temp:
        res += -heappop(temp)
    # 더 이상 넣을 수 있는 보석이 없는 경우
    else:
        if idx == n:
            break
print(res)