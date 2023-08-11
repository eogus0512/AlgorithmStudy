# 택배 수거
def solution(cap, n, deliveries, pickups):
    res = 0

    delivery = 0
    pickup = 0

    for i in range(n - 1, -1, -1):
        delivery += deliveries[i]
        pickup += pickups[i]

        # 음수 -> 이미 처리된 값
        while delivery > 0 or pickup > 0:
            delivery -= cap
            pickup -= cap
            res += (i + 1) * 2

    return res