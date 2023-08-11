# 이모티콘
def solution(users, emoticons):
    l = len(emoticons)
    rate = [0] * l  # 할인율
    res = [0, 0]

    # 이모티콘 setting
    def dfs(depth, l):
        if depth == l:
            s_count = 0  # 서비스 가입자 수
            u_total = 0  # 판매액 총합
            for i in range(len(users)):
                total = 0  # 현재 회원의 구매액
                flag = False
                for j in range(l):
                    if rate[j] >= users[i][0]:
                        total += emoticons[j]
                        if total >= users[i][1]:
                            s_count += 1
                            flag = True
                            break
                if flag == True:  # 서비스 가입
                    continue
                else:
                    u_total += total
            if s_count > res[0]:
                res[0], res[1] = s_count, u_total
            elif s_count == res[0]:
                if res[1] < u_total:
                    res[1] = u_total
            return
        else:
            for i in range(1, 5):
                cur = emoticons[depth]
                curRate = rate[depth]
                rate[depth] = i * 10
                emoticons[depth] -= emoticons[depth] * i * 0.1
                dfs(depth + 1, l)
                rate[depth] = curRate
                emoticons[depth] = cur

    dfs(0, l)
    return res