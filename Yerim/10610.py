
#모든 자리 수의 합이 3의 배수이다.
n=input()
arr=[]
if '0' not in n:
    print(-1)
else:
    for i in n:
        arr.append(int(i))
    if sum(arr)%3==0:
        arr.sort(reverse=True)
        print(''.join(str(s) for s in arr))
    else:
        print(-1)
