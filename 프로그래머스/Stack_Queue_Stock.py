def solution(prices):
    l = len(prices)
    answer = [None] * l
    s = []
    top = -1

    for i in range(len(prices)) :
        p = prices[i]
        if len(s) == 0 :
            s.append([i, p])
            top += 1
            continue

        elif p < s[top][1] :
            while p < s[top][1] :
                item = s.pop()
                top -= 1
                answer[item[0]] = i - item[0]
                if len(s) == 0 :
                    break

        s.append([i, p])
        top += 1

    while s :
        item = s.pop()
        answer[item[0]] = l - item[0] - 1

    return answer

'''
def solution(prices):
    answer = [0] * len(prices)
    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            if prices[i] <= prices[j]:
                answer[i] += 1
            else:
                answer[i] += 1
                break
    return answer
'''