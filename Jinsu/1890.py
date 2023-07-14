import sys
input = sys.stdin.readline
n = int(input())
board = []
#dp[i][j] = board[i][j]에 도달할 수 있는 경우의 수
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1 
for _ in range(n):
    board.append(list(map(int, input().split())))

# 맨 위쪽 칸과, 왼쪽 끝칸의 도달 경우의 수를 먼저 계산함.
for i in range(1, n):
    for j in range(0, i):
        # 현재 위치 board[0][i]에 올 수 있는 경우의 수를 계산 (board[0][0~i-1]까지의 값들을 확인해서 현재 위치로 점프할 수 있는지 확인)
        if board[0][j] == i-j:
            dp[0][i] += dp[0][j]
        # 현재 위치 board[i][0]에 올 수 있는 경우의 수를 계산 (마찬가지)
        if board[j][0] == i-j:
            dp[i][0] += dp[j][0]
    
# 나머지 칸들 계산
for i in range(1, n):
    for j in range(1, n):
        for k in range(0, i): # 윗칸들에서 현재 위치로 점프할 수 있는 경우를 더해줌
            if board[k][j] == i-k:
                dp[i][j] += dp[k][j]
        for k in range(0, j): # 왼쪽칸에서 현재 위치로 점프할 수 있는 경우을 더해줌
            if board[i][k] == j-k:
                dp[i][j] += dp[i][k]

print(dp[n-1][n-1])
