#!/usr/bin/env python
# coding: utf-8

# In[10]:


#똑같은 x 두번 y 두번이 나와야 직사각형을 평행해서 만들 수 있다.

wid=[]
hei=[]
x=[0]*1001
y=[0]*1001

result_x=0
result_y=0

for i in range(0,3):
    a,b=map(int,input().split(' '))
    
    if(x[a]==1):
        x[a]=x[a]+1
    if(x[a]==0):
        wid.append(a)
        x[a]=x[a]+1
        
    if(y[b]==1):
        y[b]=y[b]+1
    if(y[b]==0):
        hei.append(b)
        y[b]=y[b]+1

if(x[wid[0]]<2):
    result_x=wid[0]

if(x[wid[1]]<2):
    result_x=wid[1]
    
if(y[hei[0]]<2):
    result_y=hei[0]
        
if(y[hei[1]]<2):
    result_y=hei[1]
    
print(f'{result_x} {result_y}')

