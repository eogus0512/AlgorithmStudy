#점프 문제
#오른쪽 or 아래로 이동할 수 있다면 이동, 이전 좌표까지 더함
import sys
input = sys.stdin.readline
n = int(input())
game = [list(map(int,input().split())) for _ in range(n)]
dp =[[0]*n for _ in range(n)] # dp 리스트 n*n 크기로 초기화
dp[0][0] = 1  # 시작은 1로 초기화

#경우의 수 탐색
for i in range(n):
    for j in range(n):
        if i == n-1 and j == n-1: 
            print(dp[i][j])
            break
        if j + game[i][j] < n: # 오른쪽으로 이동 가능, (칸에 적힌 수만큼)
            dp[i][j + game[i][j]] += dp[i][j]

        if i + game[i][j] < n: # 아래로 이동 가능 
            dp[i + game[i][j]][j] += dp[i][j]