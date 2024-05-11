-- 젊은 동물(Aged X)의 아이디와 이름을 조회
-- 결과는 아이디 순으로 조회

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID