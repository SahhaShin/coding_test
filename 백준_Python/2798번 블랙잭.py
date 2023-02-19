#!/usr/bin/env python
# coding: utf-8

# In[4]:


card_number,max_number=input().split(' ')
card=list(map(int,input().split(' ')))
result=[]

for i in range(0,int(card_number)):
    for j in range(i+1, int(card_number)):
        for k in range(j+1, int(card_number)):
            if card[i]+card[j]+card[k]<=int(max_number):
                result.append(card[i]+card[j]+card[k])
print(max(result))   

