def solution(arr):
    answer = True
    stack = []
    sort_arr = sorted(arr)
    result = []
    k = 0

    for s in sort_arr :
        if len(stack) == 0 :
            stack.append(s)
        elif s < arr[k] :
            stack.append(s)
        elif s == arr[k] :
            k += 1
            continue
        else :
            while stack :
                item = stack.pop()
                if item == arr[k] :
                    k += 1
                else :
                    return False
            stack.append(s)

    while stack :
        item = stack.pop()
        if item != arr[k] :
            return False
        k += 1

    return answer

a = 'A'
b = 'B'
print(a < b)