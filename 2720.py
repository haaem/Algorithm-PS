T = int(input())
balance = [25, 10, 5, 1]
output = []
for _ in range(T):
    C = int(input())
    temp = []
    for i in range(4):
        temp.append(C//balance[i])
        C %= balance[i]
    output.append(temp)

for i in range(T):
    for j in range(3):
        print(output[i][j], end=' ')
    print(output[i][3])