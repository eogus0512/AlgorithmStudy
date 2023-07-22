from collections import deque

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
def bfs(graph, x, y):
    queue = deque()
    queue.append([x, y])
    graph[x][y] = 0
    count = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < m and graph[nx][ny] == 1:
                queue.append([nx, ny])
                graph[nx][ny] = 0
                count += 1

    return count

draw = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            draw.append(bfs(graph, i, j))

if len(draw) == 0:
    print(0)
    print(0)
else:
    print(len(draw))
    print(max(draw))
