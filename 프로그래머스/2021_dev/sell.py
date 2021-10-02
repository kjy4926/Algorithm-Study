def solution(enroll, referral, seller, amount):
    answer = []
    dic = {}
    for i in range(0, len(enroll)) :
        dic[enroll[i]] = [referral[i], 0] # [추천자, 수익]
    
    for j in range(0, len(seller)) :
        name = seller[j]
        a = amount[j] * 100

        ref = dic[name][0]  # 추천자
        give = int(a * 0.1) # 추천자가 가져갈 수익
        my = a - give       # 내가 가져갈 수익
        dic[name][1] += my  # 본인 수익 갱신

        while dic[name][0] != '-' and give > 0 :
            name = dic[name][0]
            a = give

            ref = dic[name][0]  # 추천자
            give = int(a * 0.1) # 추천자가 가져갈 수익
            my = a - give       # 내가 가져갈 수익
            dic[name][1] += my  # 본인 수익 갱신
    
    for e in enroll :
        answer.append(dic[e][1])

    return answer

def referral_reculsive(dic, name, amount) :
    ref = dic[name][0]
    give = int(amount * 0.1)
    my = amount - give
    dic[name][1] += my
    if ref == '-' :
        return
    else :
        referral_reculsive(dic, ref, give)


e = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
r = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
s = ["young", "john", "tod", "emily", "mary"]
a = [12, 4, 2, 5, 10]

solution(e,r,s,a)