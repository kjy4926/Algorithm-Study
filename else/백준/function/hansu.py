n = int(input())
ans = 0
for i in range(1, n+1) :
    if i < 100 :
        ans += 1
    else :
        flag = True
        change = str(i)
        dif = int(change[0]) - int(change[1])
        for j in range(1, len(change)-1) :
            dif2 = int(change[j]) - int(change[j+1])
            if dif2 != dif :
                flag = False
                break
        if flag == True :
            ans += 1
print(ans)