import sys
input = sys.stdin.readline
from collections import deque
n, m = map(int, input().split())
grid = []
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
res = 0
INF = int(1e9)

# 땅 사이의 최대 거리를 구하는 문제

def bfs(y, x, n, m):
    dist = [[INF] * m for _ in range(n)]
    q = deque()
    q.append((y, x))
    dist[y][x] = 0
    global res
    
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if dist[ny][nx] == INF and grid[ny][nx] == 'L':
                dist[ny][nx] = dist[y][x] + 1
                res = max(res, dist[ny][nx])
                q.append((ny, nx))
                
    
for _ in range(n):
    grid.append(list(input().rstrip('\n')))
    


for i in range(n):
    for j in range(m):
        if grid[i][j] == 'L':
            if 0 < j < m-1: # 양 옆에 땅이 존재하는 경우는 최대 거리가 될 수 없음.
                if grid[i][j-1] == 'L' and grid[i][j+1] == 'L':
                    continue
            if 0 < i < n-1: # 위 아래 땅이 존재하는 경우는 최대 거리가 될 수 없음.
                if grid[i-1][j] == 'L' and grid[i+1][j] == 'L':
                    continue
            bfs(i, j, n, m)
                
print(res)