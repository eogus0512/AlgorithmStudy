#적록색약

import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
grid = []
for _ in range(n):
    grid.append(list(input().rstrip()))

visit1 = [[False] * n for _ in range(n)]
visit2 = [[False] * n for _ in range(n)]
def bfs1(y, x): # 적록
    q = deque()
    q.append((y, x))
    visit1[y][x] = True
    if grid[y][x] == 'G' or grid[y][x] == 'R':
        cur = 1
    else:
        cur = 0

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if visit1[ny][nx] == True:
                continue
            if cur == 1:
                if grid[ny][nx] == 'G' or grid[ny][nx] == 'R':
                    visit1[ny][nx] = True
                    q.append((ny, nx))
            else:
                if grid[ny][nx] == 'B':
                    visit1[ny][nx] = True
                    q.append((ny, nx))

def bfs2(y, x): # 일반
    q = deque()
    q.append((y, x))
    visit2[y][x] = True
    cur = grid[y][x]
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if visit2[ny][nx] == True:
                continue
            if grid[ny][nx] == cur:
                visit2[ny][nx] = True
                q.append((ny, nx))

cnt1 = 0
cnt2 = 0

for i in range(n):
    for j in range(n):
        if visit1[i][j] == False:
            cnt1 += 1
            bfs1(i, j)
        if visit2[i][j] == False:
            cnt2 += 1
            bfs2(i, j)

print(cnt2, cnt1)