def solution(lottos, win_nums):
    answer = []
    _max = 0 # 최고순위
    _min = 0 # 최저순위
    n = 0
    zero = 0

    lottos.sort()
    win_nums.sort()

    for l in lottos :
        if l in win_nums :
            n += 1
        if l == 0 :
            zero += 1

    _max = 7 - n - zero
    _min = 7 - n

    if _max == 7 :
        _max = 6

    if _min == 7 :
        _min = 6
    
    answer.append(_max)
    answer.append(_min)

    return answer

l = [0, 0, 0, 0, 0, 0]
w = [31, 10, 45, 1, 6, 19]

solution(l, w)