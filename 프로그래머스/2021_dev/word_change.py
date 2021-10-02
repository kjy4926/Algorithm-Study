from collections import deque

answer = 0

def solution(begin, target, words) :
    global answer
    visited = {}
    for w in words :
        visited[w] = False

    if target not in words :
        return 0
    
    answer = bfs(begin, target, words, visited)

    return answer

def dfs(begin, target, words, visited) :
    global answer
    stack = []
    stack.append(begin)

    while stack :
        word = stack.pop()
        if word == target :
            return answer
        
        for w in words :
            count = 0
            if visited[w] == True :
                continue
            for i in range(len(w)) :
                if word[i] != w[i] :
                    count += 1
                if count > 1 :
                    break
            if count == 1 :
                stack.append(w)
                visited[w] = True   
        answer += 1
    return answer

def bfs(begin, target, words, visited) :
    global answer
    deq = deque()
    deq.append([begin, 0])

    while deq :
        word, level = deq.popleft()
        if word == target :
            return level
        
        for w in words :
            count = 0
            if visited[w] == True :
                continue
            for i in range(len(w)) :
                if word[i] != w[i] :
                    count += 1
                if count > 1 :
                    break
            if count == 1 :
                deq.append([w, level+1])
                visited[w] = True
        answer = level
    return answer

begin = "hit"
target = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]
print(solution(begin, target, words))