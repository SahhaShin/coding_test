#!/usr/bin/env python
# coding: utf-8

# In[17]:


result=0
flag=0
no=0

number=int(input())

for i in range (0,number):
    sentence=input()
    for i in sentence:
        each=sentence.count(i)
        #해당 알파벳이 1개이면 다음으로 빨리 넘어간다.
        if each==1:
            continue
        else:
            #처음 위치 찾기
            flag=sentence.find(i)
            
            
            #갯수만큼 붙어있는지 확인
            for j in range(1,each):
                if sentence[flag+j]!=i:
                    no=1
                    break;
                else:
                    continue;
    if no==1:
        no=0
        
    else:
        result=result+1
        no=0
           
        
print(result)

