num = input().split()
N = int(num[0])
M = int(num[1])
A = []
B = []
for _ in range(N):
    row = input().split()
    A.append(row)
for _ in range(N):
    row = input().split()
    B.append(row)
for n in range(N):
    for m in range(M):
        A[n][m] = str(int(A[n][m]) + int(B[n][m]))
    print(' '.join(A[n]))