#!/usr/bin/env python
# coding: utf-8

# In[18]:


test_case=int(input())

for i in range(0,test_case):
    H,W,N=input().split(' ')
    #나눠 떨어질 경우
    if(int(N)%int(H)==0):
        xx=H
        if int(N)//int(H) >= 10:
            yy=str(int(N)//int(H))
        else:
            yy='0'+str(int(N)//int(H))
    else:
        xx=str(int(N)%int(H))
        if int(N)//int(H)+1 >= 10:
            yy=str(int(N)//int(H)+1)
        else:
            yy = '0'+str(int(N)//int(H)+1)
    print(xx+yy)

