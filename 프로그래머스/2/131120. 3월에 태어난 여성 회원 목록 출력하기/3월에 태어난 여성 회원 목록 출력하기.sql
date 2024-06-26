-- 생일 3월
-- 여성 회원
-- ID, 이름, 성별, 생년월일을 조회
-- 전화번호가 NULL인 경우는 출력대상에서 제외
-- 회원ID를 기준으로 오름차순 정렬

SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE EXTRACT(MONTH FROM DATE_OF_BIRTH) = 3
AND gender = 'W'
AND TLNO IS NOT NULL
ORDER BY MEMBER_ID