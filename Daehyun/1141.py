num = int(input()) # 단어의 개수 N 입력
str = [] # 단어 배열
for _ in range(num):
    str.append(input())

preX = [] # 접두사X 최대 집합
for i in range(len(str)):
    flag = False # true = 다른 단어의 접두사, false = 다른 단어의 접두사X
    for j in range(len(str)):
        # 두 단어가 다르고, 어떤 단어가 다른 단어의 접두사이면
        if i!=j and str[i] == str[j][0:len(str[i])] and str[i] != str[j]:
            flag = True # flag true표시
            break
    if flag == False: # 접두사가 아니므로
        if str[i] not in preX: # 중복 방지
            preX.append(str[i]) # 단어 추가
print(len(preX))