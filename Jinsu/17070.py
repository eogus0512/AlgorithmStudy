#파이프 옮기기
import sys
input = sys.stdin.readline

n = int(input())
grid = []
dp = [[[0]*3 for _ in range(n)] for _ in range(n)]
dp[0][1][0] = 1
for _ in range(n):
    grid.append(list(map(int, input().split())))

for i in range(2, n):
    if grid[0][i] == 1:
        break
    dp[0][i][0] = 1

# dp[n][m][k] = grid[n][m]까지 오는 경우의 수
# (현재 위치에 파이프 꽂히는 모양, 0<=k<=2, k==0 -> 왼, k==1 -> 위, k==2 -> 대각)
for i in range(1, n):
    for j in range(1, n):
        if grid[i][j] == 1: # 현재 위치 벽
            continue
        if grid[i-1][j] == 1 and grid[i][j-1] == 1: # 위, 왼쪽 벽
            continue
        if grid[i-1][j] == 1 and grid[i-1][j-1] == 1: # 위, 대각 벽
            dp[i][j][0] = dp[i][j-1][0]
        elif grid[i-1][j-1] == 1 and grid[i][j-1] == 1: # 왼, 대각 벽
            dp[i][j][1] = dp[i-1][j][1]
        elif grid[i-1][j] == 1: # 위만 벽
            dp[i][j][0] = dp[i][j-1][2] + dp[i][j-1][0]
        elif grid[i][j-1] == 1: # 왼쪽만 벽
            dp[i][j][1] = sum(dp[i-1][j])
            dp[i][j][1] = dp[i-1][j][2] + dp[i-1][j][1]
        else: #벽이 없는 경우
            dp[i][j][0] = dp[i][j-1][2] + dp[i][j-1][0]
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]
            dp[i][j][2] = sum(dp[i-1][j-1])

print(sum(dp[n-1][n-1]))