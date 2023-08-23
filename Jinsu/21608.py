# 상어 초등학교
'''
1. 빈칸중에 인접 like 학생 수가 높은 곳으로
2. 인접칸 중 빈칸이 많은 곳.
3. 행, 열 번호가 작은 순으로 (행 우선)
'''

import sys
input = sys.stdin.readline
n = int(input())

grid = [[0] * n for _ in range(n)] # 앉을 자리
like = dict() # 각 학생별 좋아하는 학생
student = [] # 학생 앉을 순으로
dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]
for _ in range(n*n):
    s, a, b, c, d = map(int, input().split())
    student.append(s)
    like[s] = [a, b, c, d]

for i in range(n*n):
    s = student[i] # 현재 앉을 학생
    like_max = -1
    blank_max = -1
    next_pos = [0, 0] # 앉을 위치
    for a in range(n):
        for b in range(n):
            if grid[a][b] == 0:
                like_cnt = 0
                blank_cnt = 0
                for k in range(4):
                    ny = a + dy[k]
                    nx = b + dx[k]
                    if ny < 0 or ny >= n or nx < 0 or nx >= n:
                        continue
                    if grid[ny][nx] in like[s]:
                        like_cnt += 1
                    elif grid[ny][nx] == 0:
                        blank_cnt += 1
                if like_cnt > like_max:
                    next_pos[0], next_pos[1] = a, b
                    like_max = like_cnt
                    blank_max = blank_cnt
                elif like_cnt == like_max:
                    if blank_cnt > blank_max:
                        next_pos[0], next_pos[1] = a, b
                        blank_max = blank_cnt

    grid[next_pos[0]][next_pos[1]] = s # 학생 앉히기

score = [0, 1, 10, 100, 1000]
res = 0

for i in range(n):
    for j in range(n):
        s = grid[i][j]
        count = 0 # 좋아하는 학생 수
        for k in range(4):
            ny = i + dy[k]
            nx = j + dx[k]
            if ny < 0 or ny >= n or nx < 0 or nx >= n:
                continue
            if grid[ny][nx] in like[s]:
                count += 1
        res += score[count]

print(res)



