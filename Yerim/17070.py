import sys
input  = sys.stdin.readline
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

# 가로(0) 세로(1) 대각선(2)
dp = [[[0] * n for _ in range(n)] for _ in range(3)]

dp[0][0][1] = 1 # 파이프 시작 위치 

for i in range(0, n):
    for j in range(2, n) :
        # 대각선 (대각선은 가로, 세로, 대각선 모두 움직임 가능)
        if graph[i][j] == 0 and graph[i-1][j] == 0 and graph[i][j-1] == 0:
            dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]

        if graph[i][j] == 0 :
            # 가로 (가로는 가로,대각선 방향만 움직임)
            dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1]
            # 세로 (세로는 세로, 대각선 방향만 움직임)
            dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j]

# 가로, 세로, 대각선 dp 합
print(dp[0][n-1][n-1]+dp[1][n-1][n-1]+dp[2][n-1][n-1])
