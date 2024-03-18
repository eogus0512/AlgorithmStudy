def solution(want, number, discount):
    answer = 0
    num = sum(number)
    dis_num = len(discount)

    for i in range(dis_num - num + 1):
        want_number = dict(zip(want, number))
        isPos = True
        for j in range(i, i + num):
            if discount[j] in want_number and want_number[discount[j]] > 0:
                want_number[discount[j]] -= 1
            else:
                isPos = False
                break
        if isPos:
            answer += 1

    return answer
