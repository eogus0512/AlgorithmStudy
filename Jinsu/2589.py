#보물섬
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
grid = []
INF = int(1e9)
res = 0
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
q = deque()

def bfs(y, x):
    dist = [[INF] * m for _ in range(n)]
    dist[y][x] = 0
    qu = deque()
    qu.append((y, x))
    max_dist = 0
    while qu:
        y, x = qu.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if grid[ny][nx] == 'L' and dist[ny][nx] == INF:
                dist[ny][nx] = dist[y][x]+1
                max_dist = max(max_dist, dist[ny][nx])
                qu.append((ny,nx))
    return max_dist

for _ in range(n):
    grid.append(list(input().rstrip('\n')))
for i in range(n): # 양옆이 땅인 경우는 패스
    for j in range(m):
        if grid[i][j] == 'W':
            continue
        if 0 < i < n-1:
            if grid[i-1][j] == grid[i+1][j] == 'L':
                continue
        if 0 < j < m-1:
            if grid[i][j-1] == grid[i][j+1] == 'L':
                continue
        q.append((i, j))

while q:
    y, x = q.popleft()
    res = max(res, bfs(y, x))
print(res)