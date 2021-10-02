from collections import deque

def solution(gems):
    answer = []
    start = 0
    end = 0
    l = 1000000
    deq = deque()
    deq_item = []
    gem_list = set(gems)
    
    for i in range(0, len(gems)) :
        if len(deq) == 0 :
            deq.append(gems[i])
            deq_item.append(gems[i])
            continue
        
        print(gems[i], deq[0])
        
        if deq[0] != gems[i] :
            deq.append(gems[i])
            if gems[i] not in deq_item :
                deq_item.append(gems[i])
                if len(deq_item) == len(gem_list) :
                    if ((i-start) + 1) < l :
                        l = ((i-start) + 1)
                        end = i
        else :
            deq.popleft()
            deq.append(gems[i])
            start += 1
    
    return [start+1, end+1]

gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]

solution(gems)