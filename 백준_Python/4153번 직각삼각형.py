#!/usr/bin/env python
# coding: utf-8

# In[10]:


def tri(x,y,z):
    number=[x,y,z]
    big=max(number)
    number.remove(big)
    
    if(number[0]**2+number[1]**2==big**2 and x!=0 and y!=0 and z!=0):
        return 1
    return 0
        
    
    
x=1
y=1
z=1

while(x!=0 or y!=0 or z!=0):
    x,y,z=map(int,input().split())
    if x==0 and y==0 and z==0:
        break
    if(tri(x,y,z)==1):
        print("right")
    else:
        print("wrong")

