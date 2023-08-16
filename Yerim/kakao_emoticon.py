from itertools import product
def solution(users, emoticons):
    discount = [10,20,30,40] #할인율 리스트 
    discount_list = list(product(discount, repeat=len(emoticons)))
    res=[0,0] 
    for dis in discount_list:
        plus_user= 0 #플러스 가입 유저 
        cost = 0  # 이모티콘 금액 
        for i in range(len(users)): 
            user_s=users[i][0]
            ans= 0 #합계
            for j in range(len(dis)):
                if user_s<=dis[j]:
                    ans+=emoticons[j]-(emoticons[j]*(dis[j]/100)) #할인율 계산 
            if ans>=users[i][1]:
                plus_user+=1
            else:
                cost+=ans
        if res[0]<plus_user:
            res[0]=plus_user
            res[1]=cost
        if res[0]==plus_user:
            res[1]=max(res[1], cost)
    return res


