X = int(input())
N = 1
while X>(N*(N+1)/2):
    N+=1
print((1 + N*(N+1)/2 - X)/(N-(X-N*(N-1)/2)))