import heapq

def solution(name):
    answer = 0
    idx_lis = []
    min_heap = []
    max_heap = []
    c = 0 # current position
    i = 0
    for n in name :
        if n != 'A' :
            idx_lis.append(i)
            heapq.heappush(min_heap, i)
            heapq.heappush(max_heap, -i)
            if n <= 'N' :
                answer += (ord(n) - ord('A'))
            else :
                answer += ((ord('Z') - ord(n)) + 1)
        i += 1
    
    while len(min_heap) > 0 and len(max_heap) > 0 :
        l = -max_heap[0]
        r = min_heap[0]
        if c > l :
            left = c-l
        else :
            left = min(c+len(name)-l, l-c)
        if c > r :
            right = r+len(name)-c
        else :
            right = r-c
        if right <= left :
            answer += right
            heapq.heappop(min_heap)
            max_heap.remove(-r)
            heapq.heapify(max_heap)
            c = r
        else :
            answer += left
            heapq.heappop(max_heap)
            min_heap.remove(l)
            heapq.heapify(min_heap)
            c = l

    return answer

name = "JEROEN"
print(solution(name))