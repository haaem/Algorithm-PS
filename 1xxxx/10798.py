max_length = 0
word_list = []
for i in range(5):
    word = input()
    word_list.append(word)
    if len(word) > max_length:
        max_length = len(word)
for i in range(max_length):
    for j in range(5):
        try:
            print(word_list[j][i], end="")
        except IndexError:
            pass

'''
G = [input().rstrip() for _ in range(5)]
word_str = ''
for i in range(15):
    for j in range(5):
        if len(G[j]>i):
            word_str += G[j][i]
'''