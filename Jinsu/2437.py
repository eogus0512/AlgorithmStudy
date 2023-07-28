# 2437 저울

import sys
input = sys.stdin.readline
n = int(input())
w = list(map(int, input().split()))
w.sort()
# 측정할 수 있는 길이+1(측정 불가 무게 min값)
res = 1

# 현재 측정할 수 있는 길이 >= 다음 추의 무게:
#   측정할 수 있는 길이 = 기존 측정 가능 길이 + 현재 추 무게
for cur in w:
    if res < cur:
        break
    res += cur
print(res)
