#시간초과
# import sys
# input=sys.stdin.readline
# arr=input().rstrip()
# explosion=input().rstrip()
# for i in explosion:
#     if i in arr :
#         arr=arr.replace(i,"")  # replace 사용 -> 시간 초과 발생
# if len(arr)==0:
#     print("FRULA")
# else:
#     print(arr)


#성공 코드
import sys
input=sys.stdin.readline
arr=input().rstrip()
explosion=input().rstrip()
x=len(explosion)
res=[]

for i in arr:
    res.append(i)
    # 스택 뒤에서부터 폭발 문자열 길이만큼 가져온 뒤, 폭발 문자열과 일치하는지 확인
    if ''.join(res[-x:])==explosion:
        # 폭발 문자열과 일치하다면 pop
        for _ in range(len(explosion)):
            res.pop()
print(''.join(res)) if len(res)!=0 else print("FRULA")