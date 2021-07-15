#!/usr/bin/env python
# coding: utf-8

# In[5]:


#소수의 갯수를 구하라
#소수는 2~나자신-1까지했을 때 나 자신이 안나눠떨어지면 소수
each=int(input())
number=[]*each
flag=0 #소수면0 아니면1
result=0

number=map(int,input().split())

for i in number:
    for j in range(i-1,1,-1):
        if(i%j==0):
            flag=1
            break
        
    if flag==1 or i==1:
        flag=0
            
    else:
        result=result+1

            
print(result)

