# 1926 그림
import sys
input = sys.stdin.readline
from collections import deque
n, m = map(int, input().split())
grid = []
INF = int(1e9)
dist = [[INF] * m for _ in range(n)]
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
count = 0 #그림 개수
res = [] #그림 넓이

def bfs(y, x):
    global count
    q = deque()
    q.append((y, x))
    dist[y][x] = 0
    total = 1
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if dist[ny][nx] == INF and grid[ny][nx] == 1:
                total += 1
                dist[ny][nx] = dist[y][x]+1
                q.append((ny, nx))
    return total

for _ in range(n):
    grid.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if dist[i][j] == INF and grid[i][j] == 1:
            count += 1
            res.append(bfs(i, j))

print(count)
if count == 0:
    print(0)
else:
    print(max(res))
