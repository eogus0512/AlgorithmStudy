# 상어 초등학교
N = int(input())
#학생,선호도 리스트
students = [list(map(int, input().split())) for _ in range(N**2)]
sit = [[0] * N for _ in range(N)] # 빈 좌석 
dr=[-1, 1, 0, 0]
dc =[0, 0, -1, 1]

def count(r, c, st_num):
    like, blank = 0, 0
    for k in range(4): # 상하좌우로 탐색 
        nr= r + dr[k]
        nc =c + dc[k]
        if 0 <= nr < N and 0 <= nc < N: # 범위 내 있는지 check
            if sit[nr][nc] in st_num[1:]: # 선호도에 포함되면 
                like += 1 # like  증가 
            if sit[nr][nc] == 0: # 빈 자리면 
                blank += 1 # blank 증가 
    return like, blank

for st_num in students:
    max_like, max_blank, seat_r, seat_c = -1, -1, -1, -1

    for r in range(N):
        for c in range(N):
            if sit[r][c] == 0: # 자리가 비어있으면 
                like, blank = count(r, c, st_num)
                if like >= max_like and blank > max_blank:
                    max_like, max_blank, seat_r, seat_c = like, blank, r, c
    # 최적의 자리에 자리 할당 
    sit[seat_r][seat_c] = st_num[0]

score = 0
students.sort()

# 점수 계산 
for r in range(N):
    for c in range(N):
        like = 0
        for k in range(4):
            nr= r + dr[k]
            nc =c + dc[k]
            if 0 <= nr < N and 0 <= nc < N: # 범위 내 있는지 체크 
                if sit[nr][nc] in students[sit[r][c] - 1]: # 상하좌우에 있는 학생이 선호도 목록에 포함이면
                    like += 1

        if like != 0:
            score += 10 ** (like - 1)

print(score)






