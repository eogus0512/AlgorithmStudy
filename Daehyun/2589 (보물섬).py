from collections import deque
import sys
input = sys.stdin.readline

n, m=map(int, input().strip().split())
map = [list(input().rstrip()) for _ in range(n)]

dx=[0, 0, 1, -1]
dy=[1, -1, 0, 0]

def bfs(i, j):
    queue=deque()
    queue.append((i,j))
    visited=[[0]*m for _ in range(n)]
    visited[i][j]=1
    cnt=0

    while queue:
        x, y=queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx>=0 and nx < n and ny >= 0 and ny < m:
                if map[nx][ny]=='L' and visited[nx][ny]==0:
                    visited[nx][ny]=visited[x][y]+1
                    cnt=max(cnt, visited[nx][ny])
                    queue.append((nx, ny))
    return cnt-1

result=0

for i in range(n):
  for j in range(m):
    if map[i][j]=='L':
      result = max(result, bfs(i,j))

print(result)