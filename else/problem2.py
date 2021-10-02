from itertools import *

def solution(orders, course):
    answer = []
    dic = {}

    for n in course :
        for o in orders :
            com = list(combinations(o, n))
            for c in com :
                c = list(c)
                c.sort()
                cos = "".join(c)
                try :
                    dic[cos] += 1
                except :
                    dic[cos] = 1

        item = list(dic.items())
        item.sort(key=lambda x : x[1], reverse=True)

        if len(item) != 0 :
            _max = item[0][1]
            if _max < 2 :
                _max = 2

            for i in item :
                if i[1] == _max :
                    answer.append(i[0])
                else :
                    break
        dic.clear()

    answer.sort()

    return answer

print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))