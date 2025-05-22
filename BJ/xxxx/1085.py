x,y,w,h = list(map(int,input().split()))

min1 = min(x,y)
min2 = min(w-x,h-y)
print(min(min1,min2))