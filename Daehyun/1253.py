N = int(input())

arr = list(map(int, input().split()))
arr.sort()

good = 0 # 좋은 수 개수
for i in range(N):
    temp = arr[:i] + arr[i+1:] # 해당 인덱스 요소 제외한 요소로 이루어진 배열 생성
    start, end = 0, len(temp)-1 # 처음과 끝 인덱스를 가르키는 포인터 생성
    while(start < end):
        if temp[start] + temp[end] == arr[i]: # 두 요소의 합이 해당 인덱스 요소와 같으면 좋은수
            good += 1
            break
        elif temp[start] + temp[end] < arr[i]: # 두 요소의 합이 해당 인덱스 요소보다 작으면 start +1
            start += 1
        else: # 두 요소의 합이 해당 인덱스 요소보다 크면 end -1
            end -= 1
print(good)
