#!/usr/bin/env python
# coding: utf-8

# In[21]:


alpha=input()
al_li=list(alpha)
order_li=[str(-1)]*100
number=0

for i in al_li:
    storage=ord(i)-97
    if order_li[storage]!='-1':
        number=number+1
        continue
    else:
        order_li[storage]=str(number)
        number=number+1
        
print(' '.join(order_li[0:26]))

