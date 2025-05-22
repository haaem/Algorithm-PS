import sys
score_total = 0
unit_total= 0
while True:
    try:
        S = input()
        if (S == ''):
            break
        S = S.split()
        grade = S[2]
        unit = float(S[1])
        if grade == 'P':
            pass
        else:
            unit_total += unit
            if grade == 'A+':
                score_total += 4.5 * unit
            elif grade == 'A0':
                score_total += 4.0 * unit
            elif grade == 'B+':
                score_total += 3.5 * unit
            elif grade == 'B0':
                score_total += 3.0 * unit
            elif grade == 'C+':
                score_total += 2.5 * unit
            elif grade == 'C0':
                score_total += 2.0 * unit
            elif grade == 'D+':
                score_total += 1.5 * unit
            elif grade == 'D0':
                score_total += 1.0 * unit
    except EOFError:
        break

average = score_total / unit_total
print(average)

# 파이썬에서 match-case가 다른 언어에서 switch-case, 3.10 patch에 생김