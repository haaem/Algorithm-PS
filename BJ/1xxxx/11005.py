lst = list(map(int, input().split()))
N = lst[0]
B = lst[1]
S = ''
while N > 0 :
    R = N%B
    if R <= 9:
        S = str(R) + S
    else:
        S = chr(R+55) + S
    N = N//B
print(S)