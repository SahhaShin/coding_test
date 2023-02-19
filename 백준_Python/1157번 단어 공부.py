#!/usr/bin/env python
# coding: utf-8

# In[55]:


sentence=input()
number=[0]*26
list(sentence)
same=0
max_index=0
for a in sentence:
    index=ord(a.upper())-65
    number[index]=number[index]+1
   

index=0
for b in number:
    if b<number[max_index]:
        index=index+1
        continue
    elif b>number[max_index]:
        max_index=index
        same=1
        
    elif b==number[max_index]:
        max_index=index
        same=same+1
    index=index+1
    
    
if same>1:
    print("?")
else:
    print(chr(max_index+65))

