N = int(input())
total = 1
room = 1

if N!=1:
    while total<N:
        total += 6*room
        room += 1
print(room)