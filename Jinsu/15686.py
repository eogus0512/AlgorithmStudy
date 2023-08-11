# 15686 치킨 거리
import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

n, m = map(int, input().split())
INF = int(1e9)
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
grid = []
pos = [] # 치킨 위치
res = INF

def bfs():
    total = 0
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if dist[ny][nx] == INF:
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))
                if grid[ny][nx] == 1:
                    total += dist[ny][nx] # 치킨 거리 계산
    return total

for _ in range(n):
    grid.append(list(map(int, input().split())))

for i in range(n):
    for j in range(n):
        if grid[i][j] == 2:
           pos.append((i, j))

for x in combinations(pos, m): #치킨 집 m개 조합
    q = deque()
    dist = [[INF] * n for _ in range(n)]
    for temp in x:
        dist[temp[0]][temp[1]] = 0
        q.append(temp)
    res = min(bfs(), res)
print(res)

