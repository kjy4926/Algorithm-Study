import sys
data = sys.stdin.readlines()
answer = 0
for line in data[1:] :
    line = line.strip()
    stack = []
    s = set()
    flag = True
    for c in line :
        if len(stack) == 0 :
            stack.append(c)
        else :
            if c == stack[-1] :
                continue
            else :
                stack.append(c)
    while stack :
        top = stack.pop()
        if top in s :
            flag = False
            break
        else :
            s.add(top)
    if flag == True :
        answer += 1
print(answer)

'''
result = 0
for i in range(int(input())):
    word = input()
    if list(word) == sorted(word, key=word.find):
        result += 1
print(result)
'''