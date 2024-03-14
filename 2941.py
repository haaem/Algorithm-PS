cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
S = input()
total = len(S)
for i in range(len(cro)):
    if S.count(cro[i]) > 0:
        if i == 'dz=':
            total -= 2 * S.count(cro[i])
        else:
            total -= S.count(cro[i])
print(total)


'''
# Better Code
S = input()
cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for i in cro:
    S = S.replace(i, '*')
print(len(S))
'''
