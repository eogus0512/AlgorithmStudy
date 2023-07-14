#동전
n,k=map(int,input().split())
dp=[0]*(k+1)
dp[0]=1
arr=[int(input()) for _ in range(n)]

for i in range(n):
    for j in range(arr[i],k+1):
        dp[j]+=dp[j-arr[i]]
print(dp[k])
