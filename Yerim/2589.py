from collections import deque
import sys
input = sys.stdin.readline
r, c = map(int, input().strip().split())
graph = [list(input()) for _ in range(c)]

# 4방향 탐색
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(x,y):
  queue=deque() 
  queue.append((x,y)) # 시작점 i,j를 queue에 넣어준다.
  visited = [[0]*c for _ in range(r)] # 방문처리 리스트 생성
  visited[x][y] = 1 # 처음 방문하는 좌표 방문처리
  cnt = 0

  while queue:
    a,b = queue.popleft() # 시작점부터 탐색
    for i in range(4): # 4방향으로 탐색
      nx = a + dx[i]
      ny = b + dy[i]
      
      # 범위 초과시 무시
      if nx < 0 or nx >= r or ny < 0 or ny >= c:
        continue
      # 길(L)이면서 방문하지 않은 곳
      elif graph[nx][ny] == 'L' and visited[nx][ny] == 0:
        visited[nx][ny] = visited[x][y] + 1 # 현재 위치(nx, ny) = 직전 위치 + 1
        cnt = max(cnt, visited[nx][ny]) # 현재 cnt값 vs 위에서 저장한 걸린시간 -> 큰 값 저장
        queue.append((nx, ny)) # nx,ny부터 4방향 탐색을 하기 위해 삽입
  return cnt-1

result = 0
for x in range(r):
  for y in range(c):
    if graph[x][y] == 'L':
      result = max(result, bfs(x,y))

print(result)
