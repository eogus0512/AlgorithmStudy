#상어 초등학교
import sys
input = sys.stdin.readline

n = int(input())
student = []
grid = [[-1] * n for _ in range(n)]
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
q = [] # 학생 위치
res = 0

for i in range(n*n):
    student.append(list(map(int, input().split())))


for i in range(n*n):
    cur = [-1, -1] # 이번 학생이 앉을 위치

    # 첫칸부터 확인해야 함, like_cnt, blank_cnt 를 0으로 시작하면 틀림
    like_cnt = -1
    blank_cnt = -1
    for r in range(n):
        for c in range(n):
            if grid[r][c] != -1: # 자리 있음.
                continue
            # 현재 칸 기준 상하좌우, 좋아하는 학생, 빈칸 수
            like = 0
            blank = 0
            for j in range(4):
                ny = r + dy[j]
                nx = c + dx[j]

                if ny < 0 or nx < 0 or ny >= n or nx >= n:
                    continue
                if grid[ny][nx] in student[i][1:]:
                    like += 1
                if grid[ny][nx] == -1:
                    blank += 1

            if like_cnt < like: # 1번 조건 (좋아하는 학생 수)
                like_cnt = like
                blank_cnt = blank
                cur[0], cur[1] = r, c
            elif like_cnt == like:
                if blank > blank_cnt: # 2번 조건 (인접 빈칸 수)
                    blank_cnt = blank
                    cur[0], cur[1] = r, c
            # 3번 조건은 행, 열 순으로 탐색하기 때문에 자동으로 만족

    grid[cur[0]][cur[1]] = student[i][0]
    q.append((cur[0], cur[1], i)) # 배정한 위치(y, x) + 순서

while q:
    # 위치(y, x), 순서(k)
    y, x, k = q.pop()
    count = 0
    for i in range(4): # 현재 위치 기준, 상하좌우 좋아하는 학생 수 count
        ny = y + dy[i]
        nx = x + dx[i]
        if ny < 0 or nx < 0 or ny >= n or nx >= n:
            continue
        if grid[ny][nx] in student[k][1:]:
            count += 1

    # 점수 계산
    if count == 1:
        res += 1
    elif count == 2:
        res += 10
    elif count == 3:
        res += 100
    elif count == 4:
        res += 1000

print(res)


