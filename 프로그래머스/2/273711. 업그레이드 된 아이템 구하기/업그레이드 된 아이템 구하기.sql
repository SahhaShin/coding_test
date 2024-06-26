-- 희귀도가 'RARE'
-- 다음 업그레이드 아이템의 ITEM_ID, ITEM_NAME, RARITY를 출력
-- 아이템 ID를 기준으로 내림차순 정렬

SELECT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I JOIN ITEM_TREE T ON I.ITEM_ID = T.ITEM_ID
                 JOIN ITEM_INFO I_2 ON T.PARENT_ITEM_ID = I_2.ITEM_ID
WHERE I_2.RARITY = 'RARE' 
ORDER BY I.ITEM_ID DESC