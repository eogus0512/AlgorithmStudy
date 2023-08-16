import sys
from collections import deque

input = sys.stdin.readline
gears = [deque(list(map(int, input().strip()))) for _ in range(4)]
K = int(input())
rotate = [list(map(int, input().split())) for _ in range(K)]

def left_rotate(index, direction, flag):
    if not gears[index + 1][6] == gears[index][2] and flag:
        if index >= 1:
            left_rotate(index - 1, direction * -1, True)
        gears[index].rotate(direction)


def right_rotate(index, direction, flag):
    if not gears[index - 1][2] == gears[index][6] and flag:
        if index <= 2:
            right_rotate(index + 1, direction * -1, True)
        gears[index].rotate(direction)


for r in rotate:
    if (r[0] - 1) >= 1:
        left_rotate(r[0]-2, r[1] * -1, True)
    if (r[0] - 1) <= 2:
        right_rotate(r[0], r[1] * -1, True)
    gears[r[0] - 1].rotate(r[1])

score = 0
for i in range(4):
    score += gears[i][0] * (2**i)

print(score)

