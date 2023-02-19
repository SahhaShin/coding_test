#!/usr/bin/env python
# coding: utf-8

# In[12]:


result=0
flag=0
number=int(input())
for i in range(1,number+1):
    copy=i
    result=i
    while(copy!=0):
        result=result+copy%10
        copy=copy//10
    
    if(result==number):
        flag=1
        print(i)
        break

if flag==0:
    print(0)

