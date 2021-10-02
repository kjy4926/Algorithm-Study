def solution(n, computers):
    answer = 0
    graph = {}
    g = 1

    # 그래프 그리기
    for c in computers :
        for i in range(n) :
            if g not in graph :
                graph[g] = []
            if c[i] == 1 :
                if g != i+1 :
                    graph[g].append(i+1)
        graph[g] = set(graph[g])
        if len(graph[g]) == 0 :
            answer += 1
            graph.pop(g)
        g += 1
    
    keys = list(graph.keys())
    keys.reverse()

    if len(keys) == 0 :
        return answer

    root = keys.pop()
    visit = []
    stack = [root]

    # DFS
    while keys :
        root = keys.pop()
        stack.append(root)
        while stack :
            node = stack.pop()
            if node not in visit :
                visit.append(node)
                stack += graph[node] - set(visit)
            if node in keys :
                keys.remove(node)
        answer += 1
    
    return answer

n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
solution(n, computers)