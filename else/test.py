def solution(info, query):
    answer = []

    group = []
    dic = {}

    language = ["java", "python", "cpp", "-"]
    position = ["backend", "frontend", "-"]
    carrer = ["junior", "senior", "-"]
    food = ["pizza", "chicken", "-"]

    for l in language :
        for p in position :
            for c in carrer :
                for f in food :
                    group.append(l + " " + p + " " + c + " " + f)
    
    for g in group :
        dic[g] = []

    for i in info :
        spt = i.split()
        key = spt[0] + " " + spt[1] + " " + spt[2] + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = "-" + " " + spt[1] + " " + spt[2] + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + "-" + " " + spt[2] + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + spt[1] + " " + "-" + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + spt[1] + " " + spt[2] + " " + "-"
        dic[key].append(int(spt[4]))
        key = "-" + " " + "-" + " " + spt[2] + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = "-" + " " + spt[1] + " " + "-" + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = "-" + " " + spt[1] + " " + spt[2] + " " + "-"
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + "-" + " " + "-" + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + "-" + " " + spt[2] + " " + "-"
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + spt[1] + " " + "-" + " " + "-"
        dic[key].append(int(spt[4]))
        key = "-" + " " + "-" + " " + "-" + " " + spt[3]
        dic[key].append(int(spt[4]))
        key = "-" + " " + "-" + " " + spt[2] + " " + "-"
        dic[key].append(int(spt[4]))
        key = "-" + " " + spt[1] + " " + "-" + " " + "-"
        dic[key].append(int(spt[4]))
        key = spt[0] + " " + "-" + " " + "-" + " " + "-"
        dic[key].append(int(spt[4]))
        key = "-" + " " + "-" + " " + "-" + " " + "-"
        dic[key].append(int(spt[4]))

    for q in query :
        q_spt = q.split(" and ")
        q_spt[3] = q_spt[3].split()
        key = q_spt[0] + " " + q_spt[1] + " " + q_spt[2] + " " + q_spt[3][0]
        count = 0
        lis = dic[key].copy()
        lis.sort()
        while lis :
            score = lis.pop()
            if score < int(q_spt[3][1]) :
                break
            else :
                count += 1

        answer.append(count)

    return answer

# info
info =["java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"]
# query
query = ["java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"]

print(solution(info, query))