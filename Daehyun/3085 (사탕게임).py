import sys
input = sys.stdin.readline

def count(data):
    M = 1
    for i in range(N):
        cnt = 1
        for j in range(1, N):
            if data[i][j] == data[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            M = max(M, cnt)
        cnt = 1
        for j in range(1, N):
            if  data[j][i] == data[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            M = max(M,cnt)
    return M

N = int(input())
color = [list(input()) for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(N):
        if j+1 < N:
            color[i][j], color[i][j + 1] = color[i][j + 1], color[i][j]
            temp=count(color)
            cnt = max(cnt, temp)
            color[i][j], color[i][j + 1] = color[i][j + 1], color[i][j]
        if i+1 < N:
            color[i][j], color[i + 1][j] = color[i + 1][j], color[i][j]
            temp=count(color)
            cnt = max(cnt, temp)
            color[i][j], color[i + 1][j] = color[i + 1][j], color[i][j]
print(cnt)