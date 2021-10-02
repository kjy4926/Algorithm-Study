from collections import deque

def solution(N, stages):
    answer = []
    deq = deque()
    result = []
    stages.sort()
    clear = 0 # 클리어한 사람의 수
    reach = 0 # 도달한 사람의 수
    
    for n in range(N, 0, -1) :
        while stages :
            if stages[-1] >= n :
                reach += 1
                deq.append(stages.pop())
            else :
                break
        
        while deq and deq[0] > n :
            clear += 1
            deq.popleft()

        if reach == 0 :
            result.append([n, 0])
        else :
            rate = (reach-clear) / reach
            result.append([n, rate])
    
    result.sort(key = lambda x : (-x[1], x[0]))

    for r in result :
        answer.append(r[0])

    return answer

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages))