matrix = []
m = 0
i = 0
j = 0
for _ in range(9):
    matrix.append(list(map(int, input().split())))
for k in range(9):
    temp = max(matrix[k])
    if temp > m :
        m = temp
        i = k
        j = matrix[i].index(temp)
print(m)
print(i + " " + j)