#Si에 시작해서 Ti에 끝나는 N개의 수업, 최소한의 강의실을 이용해서 모든 수업을 끝내야 함
#끝남과 동시에 시작 가능 , 강의실 개수 출력
#heap 사용
import heapq
import sys
input=sys.stdin.readline

N=int(input())
heap=[]
arr=[]
for _ in range(N):
  a,b=map(int,input().split())
  arr.append([a,b]) #[시작,끝] 리스트 형태로 추가
arr.sort() # 시작 시간 기준 정렬
heapq.heappush(heap,arr[0][1])
for i in range(1,N):
    if arr[i][0] < heap[0]: # 다음 강의 시간이 이전 강의 종료 시간 보다 빠르면 
        heapq.heappush(heap,arr[i][1]) # 새롭게 강의실 배정, push
    else: #이어서 강의를 시작한다면
        heapq.heappop(heap) #  강의 pop한 후 새로운 강의 시간 push
        heapq.heappush(heap,arr[i][1]) 
print(len(heap))
