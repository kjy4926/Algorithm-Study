import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    queue = []
    answer = []

    for o in operations :
        oper, n = o.split()
        n = int(n)
        if oper == "I" :
            heapq.heappush(min_heap, n)
            heapq.heappush(max_heap, -n)
            queue.append(n)
            pass
        elif oper == "D" :
            if len(queue) == 0 :
                min_heap.clear()
                max_heap.clear()
            else :
                if n == 1 :
                    _max = -(heapq.heappop(max_heap))
                    queue.remove(_max)
                    min_heap.remove(_max)
                    heapq.heapify(min_heap)
                elif n == -1 :
                    _min = heapq.heappop(min_heap)
                    queue.remove(_min)
                    max_heap.remove(-_min)
                    heapq.heapify(max_heap)
        else :
            break
    
    if len(queue) == 0 :
        answer = [0,0]
    else :
        answer.append(-(max_heap[0]))
        answer.append(min_heap[0])

    return answer

operations = ["I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1"]
#operations = ["I 5", "I 5", "D 1", "I 7", "D -1", "I 8"]
#operations = ["I 7","I 5","I -5","D -1"]
print(solution(operations))