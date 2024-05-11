-- 2022년 10월에 작성된 게시글
-- 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 출력
-- 댓글 작성일을 기준으로 오름차순 정렬, 게시글 제목을 기준으로 오름차순 정렬

SELECT org.TITLE, org.BOARD_ID, reply.REPLY_ID, reply.WRITER_ID, reply.CONTENTS
,TO_CHAR(reply.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD org JOIN USED_GOODS_REPLY reply
ON org.BOARD_ID = reply.BOARD_ID
WHERE EXTRACT(YEAR FROM org.CREATED_DATE) = 2022
AND EXTRACT(MONTH FROM org.CREATED_DATE) = 10
ORDER BY reply.CREATED_DATE, org.TITLE