-- 코드를 작성해주세요
SELECT
    HE.EMP_NO,
    HE.EMP_NAME,
    CASE
        WHEN SUM(HG.SCORE) / 2 >= 96 THEN 'S'
        WHEN SUM(HG.SCORE) / 2 >= 90 THEN 'A'
        WHEN SUM(HG.SCORE) / 2 >= 80 THEN 'B'
    ELSE 'C'
    END GRADE,
    CASE
        WHEN SUM(HG.SCORE) / 2 >= 96 THEN HE.SAL * 0.2
        WHEN SUM(HG.SCORE) / 2 >= 90 THEN HE.SAL * 0.15
        WHEN SUM(HG.SCORE) / 2 >= 80 THEN HE.SAL * 0.1
    ELSE 0
    END BONUS
FROM
    HR_EMPLOYEES HE INNER JOIN HR_GRADE HG ON HE.EMP_NO = HG.EMP_NO
GROUP BY
    EMP_NO
ORDER BY
    EMP_NO ASC
    