N = int(input())

array = []
visit = []
for _ in range(N):
    row = [int(num) for num in input().split()]
    array.append(row)

visit = [[0] * N for _ in range(N)] # 방문 횟수 배열
visit[0][0] = 1

for i in range(N):
    for j in range(N):
        if i == N-1 and j == N-1: # 마지막 인덱스면 더이상 진행하지 않고 break
            print(visit[i][j])
            break
        if visit[i][j] != 0: # 한번도 방문하지 않았으면 패스
            if i+array[i][j] < N:
                visit[i+array[i][j]][j] += visit[i][j]
            if j+array[i][j] < N:
                visit[i][j+array[i][j]] += visit[i][j]
