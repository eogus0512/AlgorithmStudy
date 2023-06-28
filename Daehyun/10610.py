num = input() # N 입력
arr = [] # 배열 선언
for n in num: # 입력 받은 N을 배열로 변환
    arr.append(int(n))

if 0 not in arr or sum(arr) % 3 != 0: # 원소에 0이 없거나, 원소의 합이 3의 배수가 아니면
    print(-1) # -1 출력
else:
    sorted_arr = sorted(arr, reverse=True) # 배열 내림차순 정렬
    num = int(''.join(str(n) for n in sorted_arr)) # 숫자를 문자열로 변환 후, 문자열을 정수로 변환
    print(num) # num 출력
