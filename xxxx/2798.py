N,M = list(map(int, input().split()))
lst = list(map(int, input().split()))
total=0
for i in range(N):
    for j in range(i+1,N):
        for k in range(j+1,N):
            sum = lst[i]+lst[j]+lst[k]
            if (sum<=M and abs(M-sum)<abs(M-total)):
                total = sum
print(total)