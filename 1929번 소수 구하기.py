#!/usr/bin/env python
# coding: utf-8

# In[14]:


import math
flag=0 #0이면 소수 1이면 합성수
min, max=map(int, input().split(' '))

for i in range(min,max+1):
    #1과 짝수는 소수가 아니다. (단, 2는 짝수 중 유일한 소수)
    if i==1 or (i!=2 and i%2==0) :
        continue
        
    elif int(math.sqrt(i))<4:
        for j in range(2,i):
        #합성수이면 다음 수 검사하게 멈춘다.
            if(i%j==0):
                flag=1
                break
        
    else:
        #16부터 들어와야 할 것 같음    
        for j in range(2,int(math.sqrt(i))+1):
            #합성수이면 다음 수 검사하게 멈춘다.
            if(i%j==0):
                flag=1
                break
    if flag==1:
        flag=0
        
    else:
        print(i)

