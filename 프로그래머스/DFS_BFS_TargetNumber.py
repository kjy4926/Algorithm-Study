from collections import deque

def solution(numbers, target) :
    answer = 0
    queue = deque([(0, 0)]) # sum, level
    while queue:
        s, l = queue.popleft()
        if l > len(numbers):
            break
        elif l == len(numbers) and s == target:
            answer += 1
        queue.append((s+numbers[l-1], l+1))
        queue.append((s-numbers[l-1], l+1))

    return answer

def solution2(numbers, target) :
    answer = 0
    stack = [(0, 0)]
    while stack :
        _sum, lv = stack.pop()
        if lv > len(numbers) :
            continue
        elif lv == len(numbers) and _sum == target :
            answer += 1
        stack.append((_sum+numbers[lv-1], lv+1))
        stack.append((_sum-numbers[lv-1], lv+1))

    return answer

numbers = [1,1,1,1,1]
target = 3
print(solution2(numbers, target))