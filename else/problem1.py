def solution(new_id):
    new_id = new_id.lower()
    item = []
    dot_idx = None
    dot = ""
    dot_str = []

    for i in range(0, len(new_id)) :
        if "a" <= new_id[i] <= "z" or "0" <= new_id[i] <= "9" or new_id[i] == "-" or new_id[i] == "_" or new_id[i] == "." :
            continue
        else :
            if new_id not in item :
                item.append(new_id[i])

    for i in item :
        new_id = new_id.replace(i, "")

    for i in range(0, len(new_id)) :
        if new_id[i] == "." :
            if dot_idx == None :
                dot_idx = i
                dot += "."
            else :
                if i - dot_idx == 1 :
                    dot += "."
                else :
                    if len(dot) >= 2 :
                        if dot not in dot_str :
                            dot_str.append(dot)
                    dot = "" 

    if len(dot_str) > 0 :
        for d in dot_str :
            new_id = new_id.replace(d, ".")

    while len(new_id) > 0 :
        if new_id[0] == "." :
            new_id = new_id[1:]
            if len(new_id) == 0 :
                break 
        if new_id[-1] == "." :
            new_id = new_id[:-1]
            if len(new_id) == 0 :
                break 
        if new_id[0] != "." and new_id[-1] != "." :
            break

    if len(new_id) == 0 :
        new_id = "a"

    if len(new_id) > 15 :
        new_id = new_id[:15]
    
    while new_id[-1] == "." :
        if new_id[-1] == "." :
            new_id = new_id[:-1]
    
    while len(new_id) < 3 :
        new_id += new_id[-1]

    answer = new_id

    return answer

print(solution("a."))