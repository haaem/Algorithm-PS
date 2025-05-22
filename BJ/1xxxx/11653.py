N = int(input())
if(N==1):
    exit(0)

i=2
while (N!=1):
    if(N%i==0):
        print(i)
        N/=i
    else:
        i+=1