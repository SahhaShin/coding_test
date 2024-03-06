# 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
# 회원 이름(MEMBER_NAME), 리뷰 텍스트(REVIEW_TEXT), 리뷰 작성일(REVIEW_DATE)이 출력
# 리뷰 작성일(REVIEW_DATE) 오름차순, 리뷰 텍스트(REVIEW_TEXT) 오름차순


# 1. MAX 리뷰 수 출력하는 서브쿼리 (GROUP BY 사용)
# SELECT COUNT(r.REVIEW_ID) AS C
# FROM REST_REVIEW r
# GROUP BY r.MEMBER_ID
# ORDER BY COUNT(r.REVIEW_ID) DESC
# LIMIT 1;

# 2. MAX 리뷰 수 출력하는 서브쿼리 (OVER, PARTITION BY 사용)
# SELECT COUNT(r.REVIEW_ID) OVER(PARTITION BY r.MEMBER_ID) AS C
# FROM REST_REVIEW r
# ORDER BY C DESC
# LIMIT 1

# 2. 가장 리뷰수가 많은 회원 ID 출력
# SELECT r.MEMBER_ID
# FROM REST_REVIEW r JOIN MEMBER_PROFILE m ON r.MEMBER_ID = m.MEMBER_ID
# GROUP BY r.MEMBER_ID
# HAVING COUNT(r.REVIEW_ID) = 3
# ORDER BY m.MEMBER_NAME;

# 결과
SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW r JOIN MEMBER_PROFILE m ON r.MEMBER_ID = m.MEMBER_ID
WHERE r.MEMBER_ID IN (
    SELECT r.MEMBER_ID
    FROM REST_REVIEW r JOIN MEMBER_PROFILE m ON r.MEMBER_ID = m.MEMBER_ID
    GROUP BY r.MEMBER_ID
    HAVING COUNT(r.REVIEW_ID) = (
        SELECT COUNT(r.REVIEW_ID) OVER(PARTITION BY r.MEMBER_ID) AS C
        FROM REST_REVIEW r
        ORDER BY C DESC
        LIMIT 1
    )
)
ORDER BY r.REVIEW_DATE, r.REVIEW_TEXT;