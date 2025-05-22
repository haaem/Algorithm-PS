N=int(input())
for i in range(N+1):
    s = i + sum(list(map(int,str(i))))
    if s==N:
        print(i)
        break
    if i==N:
        print(0)