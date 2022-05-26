number = [i for i in range(1,10001)]
result = [True] * 10000

for n in number :
    thousand = n//1000
    hundred = (n%1000)//100
    ten = (n%100)//10
    one = (n%10)
    new_num = n + thousand + hundred + ten + one
    if new_num <= 10000 :
        result[new_num-1] = False
for i in range(0, 10000) :
    if result[i] == True :
        print(i+1)