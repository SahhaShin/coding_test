-- 아이디, 이름, 보호 시작일 출력
-- 이름 순, 보호를 나중에 시작한 동물을 먼저 보여줘야 합니다.

SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC