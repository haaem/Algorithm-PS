input = input().split()
a = int(''.join(reversed(input[0])))
b = int(''.join(reversed(input[1])))
if a>b:
    print(a)
else:
    print(b)