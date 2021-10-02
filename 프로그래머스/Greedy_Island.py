rank = {}
parent = {}

def find(node) :
    if parent[node] != node :
        parent[node] = find(parent[node])
    return parent[node]

def union(a, b) :
    root_a = find(a)
    root_b = find(b)

    if rank[root_a] > rank[root_b] :
        parent[root_b] = root_a
    else :
        parent[root_a] = root_b
        if rank[root_a] == rank[root_b] :
            rank[root_b] += 1

def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x : x[2], reverse = True)

    for i in range(n) :
        parent[i] = i
        rank[i] = 0  

    edge_num = 0

    while True :
        if edge_num == n-1 :
            break
        start, end, weight = costs.pop()
        if find(start) != find(end) :
            union(start, end)
            answer += weight
            edge_num += 1

    return answer


n = 4
costs = [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
print(solution(n, costs))