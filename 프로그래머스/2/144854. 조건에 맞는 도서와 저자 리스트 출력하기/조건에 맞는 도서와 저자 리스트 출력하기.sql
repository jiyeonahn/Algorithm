-- 코드를 입력하세요
SELECT 
    BOOK_ID,
    AUTHOR_NAME,
    DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
FROM
    BOOK b
INNER JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE
    CATEGORY = '경제'
ORDER BY PUBLISHED_DATE ASC