import heapq
from collections import deque

def solution(jobs):
    tasks = deque(sorted([(x[1], x[0]) for x in jobs], key=lambda x: (x[1], x[0])))
    q = []
    heapq.heappush(q, tasks.popleft())
    current_time, total_response_time = 0, 0
    while len(q) > 0:
        dur, arr = heapq.heappop(q)
        current_time = max(current_time + dur, arr + dur)
        total_response_time += current_time - arr
        while len(tasks) > 0 and tasks[0][1] <= current_time:
            heapq.heappush(q, tasks.popleft())
        if len(tasks) > 0 and len(q) == 0:
            heapq.heappush(q, tasks.popleft())
    return total_response_time // len(jobs)

#jobs = [[0,3],[1,9],[2,6]] #9
#jobs = [[0, 10], [2, 10], [9, 10], [15, 2]] #14
#jobs = [[0, 10], [2, 12], [9, 19], [15, 17]] #25
#jobs = [[0, 1]] #1
#jobs = [[1000, 1000]] #1000
#jobs = [[0, 1], [0, 1], [0, 1]] #2
#jobs = [[0, 1], [0, 1], [0, 1], [0, 1]] #2
#jobs = [[0, 1], [1000, 1000]] #500
#jobs = [[100, 100], [1000, 1000]] #550
#jobs = [[10, 10], [30, 10], [50, 2], [51, 2]] #6
#jobs = [[0, 3], [1, 9], [2, 6], [30, 3]] #7
jobs = [[0, 5], [1, 2], [5, 5]] #6
solution(jobs)