# 사탕 게임 , n*n , 브르투포스? , 
# 사탕의 색이 다른 인접한 두 칸 선탤 후 교환, 같은 색으로 이루어져있는 연속된 부분의 최대 개수
#행,열 구분해서 조회? 

import sys
input=sys.stdin.readline
n=int(input())
candy=[list(input()) for _ in range(n)]
res=0

def check(arr):
    n=len(arr)
    answer=1

    for i in range(n):
        cnt=1
        for j in range(1, n):
            if arr[i][j] == arr[i][j-1]:
                cnt += 1
            else:
                cnt=1
            # cnt, answer 비교해서 큰 값 저장 
            answer=max(answer,cnt)
        cnt=1
        for j in range(1, n):
            if arr[j][i] == arr[j-1][i]:
                cnt += 1
            else:
                cnt=1
            answer=max(answer,cnt)
    return answer



for i in range(n):
    for j in range(n-1):
        #사탕의 색이 다른 인접한 칸 조회 (열,행) , 위-아래는 검사 안해도됨
        if candy[i][j]!= candy[i][j+1]:
        	# 인점한 것과 change
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]
            temp=check(candy)
            res=max(temp,res)
            #  다시 원래대로 
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]

        if candy[j][i] != candy[j][i+1]:
            candy[j][i], candy[j+1][i] = candy[j+1][i], candy[j][i]
            temp=check(candy)
            res=max(temp,res)
            # 다시 원래대로
            candy[j][i], candy[j+1][i] = candy[j+1][i], candy[j][i]
            
print(res)