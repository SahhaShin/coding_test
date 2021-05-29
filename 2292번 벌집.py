#!/usr/bin/env python
# coding: utf-8

# In[49]:


result=0
first_number=1
number=int(input())

for x in range(0,17000000):
    last=first_number+x*6
    if(number<=last):
        result=x+1
        break
    first_number=last
    
print(result)


# In[ ]:




