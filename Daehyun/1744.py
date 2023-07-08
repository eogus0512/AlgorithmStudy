N = int(input())
arrA = [] # 양수 배열
arrB = [] # 음수 배열
for _ in range(N):
    a = int(input())
    if a > 0:
        arrA.append(a)
    else:
        arrB.append(a)

arrA.sort(reverse=True) # 내림차순 정렬
arrB.sort() #오름차순 정렬

i=0
resultA = 0
while(i<len(arrA)):
    if i == len(arrA)-1: # 마지막 인덱스인 경우 resultA에 값 더해주고 break
        resultA += arrA[i]
        break
    else:
        if arrA[i] * arrA[i + 1] > arrA[i]: # 현재 값과 다음 값을 곱했을 때 현재 값보다 크면
            resultA += arrA[i] * arrA[i + 1] # 곱한 값 더해주고
            i += 2 # 인덱스 +2
        else:
            resultA += arrA[i] # 값 더해주고
            i += 1 # 인덱스 +1

j=0
resultB = 0
while(j<len(arrB)):
    if j == len(arrB)-1: # 마지막 인덱스인 경우 resultB에 값 더해주고 break
        resultB += arrB[j]
        break
    else:
        # 음수의 경우 두개의 값을 곱해주면 양수이므로 무조건 곱해주는게 좋음
        resultB += arrB[j] * arrB[j + 1] # 곱해준 값을 더해줌
        j+=2 # 인덱스 +2

print(resultA+resultB)