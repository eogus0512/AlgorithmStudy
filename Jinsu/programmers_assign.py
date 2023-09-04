def solution(plans):
    tp = [] # plans 의 start를 분으로 변환한 값
    res = []
    ing = [] #이름과 남은시간

    # 시간 변환
    for plan in plans:
        temp = plan[1].split(':')
        s = int(temp[0]) * 60 + int(temp[1])
        tp.append([plan[0], s, int(plan[2])])

    #시작 시간 순으로 정렬
    tp.sort(key = lambda x : x[1])


    for i in range(len(tp)-1):
        sub, start, period = tp[i]

        # 시간안에 못 끝낸 케이스
        if start + period > tp[i+1][1]:
            ing.append((sub, start + period - tp[i+1][1]))
        # 딱 맞춰서 끝낸 케이스
        elif start + period == tp[i+1][1]:
            res.append(sub)
        # 시간 남아서 진행중이 과제 처리
        else:
            res.append(sub)
            remain = tp[i+1][1] - (start + period) # 남은 시간
            while remain > 0 and ing:
                ingSub, ingPeriod = ing.pop()
                if ingPeriod <= remain:
                    remain -= ingPeriod
                    res.append(ingSub)
                else:
                    ing.append([ingSub, ingPeriod-remain])
                    break

    # 마지막 과제 처리
    res.append(tp[-1][0])

    # 남은 진행중인 과제 처리
    while ing:
        x = ing.pop()
        res.append(x[0])

    return res