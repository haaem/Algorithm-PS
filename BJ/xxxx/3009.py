x1,y1 = list(map(int, input().split()))
x2,y2 = list(map(int, input().split()))
x3,y3 = list(map(int, input().split()))
if(x1==x2):
    x=x3
elif x1==x3:
    x=x2
else:
    x=x1
if y1==y2:
    y=y3
elif y2==y3:
    y=y1
else:
    y=y2
print(f"{x} {y}")