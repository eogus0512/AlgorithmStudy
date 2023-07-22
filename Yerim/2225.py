# 시간 초과 code
# from itertools import product
# n,k=map(int,input().split())
# arr=[i for i in range(0,n+1)]
# data=set(product(arr, repeat = k))
# cnt=0
# for i in data:
#     if sum(list(i))==n:
#         cnt+=1
# print(cnt%1000000000)



n,k=map(int,input().split())
if k==1:
    print(1)
else:
    dp=[[0]*(k+1) for i in range(n+1)]
    dp[0][0]=1
    for i in range(0,n+1):
        for j in range(1,k+1):
            dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000
    print(dp[n][k])