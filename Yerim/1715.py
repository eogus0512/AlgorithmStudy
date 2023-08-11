
#카드 정렬 문제, heapq 사용
import heapq
import sys
input = sys.stdin.readline
n = int(input())
heap = []
for _ in range(n):
    num = int(input())
    heapq.heappush(heap, num)

res = 0
while len(heap)>1:
    num1 = heapq.heappop(heap) # 10 30
    num2 = heapq.heappop(heap) # 20 40 
    res += num1 + num2 # 30, 70 
    heapq.heappush(heap, num1+num2) # 30 70 

print(res)