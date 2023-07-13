import sys
input = sys.stdin.readline
n, k = map(int, input().split())
value = [] # 동전 종류
for _ in range(n):
    value.append(int(input()))

# dp[n] = n을 만들 수 있는 경우의 수
dp = [0] * (k+1) 
dp[0] = 1 # value 에 있는 값은 기본적으로 만들 수 있음으로 1
for v in value: # 동전 종류를 하나씩 추가하면서 dp[n]에 누적시킴
    for i in range(k+1):
        if i-v >= 0: # 현재 값에 동전 가치만큼 뺀 금액이 0보다 크거나 같으면 더해줌 (i-v == 0 인 경우는 동전 v 하나로 만드는 경우)
            dp[i] += dp[i-v]
            
print(dp[k])
