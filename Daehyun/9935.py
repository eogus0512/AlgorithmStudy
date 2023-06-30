str = input() # 문자열
exp = input() # 폭발 문자열
temp = [] # 새로 생긴 문자열

for i in range(len(str)):
    temp.append(str[i]) # 문자열의 요소를 하나씩 temp에 append
    if ''.join(temp[-len(exp):]) == exp: # temp의 맨끝 exp길이 만큼의 문자열과 exp가 같으면
        for _ in range(len(exp)): # 해당 문자열 길이만큼 맨끝 요소 pop
            temp.pop() # temp = temp[-1]하면 시간초과

if ''.join(temp)!='':
    print(''.join(temp))
else:
    print('FRULA')
