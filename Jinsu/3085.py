# 3085/사탕 게임
import sys
input = sys.stdin.readline

n = int(input())
grid = []
res = 0
for _ in range(n):
    grid.append(list(input().rstrip('\n')))

def check():
    global res
    for i in range(n):
        for j in range(n):
            cur = grid[i][j]
            temp = 1
            for k in range(j+1, n): # 오른쪽 확인
                if cur == grid[i][k]:
                    temp += 1
                else:
                    break
            res = max(res, temp)
            temp = 1
            for k in range(i+1, n): # 아래 확인
                if cur == grid[k][j]:
                    temp += 1
                else:
                    break
            res = max(res, temp)

for i in range(n):
    for j in range(n):
        if i != n-1:
            grid[i][j], grid[i+1][j] = grid[i+1][j], grid[i][j]
            check()
            grid[i][j], grid[i + 1][j] = grid[i + 1][j], grid[i][j]
        if j != n-1:
            grid[i][j], grid[i][j+1] = grid[i][j+1], grid[i][j]
            check()
            grid[i][j], grid[i][j + 1] = grid[i][j + 1], grid[i][j]
print(res)

