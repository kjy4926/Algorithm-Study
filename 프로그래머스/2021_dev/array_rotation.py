def solution(rows, columns, queries):
    answer = []
    queries.reverse()
    n = 1

    arr =  [[0 for i in range(columns)] for j in range(rows)] 
    for a in arr :
        for i in range(0, len(a)) :
            a[i] = n
            n+=1

    while queries :
        x1, y1, x2, y2 = queries.pop()
        temp = arr[x1][y1-1]
        _min = arr[x1-1][y1-1]

        # →
        for i in range(y1-1, y2) :
            if _min > arr[x1-1][i] :
                _min = arr[x1-1][i]
            temp, arr[x1-1][i] = arr[x1-1][i], temp
        # ↓
        for j in range(x1, x2) :
            if _min > arr[j][y2-1] :
                _min = arr[j][y2-1] 
            temp, arr[j][y2-1] = arr[j][y2-1], temp
        # ←
        for k in range(y2-2, y1-2, -1) :
            if _min > arr[x2-1][k] :
                _min = arr[x2-1][k]
            temp, arr[x2-1][k] = arr[x2-1][k], temp
        # ↑
        for l in range(x2-2, x1-1, -1) :
            if _min > arr[l][y1-1] :
                _min = arr[l][y1-1]
            temp, arr[l][y1-1] = arr[l][y1-1], temp
        
        answer.append(_min)

    return answer

r = 100
c = 97
q = [[1,1,100,97]]

solution(r, c, q)