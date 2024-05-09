import copy
lst = list(map(int, input().split()))
n = lst[0]
m = lst[1]
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

def row_is_one():
    s = 0
    for j in range(m):
        if arr[0][j] == 0:
            if j==0:
                arr[0][0] = 1
            else:
                arr[0][j] = arr[0][j-1]+1
        else:
            if j!=0 and arr[0][j-1]>=arr[0][j]:
                return -1
        s += arr[0][j]
    return s
def column_is_one():
    s = 0
    for i in range(n):
        if arr[i][0] == 0:
            if i==0:
                arr[0][0] = 1
            else:
                arr[i][0] = arr[i-1][0]+1
        else:
            if i!=0 and arr[i-1][0]>=arr[i][0]:
                return -1
        s += arr[i][0]
    return s

def find_top(arr1, i,j):
    if i==0:
        return 0
    else:
        return arr1[i-1][j]
def find_left(arr1,i,j):
    if j==0:
        return 0
    else:
        return arr1[i][j-1]
    
def sum_if_even_even(arr):
    b = copy.deepcopy(arr)
    s=0
    top=0
    left=0
    for i in range(n):
        for j in range(m):
            top = find_top(b,i,j)
            left = find_left(b,i,j)
            if b[i][j]==0:
                b[i][j] = max(top, left) + 1
                if b[i][j]%2 != i%2:
                    b[i][j] += 1
            elif b[i][j]%2 != i%2 or b[i][j]<=left or b[i][j]<=top:
                return 1e13
            s += b[i][j]
    return s
def sum_if_even_odd(arr):
    b = copy.deepcopy(arr)
    s=0
    top=0
    left=0
    for i in range(n):
        for j in range(m):
            top = find_top(b,i,j)
            left = find_left(b,i,j)
            if b[i][j]==0:
                b[i][j] = max(top, left) + 1
                if b[i][j]%2 != j%2:
                    b[i][j] += 1
            elif b[i][j]%2 != j%2 or b[i][j]<=left or b[i][j]<=top:
                return 1e13
            s += b[i][j]
    return s
def sum_if_odd_even(arr):
    b = copy.deepcopy(arr)
    s=0
    top=0
    left=0
    for i in range(n):
        for j in range(m):
            top = find_top(b,i,j)
            left = find_left(b,i,j)
            if (b[i][j]==0):
                b[i][j] = max(top, left) + 1
                if b[i][j]%2 == j%2:
                    b[i][j] += 1
            elif b[i][j]%2 == j%2 or b[i][j]<=left or b[i][j]<=top:
                return 1e13
            s += b[i][j]
    return s
def sum_if_odd_odd(arr):
    b = copy.deepcopy(arr)
    if(b[0][0]==0):
        b[0][0]=1
    s=0
    top=0
    left=0
    for i in range(n):
        for j in range(m):
            top = find_top(b,i,j)
            left = find_left(b,i,j)
            if (b[i][j]==0):
                b[i][j] = max(top, left) + 1
                if b[i][j]%2 == i%2:
                    b[i][j] += 1
            elif b[i][j]%2 == i%2 or b[i][j]<=left or b[i][j]<=top:
                return 1e13
            s += b[i][j]
    return s

if n==1:
    print(row_is_one())
elif m==1:
    print(column_is_one())
else:
    a = min(sum_if_even_even(arr), sum_if_even_odd(arr))
    b = min(sum_if_odd_odd(arr), sum_if_odd_even(arr))
    c = min(a,b)
    if c==1e13:
        print(-1)
    else:
        print(c)