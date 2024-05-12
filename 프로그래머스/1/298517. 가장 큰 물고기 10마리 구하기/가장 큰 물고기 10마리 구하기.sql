-- 가장 큰 물고기 10마리
-- ID, 길이를 출력
-- 길이를 기준으로 내림차순 정렬, ID에 대해 오름차순 정렬
-- 가장 큰 물고기 10마리 중 길이가 10cm 이하인 경우는 없습니다.

SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH IS NOT NULL
ORDER BY LENGTH DESC, ID
LIMIT 10
