result=0
word=0
cro=["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
sentence=input()
for i in cro:
    if i == "z=":
        result=result+sentence.count(i)-sentence.count("dz=")
        word=word+len(i)*(sentence.count(i)-sentence.count("dz="))
        
    else:
        result=result+sentence.count(i)
        word=word+len(i)*sentence.count(i)
        
print(result+len(sentence)-word)