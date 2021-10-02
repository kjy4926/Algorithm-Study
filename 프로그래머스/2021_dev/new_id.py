from collections import deque

def solution(new_id):
    answer = ''
    dq = deque()
    sc = ['-', '_', '.']
    num = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    # step 1
    new_id = new_id.lower()

    # step 2 and step 3
    for c in new_id :
        if c in sc or c in num or 'a' <= c <= 'z' :
            if len(dq) == 0 :
                dq.append(c)
            elif c == '.' :
                if dq[-1] == '.' :
                    continue
                else :
                    dq.append(c)
            else :
                dq.append(c)
    
    # step 4
    if len(dq) > 0 and dq[0] == '.' :
        dq.popleft()
    
    if len(dq) > 0 and dq[-1] == '.' :
        dq.pop()

    # step 5
    if len(dq) == 0 :
        dq.append('a')

    # step 6
    while len(dq) > 15 :
        dq.pop()

    if len(dq) > 0 and dq[-1] == '.' :
        dq.pop()

    while dq :
        answer += dq.popleft()
    
    # step 7
    while len(answer) < 3 :
        answer += answer[-1]

    return answer

id = '...!@BaT#*..y.abcdefghijklm'