-- 총주문량이 3,000보다 높음
-- 주 성분이 과일(fruit_based)
-- 아이스크림의 맛을 총주문량이 큰 순서대로 조회

SELECT DISTINCT sale.FLAVOR
FROM FIRST_HALF sale JOIN ICECREAM_INFO info ON sale.FLAVOR = info.FLAVOR
WHERE INGREDIENT_TYPE = 'fruit_based'
AND TOTAL_ORDER > 3000
ORDER BY TOTAL_ORDER DESC