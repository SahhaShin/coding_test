#!/usr/bin/env python
# coding: utf-8

# In[25]:


times=int(input())

for i in range(times):
    result=input()
    if(len(result)<=1):
        continue
    s_time="".join(result[0:1])
    character=result[2:]
    for j in character:
        print(j*int(s_time), end='')
    print('')

