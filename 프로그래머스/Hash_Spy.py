def solution(clothes):
    answer = 1
    dic = {}
    for _, t in clothes :
        if t in dic :
            dic[t] += 1
        else :
            dic[t] = 1

    for k in list(dic.keys()) :
        answer = answer * (dic[k] + 1)
    
    answer = answer - 1

    return answer

c = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]

solution(c)

'''
import collections
from functools import reduce

def solution(c):
    print([x[1] for x in c])
    print(collections.Counter([x[1] for x in c]))
    print([a+1 for a in collections.Counter([x[1] for x in c]).values()])
    return reduce(lambda x,y:x*y,[a+1 for a in collections.Counter([x[1] for x in c]).values()])-1
'''