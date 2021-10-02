def solution(p, l):
    answer = 1
    m = max(p)
    i = p.index(m)

    while i != l :
        if len(p) == 1 :
            break
        sub = p[:i]
        p = p[i:]
        p.extend(sub)

        if l < i :
            l = l-(i-1) + (len(p)-1)
        else :
            l = l-i

        p.pop(0)
        answer += 1
        l -= 1
        m = max(p)
        i = p.index(m)

    return answer

p = [1,1,9,1,1,1]
l = 0

print(solution(p, l))