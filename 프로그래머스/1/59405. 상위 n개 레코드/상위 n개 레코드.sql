-- 가장 먼저 들어온 동물
-- 이름을 조회

SELECT *
FROM (SELECT NAME FROM ANIMAL_INS ORDER BY datetime)
WHERE ROWNUM = 1