-- Python이나 C# 스킬
-- ID, 이메일, 이름, 성을 조회
-- ID를 기준으로 오름차순 정렬

SELECT DISTINCT dev.ID, dev.EMAIL, dev.FIRST_NAME, dev.LAST_NAME
FROM DEVELOPERS dev LEFT JOIN SKILLCODES skill ON skill.CODE & dev.SKILL_CODE
WHERE skill.NAME = 'Python' OR skill.NAME = 'C#'
ORDER BY ID