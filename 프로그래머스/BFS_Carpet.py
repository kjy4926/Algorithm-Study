import math

def solution(brown, yellow):
    answer = []

    s = int(math.sqrt(yellow))
    for i in range(1, s+1) :
        if yellow % i == 0 :
            x = int(yellow/i)
            y = i
            n = ((x+y)*2)+4
            if n == brown :
                answer.append(x+2)
                answer.append(y+2)
        else :
            continue

    return answer
brown = 24
yellow = 24
print(solution(brown, yellow))