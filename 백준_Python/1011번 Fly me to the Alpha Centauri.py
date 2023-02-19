#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import math
test_case=int(input()) #테스트 케이스
x=0 #출발지점
y=0 #끝지점
y_x=0 #y-x
zg=1 #제곱 범위 찾는데 쓰인다.
result=0 #결과값

for i in range(0,test_case):
    x,y=input().split()
    y_x=int(y)-int(x)
    
    #1부터 돌며 제곱수 범위 찾기 1~4(2제곱)/ 4~9(3제곱) 
    while(1):
        if(y_x<=zg**2):
            #범위를 찾았다. -> 중간 값인지 알아보기 / 중간 값 이상이면 *2-1이다.
            if(math.ceil(zg**2-((zg**2-(zg-1)**2)/2))<=y_x):
                result=zg*2-1
                x=0
                y=0
                y_x=0
                zg=1
                break
            
            #범위를 찾았다. -> 중간 값 보다 작으면 *2-2이다.
            else:
                result=zg*2-2
                x=0
                y=0
                y_x=0
                zg=1
                break
            
        
        else:
            #다음 범위를 찾는다.
            zg=zg+1
        
    print(result)

