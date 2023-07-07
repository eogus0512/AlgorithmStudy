#N개의 수 중에서 어떤 수가 다른 수 두개의 합으로 나타낼 수 있다면 그 수를 "좋다"고 한다
# 처음에 set() 사용해서 개수를 출력 -> "시간 초과" 발생

import sys
input=sys.stdin.readline
n = int(input()) # 데이터의 개수 N
data=list(map(int,input().split()))
data.sort()
count=0

for i in range(n):
    # 자신을 포함시키면 x 
    tmp=data[:i]+data[i+1:] #슬라이스하지 않고 하려면 start,end값을 일일히 비교하는 방법도 있을텐데 뭐가 더 나은지 추후 비교해보기
    start=0
    end=len(tmp)-1 
    target=data[start+1:]  
    while start<end: 
        res=tmp[start]+tmp[end]
        if res==data[i]:
            count+=1
            break
        elif res>data[i]:
            end-=1
        elif res<data[i]:
            start+=1

print(count)