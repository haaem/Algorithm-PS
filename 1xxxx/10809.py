al = list()
for i in range(26):
    al.append(-1)
S = input()
for i in range(len(S)):
    index = ord(S[i])-97
    if al[index] == -1:
        al[index] = i
print(' '.join(map(str, al)))