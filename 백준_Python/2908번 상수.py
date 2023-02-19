#!/usr/bin/env python
# coding: utf-8

# In[32]:


result = 0

number1,number2=input().split(' ')
number1_c=int(number1)
number2_c=int(number2)

#수를 거꾸로 만들어 주자
for i in range(0,3):
    if number1_c%10 > number2_c%10:
        result = number1
        break;
    elif number1_c%10 < number2_c%10:
        result = number2
        break;
    else :
        result=number1
        number1_c=int(number1_c/10)
        number2_c=int(number2_c/10)
        continue
    
    
print(result[::-1])

