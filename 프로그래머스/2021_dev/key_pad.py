def solution(numbers, hand):
    position = [[3,0], [3,2]] # left(*), right(#)
    left_click = [1,4,7]
    right_click = [3,6,9]
    dual_click = [2,5,8,0]
    answer = ''
    
    for n in numbers : 
        if n == 0 :
            n = 11
        i = (n-1) // 3
        j = (n-1) % 3
        if n in left_click :
            answer += 'L'
            position[0][0] = i
            position[0][1] = j
        elif n in right_click :
            answer += 'R'
            position[1][0] = i
            position[1][1] = j
        else :
            l = abs(position[0][0] - i) + abs(position[0][1] - j)
            r = abs(position[1][0] - i) + abs(position[1][1] - j)
            if l < r :
                answer += 'L'
                position[0][0] = i
                position[0][1] = j
            if r < l :
                answer += 'R'
                position[1][0] = i
                position[1][1] = j
            if l == r :
                if hand == "left" :
                    answer += 'L'
                    position[0][0] = i
                    position[0][1] = j
                else :
                    answer += 'R'
                    position[1][0] = i
                    position[1][1] = j
                    
    return answer

numbers = [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]
hand = "left"

print(solution(numbers, hand))