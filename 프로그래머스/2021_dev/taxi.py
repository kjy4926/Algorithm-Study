import heapq

graph = {}

def solution(n, s, a, b, fares):
    answer = 0
    global graph

    # 그래프 그리기
    for f in fares :
        node1 = f[0]
        node2 = f[1]
        if node1 not in graph :
            graph[node1] = {}
        if node2 not in graph :
            graph[node2] = {}
        graph[node1][node2] = f[2]
        graph[node2][node1] = f[2]
    
    for i in range(1, n+1) :
        if i not in graph :
            continue
        distance = dijkstra(s, i, n) + dijkstra(i, a, n) + dijkstra(i, b, n)
        if answer == 0 :
            answer = distance
        else :
            if distance < answer :
                answer = distance
    return answer
# 다익스트라 알고리즘
def dijkstra(start, end, n) :
    if start == end :
        return 0
    heap = []
    INF = 10000000
    global graph
    table = [INF for i in range(n)]
    table[start-1] = 0

    heapq.heappush(heap, [0, start])

    while heap :
        weight, node = heapq.heappop(heap)

        if table[node-1] < weight :
            continue

        for key in graph[node].keys() :
            distance = graph[node][key] + weight
            if distance < table[key-1] :
                table[key-1] = distance
                heapq.heappush(heap, [distance, key])
    
    return table[end-1]

n = 7
s = 3
a = 4
b = 1
fares = [[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]

print(solution(n, s, a, b, fares))