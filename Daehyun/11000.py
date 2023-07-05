import heapq
import sys # 이거 안쓰면 시간 초과

N = int(input())
q = []
for _ in range(N):
    S, T = map(int, sys.stdin.readline().split())
    q.append([S, T])
q.sort() # 시작 시간 기준으로 정렬

room = [] # 강의실
heapq.heappush(room, q[0][1]) # 첫번째 배열 요소로 강의실 한개 추가

for i in range(1, N):
    if q[i][0] >= room[0]: # 첫번째 강의실 끝나는 시간보다 다음 강의 시작 시간이 더 느리면
        heapq.heappop(room) # 첫번째 강의실 끝나는 시간을 변경하기 위해 pop
    heapq.heappush(room, q[i][1]) # 새로운 강의실 추가 또는 강의실 끝나는 시간 갱신

print(len(room))