import sys
input = sys.stdin.readline
from collections import deque


N,L,R = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
#상하좌우
dx = [0,0,1,-1]
dy = [1,-1,0,0]
def bfs(a,b):
    queue = deque()
    res = []
    queue.append((a,b))
    res.append((a,b))
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N and visited[nx][ny] == 0:
                # 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 공유하는 국경선 open
                if L<=abs(graph[nx][ny]-graph[x][y])<=R:
                    visited[nx][ny] = 1
                    queue.append((nx,ny))
                    res.append((nx,ny))
    return res
            
result = 0
while 1:
    visited = [[0] * (N+1) for _ in range(N+1)]
    flag = 0
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                visited[i][j] = 1
                move = bfs(i,j)
                # 국경선이 오픈되어있다면 인구 이동 시작
                if len(move) > 1:
                    flag = 1
                    # 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
                    number = sum([graph[x][y] for x, y in move]) // len(move)
                    for x,y in move:
                        graph[x][y] = number
   #국경선 close
    if flag == 0:
        break
    result += 1
print(result)