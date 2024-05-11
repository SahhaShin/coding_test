-- 흉부외과(CS)이거나 일반외과(GS)
-- 이름, 의사ID, 진료과, 고용일자 출력
-- 고용일자를 기준으로 내림차순 정렬, 이름을 기준으로 오름차순 정렬

SELECT DR_NAME, DR_ID, MCDP_CD, TO_CHAR(HIRE_YMD, 'YYYY-MM-DD') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME