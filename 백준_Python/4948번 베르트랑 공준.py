#!/usr/bin/env python
# coding: utf-8

# In[47]:


import math
#1. 소수를 구하는 함수
def isPrime(number):
    for i in range(2,int(math.sqrt(number))+1):
        #1은 소수가 아니다.
        if int(number)==1:
            return 0
        #합성수면 제거
        elif(number%i==0):
            return 0
    return number

#2.주어진 범위안 소수 찾기
matrix=list(range(2,123456*2))

#remove로 지우면 매트릭스 지운자리를 매우려고 뒤에 수들이 붙는 시간이 추가되기 때문에 그냥 새로운 리스트에 추가하는 것이 빠를 것 같다
prime_num=[]

isZero=0
for i in matrix:
    isZero=isPrime(i)
    if isZero!=0:
        prime_num.append(isZero)
        
number=1        
result=0
#3. 완성된 소수 매트릭스를 가지고 범위에 소수의 수를 세준다.
while(number!=0):
    number=int(input())
    for i in prime_num:
        #사이수를 넘어가면 멈춰라
        if 2*number<i:
            break
        # i==7 number==5 / 5<7<=10
        elif number<i and 2*number>=i:
            result=result+1
    if(number!=0):
        print(result)
    result=0

