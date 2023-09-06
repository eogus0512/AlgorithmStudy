def solution(plans):
    for plan in plans:
        hour, minute = map(int, plan[1].split(':'))
        plan[1] = hour * 60 + minute
        plan[2] = int(plan[2])

    plans.sort(key=lambda x: x[1])
    stopped_plans = []
    answer = []

    for i in range(len(plans)):
        if i == len(plans)-1:
            stopped_plans.append(i)
            break

        if plans[i][1] + plans[i][2] > plans[i + 1][1]:
            temp = plans[i + 1][1] - plans[i][1]
            plans[i][2] -= temp
            stopped_plans.append(i)
        else:
            answer.append(plans[i][0])
            dif_time = plans[i + 1][1] - (plans[i][1] + plans[i][2])

            while dif_time != 0 and stopped_plans:
                if plans[stopped_plans[-1]][2] <= dif_time:
                    answer.append(plans[stopped_plans[-1]][0])
                    dif_time -= plans[stopped_plans[-1]][2]
                    stopped_plans.pop()
                else:
                    plans[stopped_plans[-1]][2] -= dif_time
                    dif_time = 0
    while stopped_plans:
        answer.append(plans[stopped_plans.pop()][0])
    return answer
