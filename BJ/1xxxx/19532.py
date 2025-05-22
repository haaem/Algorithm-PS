lst = list(map(int,input().split()))
a = lst[0]
b = lst[1]
c = lst[2]
d = lst[3]
e = lst[4]
f = lst[5]
y = (c*d-f*a)/(b*d-e*a)
if a==0:
    x = (f-e*y)/d
else:
    x = (c-b*y)/a
print(int(x),int(y)) 