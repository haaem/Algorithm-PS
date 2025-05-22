N,K = list(map(int, input().split()))
lst=[]
for i in range(1,N+1):
    if N%i==0:
        lst.append(i)
if K>len(lst):
    print(0)
else:
    print(lst[K-1])