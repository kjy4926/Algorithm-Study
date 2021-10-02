def solution(participant, completion):
    answer = ''
    dic = {}

    for p in participant :
        try :
            dic[p] += 1
        except :
            dic[p] = 1
    
    for c in completion :
        dic[c] -= 1
        if dic[c] == 0 :
            dic.pop(c)
    
    answer = list(dic.keys())

    return answer[0]

participant = ['leo', 'kiki', 'eden']
completion = ['eden', 'kiki']

solution(participant, completion)