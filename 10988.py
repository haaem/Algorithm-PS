str = input()
palindrome = True
if len(str) % 2 == 0:
    for i in range(int(len(str)/2)):
        if str[i] != str[-1-i]:
            palindrome = False
            break
else:
    for i in range(int((len(str)-1)/2)):
        if str[i] != str[-1-i]:
            palindrome = False
            break
if palindrome:
    print(1)
else:
    print(0)