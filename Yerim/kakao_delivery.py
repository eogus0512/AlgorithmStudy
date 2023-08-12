#택배 배달과 수거하기
#멀리 있는 집부터 다녀오면 될 듯?

#cap : 상자 최대 개수, n: 배달 집 
def solution(cap, n, deliveries, pickups):
    deliveries=deliveries[::-1]
    pickups=pickups[::-1]
    answer=0
    delivery,pickup=0,0


    for i in range(n):
        delivery+=deliveries[i]
        pickup+=pickups[i]

        while delivery>0 or pickup>0:
            delivery-=cap
            pickup-=cap
            answer+=(n-i)*2 #가장 먼 집부터 조회, 왕복

    return answer
