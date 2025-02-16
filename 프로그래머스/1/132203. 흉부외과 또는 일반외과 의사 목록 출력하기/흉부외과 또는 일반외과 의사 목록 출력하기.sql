-- 코드를 입력하세요
SELECT
    DR_NAME, -- 의사 이름
    DR_ID, -- 의사 ID
    MCDP_CD, -- 진료과
    DATE_FORMAT(HIRE_YMD,"%Y-%m-%d") AS HIRE_YMD -- 고용일자
FROM
    DOCTOR
WHERE 
    MCDP_CD IN ('CS', 'GS')
ORDER BY 
    HIRE_YMD DESC,
    DR_NAME ASC
    