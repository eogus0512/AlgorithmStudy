from collections import deque
n,m = map(int, input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

#4방향 탐색
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y):
    area = 1 
    queue = deque()
    queue.append([x, y])  
    while queue:
        x,y = queue.pop()
        for i in range(4):
            nx= x+dx[i]
            ny= y+dy[i]
            if 0<=nx<n and 0<=ny<m: #범위 내 존재
                if arr[nx][ny] == 1 and not visited[nx][ny]: # 1이면서 방문하지 않은 곳 
                    area += 1 # 넓이 1 증가
                    visited[nx][ny] = 1 # 방문 처리 
                    queue.append((nx,ny)) 
    return area

cnt= 0
res=0
visited = [[0]*m for _ in range(n)] # 방문 처리를 위한 리스트
for i in range(n):
    for j in range(m):
        if arr[i][j]==1 and not visited[i][j]:
            cnt += 1 
            visited[i][j] = 1
            res = max(res, bfs(i,j))
print(cnt)
print(res)
