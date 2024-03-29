SELECT PRODUCT_CODE, SUM(sales_amount)*price as SALES
FROM PRODUCT pro JOIN OFFLINE_SALE off ON pro.PRODUCT_ID = off.PRODUCT_ID
GROUP BY pro.product_id
ORDER BY SUM(sales_amount)*price DESC, PRODUCT_CODE ASC;