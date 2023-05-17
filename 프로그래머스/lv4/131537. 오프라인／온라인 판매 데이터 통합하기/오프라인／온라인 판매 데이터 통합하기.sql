-- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE MONTH(SALES_DATE)=3

UNION ALL

SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS SALES_DATE, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE MONTH(SALES_DATE)=3
ORDER BY SALES_DATE,PRODUCT_ID,USER_ID;
