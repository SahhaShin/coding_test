#!/usr/bin/env python
# coding: utf-8

# In[14]:


apartment=[[0]*1000 for _ in range (1000)]
test_case=int(input())
for test in range(0, test_case):
    k_floor=int(input())
    n_ho=int(input())
    for floor in range(0, k_floor+1):
        for ho in range(0, n_ho+1):
            if(floor==0):
                apartment[floor][ho]=ho
            else:
                for i in range(0,ho+1):
                    apartment[floor][ho]=apartment[floor][ho]+apartment[floor-1][i]
                    
    print(apartment[k_floor][n_ho])
    apartment=[[0]*1000 for _ in range (1000)]

