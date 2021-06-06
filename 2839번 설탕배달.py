#!/usr/bin/env python
# coding: utf-8

# In[129]:


num=0
deliver_mi=0
deliver=int(input())


if deliver%5==0:
        num=deliver//5
        

elif deliver//5>0:
    for i in range(deliver//5,-1,-1):
        deliver_mi=deliver-(5*i)
        if (deliver_mi%3==0):
            num=i+deliver_mi//3
            break
        else:
            num=-1
            
elif deliver%3==0:
        num=deliver//3

    
else:
    num=-1
    
print(num)

