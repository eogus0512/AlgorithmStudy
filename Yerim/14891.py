# #톱니 바퀴 문제
# #deque.rotate() 사용 -> 음수 : 왼쪽 회전, 양수 : 오른쪽 회전 

# import sys
# from collections import deque
# input = sys.stdin.readline
# gear = [deque(list(map(int, input()))) for _ in range(4)]
# k = int(input()) 
# for _ in range(k):
#     n, d = map(int, input().split())
#     n -= 1 
#     left = n - 1
#     right = n + 1
#     left_d, right_d = -d, -d
    
#     #왼쪽
		# while left >= 0 and gear[left][2] != gear[left + 1][6]:
		# 		gear[left].rotate(left_d)
		# 		left -= 1
		# 		left_d = -left_d

# 	 #오른쪽 
		# while right <= 3 and gear[right][6] != gear[right - 1][2]:
		# 		gear[right].rotate(right_d)
		# 		right += 1
		# 		right_d = -right_d
    
		# gear[n].rotate(d)
# 점수 계산 	

# for i, value in enumerate([1, 2, 4, 8]):
#      if gear[i][0] == 1:
#         score += value
# print(score)



from collections import deque
# 오른쪽 
def right(idx, d): 
    if idx > 3:
        return
    # 같은 극인지 체크 
    if gear[idx - 1][2] != gear[idx][6]:
        right(idx + 1, -d)
        gear[idx].rotate(d)

#왼쪽 
def left(idx, d):
    if idx < 0:
        return
    if gear[idx][2] != gear[idx + 1][6]:
        left(idx - 1, -d)
        gear[idx].rotate(d)

# 오른쪽 
gear = [deque(list(map(int, input()))) for _ in range(4)]
k = int(input())   # 회전 횟수

for _ in range(k):
    idx, d = map(int, input().split())
    idx -= 1
    left(idx - 1, -d)
    right(idx + 1, -d)

    # 회전할 톱니 번호의 톱니도 회전
    gear[idx].rotate(d)


# 점수 계산하여 출력
score = 0
for i, value in enumerate([1, 2, 4, 8]):
     if gear[i][0] == 1:
        score += value
print(score)


