-- 12세 이하
-- 여자환자
-- 환자이름, 환자번호, 성별코드, 나이, 전화번호 출력
-- 전화번호가 없는 경우 'NONE'
-- 나이 기준 내림차순 정렬, 환자이름 기준 오름차순 정렬

SELECT PT_NAME, PT_NO, GEND_CD, AGE, 
CASE 
    WHEN TLNO IS NULL THEN 'NONE'
    ELSE TLNO
END AS TLNO
FROM PATIENT
WHERE AGE <= 12
AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME;