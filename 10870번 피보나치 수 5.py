#!/usr/bin/env python
# coding: utf-8

# In[10]:


result=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
number=int(input())
for i in range(0,number+1):
    if i==0 or i==1:
        result[i]=i
    else:
        result[i]=int(result[i-2]+result[i-1])
        
        
print(result[number])
    

