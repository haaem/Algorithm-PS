N = int(input())
lst = list(map(int, input().split()))
num=0
for i in range(N):
    if lst[i]==2:
        num+=1
    else:
        for j in range(2,lst[i]):
            if lst[i]%j==0:
                break
            if j==lst[i]-1:
                num+=1
print(num)