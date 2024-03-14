num = int(input())
for i in range(num):
    S = input().split(" ")
    mul = int(S[0])
    A = S[1]
    total = ""
    for j in range(len(A)):
        total += A[j]*mul
    print(total)