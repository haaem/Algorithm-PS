al = list()
for _ in range(26):
    al.append(0)
S = input().upper()
for i in range(len(S)):
    al[ord(S[i])-65] += 1

max = max(al)
if al.count(max) != 1:
    print("?")
else:
    print(chr(al.index(max)+65))