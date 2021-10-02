def solution(progresses, speeds):
    answer = []
    time = []
    queue = []
    
    for p, s in zip(progresses, speeds) :
        k = 100 - p
        d = 1
        if k%s == 0 :
            d = int(k / s)
        else :
            d = int((k/s)+1)
        
        if len(time) == 0 :
            time.append(d)
            continue

        if time[0] < d :
            answer.append(len(time))
            time.clear()
            time.append(d)
        else :
            time.append(d)
    
    answer.append(len(time))

    return answer

progresses = [40, 93, 30, 55, 60, 65]
speeds = [60, 1, 30, 5 , 10, 7]

print(solution(progresses, speeds))