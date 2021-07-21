#!/usr/bin/env python
# coding: utf-8

# In[2]:


#prime을 판별하는 함수
def isPrime(n) : 
    for i in range(2, int(n**0.5)+1):
        if(n%i==0):
            return 0
    return n


#골드바흐의 추측 : 두 소수의 합으로 2보다 큰 짝수를 만들어 낼 수 있다.

#10000까지의 소수를 정리한다.
hundred=list(range(2,10001))
prime=[]

for n in hundred:
    result=isPrime(n)
    if(result!=0):
        prime.append(n)

    
test_case = int(input())

for i in range(0,test_case):
    number=int(input())
    half=number//2
    for j in range(half,1,-1):
        #두 수가 소수인지 체크한다.
        if (j in prime) and (number-j in prime):
            print(f'{j} {number-j}')
            break

