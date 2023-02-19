#!/usr/bin/env python
# coding: utf-8

# In[26]:


sentance=input()
sentance=list(sentance.lstrip())
sentance.append(" ")

index=0
result=0

for a in sentance:
    if ord(a)>=65 and ord(a)<=123 and len(sentance)-1>index:
        if sentance[index+1] == " ":
            result=result+1
    
    index=index+1

print(result)

