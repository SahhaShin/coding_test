#!/usr/bin/env python
# coding: utf-8

# In[21]:


import math
result=0
up,down,length=input().split(' ')

if up==length:
    result=1

elif (int(length)-int(up))/(int(up)-int(down))<1:
    result=2
       
else:
    result=int(math.ceil(((int(length)-int(up))/(int(up)-int(down))))+1)

print(result)

