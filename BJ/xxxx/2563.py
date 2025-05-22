paper_num = int(input())
total = [[0]*100 for _ in range(100)]
count = 0

for _ in range(paper_num):
    x, y =list(map(int, input().split()))
    for i in range(10):
        for j in range(10):
            total[x+i][y+j] = 1

for i in range(100):
    for j in range(100):
        count += total[i][j]

print(count)