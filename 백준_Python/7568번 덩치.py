#!/usr/bin/env python
# coding: utf-8

# In[10]:


people=int(input())
weight=[]
height=[]
result=[0]*people
rank=1

# 몸무게와 키를 받는다.
for i in range(people):
    w,h=map(int,input().split(' '))
    weight.append(w)
    height.append(h)
    
for i in range(0,people):
    for j in range(0,people):
        if weight[i]<weight[j] and i!=j:
            if height[i]<height[j]:
                rank=rank+1
                
    result[i]=rank
    rank=1
    
for i in range(people):
    print(f'{result[i]}', end=' ')

