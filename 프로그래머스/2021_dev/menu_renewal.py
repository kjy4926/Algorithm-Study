from itertools import combinations

def solution(orders, course):
    answer = []
    comb = []
    dic = {}

    # 모든 조합 추출
    for o in orders :
        order = list(o)
        order.sort()
        for n in course :
            if len(order) >= n :
                comb += list(combinations(order, n))

    # 조합 등장 횟수 측정
    for c in comb :
        combo = ''.join(c)
        if combo not in dic :
            dic[combo] = 1
        else :
            dic[combo] += 1
    
    # 딕셔너리 item 등장 횟수로 정렬
    items = list(dic.items())
    items.sort(key = lambda x : (len(x[0]), -x[1]))
    
    before_len = len(items[0][0]) # 이전 콤보 길이
    current_len = 0 # 현재 콤보 길이
    _max = 0

    for i in items :
        if len(i[0]) == before_len :
            if i[1] > 1 and i[1] >= _max :
                _max = i[1]
                answer.append(i[0])
        else :
            before_len = len(i[0])
            _max = i[1]
            if i[1] > 1 :
                answer.append(i[0])
    
    answer.sort()

    return answer

o = ["XYZ", "XWY", "WXA"]
c = [2,3,4]

solution(o, c)