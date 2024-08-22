M = int(input())
N = int(input())
sum = 0
min = -1

for i in range(M,N+1):
    for j in range(2,i):
        if i%j==0:
            break
        if j==i-1:
            if min==-1:
                min = i
            sum += i
    if i==2:
        min=2
        sum+=2
if (min==-1):
    print(-1)
    exit(0)
print(sum)
print(min)