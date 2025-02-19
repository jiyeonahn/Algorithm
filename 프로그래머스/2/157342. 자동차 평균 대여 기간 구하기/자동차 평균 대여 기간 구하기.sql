-- 코드를 입력하세요
SELECT
    CAR_ID,
    ROUND(SUM(TIMESTAMPDIFF(DAY, START_DATE, END_DATE)+1)/COUNT(CAR_ID),1) AS AVERAGE_DURATION
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC