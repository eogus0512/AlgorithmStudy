import sys
input = sys.stdin.readline
n, k = map(int, input().split())
dp = [[0] * (n+1) for _ in range(k+1)]

'''
dp[i][j] = j를 1~j까지의 정수 i개의 합으로 나타낼 수 있는 경우의 수
n과 k의 관계를 정리하면
-> dp[1][j] = j값에 상관없이 1
-> dp[i][1] = i
-> dp[i][j] = dp[i-1][j] + dp[i][j-1] 로 정리됨
'''
for i in range(1, n+1):
    dp[1][i] = 1
for i in range(1, k+1):
    dp[i][1] = i

for i in range(2, k+1):
    for j in range(2, n+1):
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000
print(dp[k][n])
