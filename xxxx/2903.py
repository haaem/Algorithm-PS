N = int(input())
width = 2
for i in range(N):
    width += width-1
print(width**2)