import sys
input = sys.stdin.readline
from collections import deque
n, l, r = map(int, input().split())
land = []
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
INF = int(1e9)
res = 0

# 인구 이동 횟수를 구하는 문제임

def move(n, l, r): # 이동할 수 있는 영역이 있는지 확인
    flag = False
    for i in range(n-1):
        for j in range(n-1):
            diffR = abs(land[i][j] - land[i][j+1])
            diffD = abs(land[i][j] - land[i+1][j])
            if l <= diffR <= r or l <= diffD <= r:
                return True
    for i in range(n-1): # 마지막 행 체크
        if l <= abs(land[n-1][i] - land[n-1][i+1]) <= r:
            return True
    return False

def bfs(y, x, l, r, n):
    dist[y][x] = 0
    total = land[y][x] # 인구 총합
    nation_cnt = 1 # 국가 수
    nation = deque() # 국가 위치 (마지막에 평균값으로 값 바꿀 때 사용)
    nation.append((y, x))
    q = deque()
    q.append((y, x))
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if dist[ny][nx] == INF and l <= abs(land[ny][nx] - land[y][x]) <= r:
                nation_cnt += 1
                total += land[ny][nx]
                nation.append((ny, nx))
                q.append((ny, nx))
                dist[ny][nx] = dist[y][x] + 1
    
    average_cnt = total // nation_cnt # 평균 인구수
    while nation: 
        y, x = nation.popleft()
        land[y][x] = average_cnt # 국경선 열린 국가들의 인구값 변경
            
for _ in range(n):
    land.append(list(map(int, input().split())))

while move(n, l, r):
    dist = [[INF] * n for _ in range(n)]
    res += 1 # 인구이동 횟수 +1

    for i in range(n):
        for j in range(n):
            if dist[i][j] == INF:
                bfs(i, j, l, r, n)
    
print(res)