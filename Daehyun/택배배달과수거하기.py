def solution(cap, n, deliveries, pickups):
    deliveries = list(reversed(deliveries))
    pickups = list(reversed(pickups))
    answer = 0
    delivery = 0
    pickup = 0

    for i in range(n):
        delivery += deliveries[i]
        pickup += pickups[i]
        while delivery > 0 or pickup > 0:
            delivery -= cap
            pickup -= cap
            answer += 2 * (n - i)

    return answer