-- 코드를 입력하세요
# SELECT A.NAME, A.DATETIME
# FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B USING(ANIMAL_ID)
# WHERE B.DATETIME IS NULL
# ORDER BY A.DATETIME
# LIMIT 3;

SELECT i.NAME, i.DATETIME
FROM ANIMAL_INS i LEFT JOIN ANIMAL_OUTS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.ANIMAL_ID IS NULL
ORDER BY i.DATETIME
LIMIT 3;