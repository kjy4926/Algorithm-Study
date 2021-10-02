from collections import deque
import math

# 상 [-1,0]  1 / 하 [1,0]  2 / 좌 [0,-1] 1 / 우 [0,1] 0
dx,dy = [0,0,1,-1],[1,-1,0,0]

def solution(board):
    def bfs(startX, startY, cost, distance) :
        l = len(board)
        result = [[math.inf for _ in range(l)] for _ in range(l)]
        deq = deque()
        deq.append([startX, startY, cost, distance])
        result[startX][startY] = 0
        while deq :
            x, y, cost, distance = deq.popleft()
            for i in range(4) :
                nx, ny = x + dx[i], y + dy[i]
                ndistance = i
                ncost = cost
                if distance == i :
                    ncost += 100
                else :
                    ncost += 600
                if 0 <= nx < l and 0 <= ny < l and board[nx][ny] != 1 and ncost < result[nx][ny] :
                    result[nx][ny] = ncost
                    deq.append([nx, ny, ncost, ndistance])
        return result[-1][-1]
    return min(bfs(0,0,0,0), bfs(0,0,0,2))

board = [[0,0,0],[0,0,0],[0,0,0]]
print(solution(board))
























'''
def solution(board):
    def bfs(startX,startY,startC,startD):
        n = len(board)
        result = [[math.inf for _ in range(n)] for _ in range(n)]
        q = deque()
        q.append((startX,startY,startC,startD))
        result[startX][startY] = 0
        while q:
            x,y,cost,direction = q.popleft()
            for i in range(4):
                nx,ny,ncost = x + dx[i], y + dy[i], cost+600 if i != direction else cost+100
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0 and result[nx][ny] > ncost:
                    result[nx][ny] = ncost
                    q.append((nx,ny,ncost,i))
        return result[-1][-1]
    return min(bfs(0,0,0,0),bfs(0,0,0,2))
'''