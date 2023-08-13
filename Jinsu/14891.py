import sys
input = sys.stdin.readline
from collections import deque

gear = []
score = [1, 2, 4, 8]
res = 0

for _ in range(4):
    gear.append(deque(map(int, input().rstrip())))

n = int(input())

#회전
for _ in range(n):
    gear_num, dir = map(int, input().split())
    gear_num -= 1 # 0, 1, 2, 3

    rotate = [0] * 4 # 톱니바퀴 회전 방향
    rotate[gear_num] = dir

    # 오른쪽 회전 체크
    for i in range(gear_num+1, 4):
        if gear[i][6] == gear[i-1][2]:
            break
        rotate[i] = rotate[i-1] * - 1 # 이전 톱니랑 반대 방향 회전

    # 왼쪽 회전 체크
    for i in range(gear_num-1, -1, -1):
        if gear[i][2] == gear[i+1][6]:
            break
        rotate[i] = rotate[i+1] * - 1

    #회전
    for i in range(4):
        if rotate[i] == 0:
            continue
        elif rotate[i] == 1: # 시계 회전
            gear[i].rotate(1)
        else:
            gear[i].rotate(-1) # 반시계 회전

for i in range(4):
    if gear[i][0] == 1:
        res += score[i] # 1, 2, 4, 8

print(res)
