num = int(input())
total = 0
for _ in range(num):
    word = input()
    if len(word) == 1: 
        total += 1
    else:
        already = list(word[0])
        for i in range(1, len(word)):
            if word[i] not in already:
                if i == len(word)-1:
                    total += 1
                already.append(word[i])
            else:
                if word[i] == word[i-1]:
                    if i == len(word)-1:
                        total += 1
                else:
                    break
print(total)