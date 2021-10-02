from itertools import permutations

def solution(expression):
    dic = {}
    stack = []
    postfix = []
    answer = []
    priority = list(permutations(["*", "+", "-"], 3))

    p = priority[0]

    # 우선순위 모든 조합에 대하여 진행한다.
    for p in priority :
        dic[p[0]] = 2
        dic[p[1]] = 1
        dic[p[2]] = 0
        temp = ''

        # infix -> postfix
        for e in expression :
            if '0' <= e <= '9' :
                temp += e
            else :
                postfix.append(int(temp))
                temp = ''
                if len(stack) == 0 :
                    stack.append(e)
                else :
                    if dic[stack[-1]] < dic[e] :
                        stack.append(e)
                    else :
                        while stack and dic[stack[-1]] >= dic[e] :
                            postfix.append(stack.pop())
                        stack.append(e)

        # 마지막 남은 정수 입력
        postfix.append(int(temp))

        # stack에 남아 있는 연산자를 postfix에 추가한다.
        while stack :
            postfix.append(stack.pop())

        # pop(0) 보다 pop()으로 진행하는 것이 효율이 좋으므로 reverse
        postfix.reverse()

        # postfix 연산
        while postfix :
            item = postfix.pop()
            if isinstance(item, int) :
                stack.append(item)
            else : 
                a = stack.pop()
                b = stack.pop()
                if item == '+' :
                    stack.append(a+b)
                if item == '-' :
                    stack.append(b-a)
                if item == '*' :
                    stack.append(a*b)

        answer.append(abs(stack.pop()))

    return max(answer)

expression = "2-990-5+2"

print(solution(expression))