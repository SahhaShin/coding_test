-- BASS와 SNAPPER의 수를 출력
-- 컬럼명은 'FISH_COUNT`

SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO info JOIN FISH_NAME_INFO name ON info.FISH_TYPE = name.FISH_TYPE
WHERE name.FISH_NAME = 'BASS' OR name.FISH_NAME = 'SNAPPER'