#!/usr/bin/env python
# coding: utf-8

# In[2]:


number=[]
about=int(input())

for i in range(0, about):
    number.append(int(input()))
    
sort=sorted(number)

for i in range(0, about):
    print(sort[i])

