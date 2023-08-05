# 치킨 배달 , 치킨 거리가 가장 작도록 , 조합
# 1 : 집 , 2 : 치킨 집 

from itertools import combinations

n,m=map(int,input().split()) 
city=[list(map(int, input().split())) for _ in range(n)] #정보
chicken=[] #치킨집
home=[] #도시

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            home.append((i,j)) # 집 위치 
        if city[i][j] == 2:
            chicken.append((i,j)) # 치킨집 위치

#치킨집 m개 선택을 위한 경우의 수 -> 조합 사용
chicken_list=list(combinations(chicken,m))
 
res=int(1e9)
for check in chicken_list: 
    home_s =0 #집에서 치킨거리 합 
    for j in range(len(home)):
        dist =int(1e9) # 큰 수로 선언하여 비교 , 2*n 정도로 해도 될 듯?
        for x,y in check:
            dist = min(dist,abs(x-home[j][0])+abs(y-home[j][1]))
        home_s+=dist
    res = min(res,home_s)

print(res)