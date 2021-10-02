def solution(s):
    l = len(s)
    answer = 0
    result = []

    if l == 1 :
        return 1

    for i in range(1, int(l/2)+1) :
        split_s = [s[j:j+i] for j in range(0, len(s), i)]
        count = 1
        end_string = ''
        for j in range(0, len(split_s)-1) :
            if split_s[j] == split_s[j+1] :
                count += 1 
            else :
                if count > 1 :
                    end_string += str(count)
                end_string += split_s[j]
                count = 1
        if count > 1 :
            end_string += str(count)
            end_string += split_s[-1]
        else :
            end_string += split_s[-1]
        
        result.append(len(end_string))
    
    answer = min(result)
    if answer > l :
        answer = l

    return answer

s = "aabbaccc"
print(solution(s))