#!/usr/bin/env python
# coding: utf-8

# In[4]:


def factorial(n) :
    if n<1:
        return 1
    return n*factorial(n-1)

number=int(input())
result = factorial(number)
print(result)

