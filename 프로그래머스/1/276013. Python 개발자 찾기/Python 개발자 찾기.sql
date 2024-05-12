-- Python 스킬을 가진 개발자
-- ID, 이메일, 이름, 성을 조회
-- ID를 기준으로 오름차순 정렬

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 = 'Python' OR SKILL_2 = 'Python' OR SKILL_3 = 'Python'
ORDER BY ID