import sys
input = sys.stdin.readline
n = int(input())
grid = []
for _ in range(n):
    grid.append(list(map(int, input().split())))
    
dp = [[[0] * 4 for _ in range(n)] for _ in range(n)]
dp[0][1][0] = 1
dp[0][1][1] = 1

#dp[i][j][k] -> grid[i][j]에 도달할 수 있는 경우의 수 (k = 0(총합), k = 1(왼쪽), k = 2(위쪽), k = 3(대각))

# 1행 채우기
for i in range(2, n):
    if grid[0][i] == 1: #벽이 있는 경우 멈춤
        break
    dp[0][i][0] = dp[0][i-1][0]
    dp[0][i][1] = dp[0][i-1][0]
    
for i in range(1, n):
    for j in range(1, n):
        if grid[i][j] == 1: # 해당 칸이 벽인 경우 스킵
            continue
        if grid[i-1][j] == 1 and grid[i][j-1] == 1: # 위, 옆이 모두 벽인 경우 스킵
            continue
        if grid[i-1][j] == 1: # 위만 벽인 경우 -> 왼쪽에서 이동해서 들어오는 경우만 고려하면 됨
            dp[i][j][1] += dp[i][j-1][3] + dp[i][j-1][1] #왼쪽 파이프 모양이 대각, - 만 가능
            dp[i][j][0] += dp[i][j][1]
        elif grid[i][j-1] == 1: #왼쪽이 벽인 경우 -> 위쪽으로 이동해서 들어오는 경우만 고려하면 됨
            dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][3] #위쪽 파이프 모양이 ㅣ, 대각
            dp[i][j][0] += dp[i][j][2]
        elif grid[i-1][j-1] == 1: # 대각이 벽인 경우 - ㅣ 만 가능
            dp[i][j][2] = dp[i-1][j][2]
            dp[i][j][1] = dp[i][j-1][1]
            dp[i][j][0] = dp[i][j][1] + dp[i][j][2]
        else: # 벽이 없는 경우 -> - ㅣ 대각 다 가능
            dp[i][j][1] = dp[i][j-1][3] + dp[i][j-1][1]
            dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][3]
            dp[i][j][3] = dp[i-1][j-1][0]
            dp[i][j][0] = dp[i][j][1] + dp[i][j][2] + dp[i][j][3]

print(dp[n-1][n-1][0])