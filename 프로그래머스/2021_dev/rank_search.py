from itertools import combinations

def solution(info, query):
    answer = []
    dic = {}
    # 점수를 제외한 테이블 생성
    for i in info :
        i2 = i.split() 
        info_item = i2[:-1]
        score = int(i2[-1]) 
        # 점수를 제외한 모든 값의 조합을 딕셔너리에 생성 및 스코어 입력
        for k in range(0, 5) :
            for c in combinations(info_item, k) :
                tmp_item = ''.join(c)
                if tmp_item in dic :
                    dic[tmp_item].append(score)
                else :
                    dic[tmp_item] = []
                    dic[tmp_item].append(score)
    # 딕셔너리 입력된 스코어를 오름차순 정렬
    for key in dic.keys() :
        dic[key].sort()
        
    for q in query :
        q = q.replace('and ', '')
        q = q.replace('-', '')
        q = q.split()
        q_item = q[:-1]
        q_score = int(q[-1])
        q_str = ''.join(q_item)
        # lower bound를 통해 score이상의 인원 파악
        if q_str in dic :
            l = len(dic[q_str])
            left = 0
            right = l
            while left < right :
                mid = (right + left)//2
                if dic[q_str][mid] < q_score :
                    left = mid+1
                else :
                    right = mid
            answer.append(l-right)
        else :
            answer.append(0)

    return answer

info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]

solution(info, query)