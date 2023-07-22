#인구이동
#국경선 열리는지 판단(canMove) -> 열리면 인구 갱신(Move)
import sys
from collections import deque
input = sys.stdin.readline
n, l, r = map(int, input().split())
grid = []
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
INF = int(1e9)
q = deque()
res = 0

def check():
    for i in range(n):
        for j in range(n):
            flag = False
            if i != n-1:
                if l <= abs(grid[i][j]-grid[i+1][j]) <= r:
                    flag = True
            if j != n-1:
                if l <= abs(grid[i][j+1]-grid[i][j]) <= r:
                    flag = True
            if flag == True:
                q.append((i, j))
    if not q:
        return False
    return True

def bfs(y, x, dist):
    country_cnt = 1 # 국가 수
    country = [] # 국가
    country.append((y, x))
    p_cnt = grid[y][x] # 총 인구
    dist[y][x] = 0

    qu = deque()
    qu.append((y, x))
    while qu:
        y, x = qu.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if dist[ny][nx] == INF and l <= abs(grid[ny][nx]-grid[y][x]) <= r:
                dist[ny][nx] = dist[y][x]+1
                country.append((ny, nx))
                country_cnt += 1
                p_cnt += grid[ny][nx]
                qu.append((ny, nx))

    avg_cnt = p_cnt // country_cnt # 평균 인구
    while country: # 인구 갱신
        y, x = country.pop()
        grid[y][x] = avg_cnt

for _ in range(n):
    grid.append(list(map(int, input().split())))

while check():
    dist = [[INF] * n for _ in range(n)]
    res += 1
    while q:
        y, x = q.popleft()
        if dist[y][x] == INF:
            bfs(y, x, dist)
print(res)