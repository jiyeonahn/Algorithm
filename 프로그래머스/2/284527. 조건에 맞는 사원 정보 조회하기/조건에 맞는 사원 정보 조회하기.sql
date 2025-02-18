SELECT 
    SUM(g.SCORE) AS SCORE,
    e.EMP_NO,
    e.EMP_NAME,
    e.POSITION,
    e.EMAIL
    FROM
        HR_EMPLOYEES e
    INNER JOIN
        HR_GRADE g ON e.EMP_NO = g.EMP_NO
    GROUP BY g.EMP_NO
    HAVING SCORE = 
    (SELECT 
        MAX(total_score)
    FROM 
        (SELECT 
            SUM(g.SCORE) AS total_score
        FROM
            HR_EMPLOYEES e
        INNER JOIN
            HR_GRADE g ON e.EMP_NO = g.EMP_NO
        GROUP BY g.EMP_NO) AS t)
