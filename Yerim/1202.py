#보석 도둑 문제 , heapq 사용
import sys, heapq
input=sys.stdin.readline
heap = []
n,k = map(int, input().split())
for i in range(n):
    m,v=map(int,input().split())
    heapq.heappush(heap,[m,v]) # 여기서 최대힙 처리는 안되는지?
bag=[int(input()) for _ in range(k)]
bag.sort()
max_w=[]
res=0
print(heap)
for i in range(k):
    while heap and bag[i]>=heap[0][0]: 
        jm,jv=heapq.heappop(heap) 
        heapq.heappush(max_w, -jv)
    if max_w:
        res-=heapq.heappop(max_w)
print(res)