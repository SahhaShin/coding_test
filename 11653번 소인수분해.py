#!/usr/bin/env python
# coding: utf-8

# In[15]:


nanum=2 #number을 nanum으로 나눌 것임 2~number-1까지
number=int(input())
number_copy=number

while(number!=1):
   
    #소수가 들어온 경우는 nanum이 number-1이 될 때까지 돌려서 나누어 떨어지는 것이 없으면 걍 출력한다.
    # number-1이 될 때까지 나눠지지 않으면 nanum에 +1이 되기 때문에 number==nanum이 된다.
    if (nanum==number_copy and number_copy==number):
        print(number_copy)
        break
        
    elif(number%nanum==0):
        print(nanum)
        number=number//nanum
    #나눠지지 않으면 nanum을 1 더해준다.
    else:
        nanum=nanum+1
        

