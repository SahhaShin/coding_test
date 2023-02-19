#!/usr/bin/env python
# coding: utf-8

# In[2]:


result_min=10001 # 소수 중 최소값
prime_sum=0 # 소수들의 합
flag=0 # 소수면 0 합성수면 1
min=int(input())
max=int(input())

for i in range(min,max+1):
    for j in range(2,i):
        #2~자신의값-1으로 나눴을 때 나눠지면 합성수임
        if(i%j==0):
            flag=1
            break
            
    if flag==1 or i==1:
        flag=0
    else:
        prime_sum=prime_sum+i
        if result_min>i:
            result_min=i
            
if prime_sum==0:
    print("-1")
    
else:
    print(prime_sum)
    print(result_min)

