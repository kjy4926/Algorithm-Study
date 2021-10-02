def solution(key, lock):
    answer = True
    sum_key = 0
    sum_lock = 0
    key_list = []
    lock_list = []

    for i in range(len(key)) :
        for j in range(len(key)) :
            sum_key += key[i][j]

    for i in range(len(lock)) :
        for j in range(len(lock)) :
            sum_lock += lock[i][j]
    
    if sum_key < sum_lock :
        return False
    
    print(sum_key, sum_lock)

    return answer

def rotated(lis):
    m = len(lis[0])

    result = [[0]* m for _ in range(m)]

    for i in range(m) :
        for j in range(m) :
            result[j][m-1-i] = lis[i][j]
    return result

key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]