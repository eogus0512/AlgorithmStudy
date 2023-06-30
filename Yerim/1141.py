n=int(input())
arr=[input() for _ in range(n)]
arr.sort()
cnt=len(arr)

for i in range(len(arr)):
    #매치되는 단어들 리스트로 정리
    match = [s for s in arr[i+1:] if arr[i] in s[:len(arr[i])]] 
    #리스트의 길이가 0이 아니라면 (매치되는 단어들이 존재한다면) 제거
    if len(match)!=0:
        cnt-=1
print(cnt)