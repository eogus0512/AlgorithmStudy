n, k = map(int, input().split())

dp = []
dp = [0 for _ in range(k+1)] # dp 배열 생성
dp[0] = 1

for i in range(n):
    coin = int(input()) # coin 입력받음
    for j in range(coin, k+1): # coin 인덱스부터
        dp[j] = dp[j] + dp[j-coin] # coin 이전 인덱스 요소만큼 더해줌
print(dp[k])