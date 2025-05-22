X = int(input())
N = 1
cross = 0
while True:
    if X <= N+cross:
        if N%2==0:
            print(f"{X-cross}/{N-(X-cross-1)}")
            exit(0)
        else:
            print(f"{N-(X-cross-1)}/{X-cross}")
            exit(0)
    else:
        cross += N
        N+=1