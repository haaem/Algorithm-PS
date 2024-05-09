from math import ceil
A,B,V = list(map(int, input().split()))
print(ceil((V-B)/(A-B)))