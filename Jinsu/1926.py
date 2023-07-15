import sys
input = sys.stdin.readline
from collections import deque
n, m = map(int, input().split())
graph = []
INF = int(1e9)
dist = [[INF] * m for _ in range(n)]
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
pic_num = 0
pic_area = []

#그림 개수와 그림 넓이 최대 구하기

def bfs(y, x, area):
    q = deque()
    q.append((y, x))
    dist[y][x] = 0
    
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if graph[ny][nx] == 1 and dist[ny][nx] == INF:
                # 그림 넓이 +1
                area += 1
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))
    # 그림 넓이 리스트에 추가
    pic_area.append(area)
    
for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and dist[i][j] == INF:
            # 그림 개수 +1
            pic_num += 1
            bfs(i, j, 1)
print(pic_num)
if pic_num == 0: # 그림 개수가 0인 경우 넓이 배열은 []
    print(0)
else:
    print(sorted(pic_area)[-1])