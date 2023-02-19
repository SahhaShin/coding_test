#!/usr/bin/env python
# coding: utf-8

# In[24]:


do=1 #1+2+3+4+5... 1씩 증가하면 더해주는 걸 저장하는 변수
row=0
col=0
number=int(input())

for first in range(0,10000):
    do=do+first #first는 1,2,3,4...1씩 증가
    
    
    #앞의 첫수보다는 크거나 같아야하며 뒤의 첫수보다는 작아야한다. (뒤의 첫수라는 제어값 없으면 다 들어와서 돌아가기 때문에 시간 오래 걸린다.)
    if((number>=do) and (number<do+first+1)):
        #첫수보다 얼마나 큰가?
        gap=number-do
        
        #짝수일 경우 (+gap -gap)
        if((first+1)%2==0):
            row=1+gap
            col=(first+1)-gap
            break
            
        #홀수일 경우 (-gap +gap)
        else:
            row=(first+1)-gap
            col=1+gap
            break

print(f'{row}/{col}')
            
            
    

