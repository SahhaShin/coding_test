#!/usr/bin/env python
# coding: utf-8

# In[6]:


x,y,w,h=map(int,input().split(' '))

#복잡한 코드

# distance=[]
# right=w-x
# distance.append(right)

# left=x-0
# distance.append(left)

# top=h-y
# distance.append(top)

# bottom=y-0
# distance.append(bottom)
#print(min(distance))


#좀 더 간단하게 바꾸기!

print(min([w-x, x, y, h-y]))

