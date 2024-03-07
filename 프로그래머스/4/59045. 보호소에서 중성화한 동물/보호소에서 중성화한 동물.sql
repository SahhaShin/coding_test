# 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물
# 아이디와 생물 종, 이름 출력
# 아이디 순 정렬

SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE like 'Intact%'
AND o.SEX_UPON_OUTCOME NOT like 'Intact%'
ORDER BY i.ANIMAL_ID;