K = int(input())
students = [list(map(int, input().split())) for _ in range(K*K)]

seat = [[0] * (K+1) for _ in range(K+1)]
dx=[0, 0, 1, -1]
dy=[1, -1, 0, 0]
like = 0
empty = 0

for s in students:
    student = s[0]
    friends = set(s[1:])
    result = []
    for i in range(1, K+1):
        for j in range(1, K+1):
            if (seat[i][j] == 0):
                like = 0
                empty = 0

                for k in range(4):
                    nx = i+dx[k]
                    ny = j+dy[k]

                    if (1 <= nx <= K and 1 <= ny <= K):
                        if (seat[nx][ny] in friends):
                            like+=1
                        if (seat[nx][ny] == 0):
                            empty+=1
                result.append((like, empty, i, j))
    result = sorted(result, key=lambda x: (-x[0], -x[1], x[2], x[3]))
    seat[result[0][2]][result[0][3]] = student

score = 0
students.sort()

for i in range(1, K+1):
    for j in range(1, K+1):
        student = seat[i][j]
        count = 0
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if (1 <= nx <= K and 1 <= ny <= K):
                if seat[nx][ny] in students[seat[i][j] - 1]:
                    count += 1
        if count > 0:
            score += 10 ** (count-1)

print(score)


