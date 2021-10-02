def solution(p):  
    if p == '' :
        return p
    
    answer = ''
    count = 0
    correct = True

    for i in range(0, len(p)) :
        if p[i] == '(' :
            count -= 1
        else :
            count += 1
        if count > 0 :
            correct = False
        if count == 0 :
            u = p[:i+1]
            v = p[i+1:]
            if correct :
                return u + solution(v)
            else :
                answer = '(' + solution(v) + ')'
                for j in range(1, i) :
                    if u[j] == '(' :
                        answer += ')'
                    else :
                        answer += '('
                return answer

p = "()))((()"
print(solution(p))

# 이건 고수꺼
'''
def solution(p):
    if p=='': return p
    r=True; c=0
    for i in range(len(p)):
        if p[i]=='(': c-=1
        else: c+=1
        if c>0: r=False
        if c==0:
            if r:
                return p[:i+1]+solution(p[i+1:])
            else:
                return '('+solution(p[i+1:])+')'+''.join(list(map(lambda x:'(' if x==')' else ')',p[1:i]) ))
'''
'''
def solution(p):  
    if len(p) == 0 :
        return ''

    answer = ''
    stack = []
    u = ''
    v = ''
    left = 0
    right = 0
    correct = False # u가 올바른가 아닌가 판단

    for i in range(0, len(p)) :
        if len(stack) == 0 :
            if p[i] == '(' : 
                left += 1
            else :
                right += 1
            stack.append(p[i])
        else :
            if p[i] == '(' :
                left += 1
                stack.append(p[i])
            else :
                right += 1
                stack.pop()
            if left == right and len(u) == 0 :
                u = p[:i+1]
                if len(u) < len(p) :
                    v = p[i+1:]
                if len(stack) == 0 :
                    correct = True
    
    # 올바른 괄호 문자열인 경우
    if len(stack) == 0 :
        return p
    # 아닌 경우
    if correct : # True
        return u + solution(v)
    else : # False
        answer = '(' + solution(v) + ')'
        for j in range(1, len(u)-1) :
            if u[j] == '(' :
                answer += ')'
            else :
                answer += '('

    return answer
'''