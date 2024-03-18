def solution(targets):
    answer = 0
    sorted_targets = sorted(targets, key=lambda x: x[0])
    print(sorted_targets)
    na = -1
    nb = -1
    for _, (a, b) in enumerate(sorted_targets):
        if a < nb:
            continue
        answer += 1
        nb = b

    return answer

targets = [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
print(solution(targets))