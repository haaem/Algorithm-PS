while True:
    n = int(input())
    if n == -1:
        break
    lst = []
    for i in range(1,n):
        if n%i==0:
            lst.append(i)
    total=0
    for i in range(len(lst)):
        total+=lst[i]
    if total!=n:
        print(f'{n} is NOT perfect.')
    else:
        print(f'{n} = ', end='')
        for i in range(len(lst)):
            if i == len(lst)-1:
                print(f'{lst[i]}')
            else:
                print(f'{lst[i]} + ', end='')