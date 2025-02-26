-- 코드를 작성해주세요
SELECT
    A.ID,
    C.FISH_NAME,
    A.LENGTH
FROM
    FISH_INFO A,
    (
        SELECT
            FISH_TYPE,
            MAX(LENGTH) AS LENGTH
        FROM
            FISH_INFO
        GROUP BY 
            FISH_TYPE
    ) B,
    FISH_NAME_INFO C
WHERE
    A.FISH_TYPE = B.FISH_TYPE AND
    A.LENGTH = B.LENGTH AND
    A.FISH_TYPE = C.FISH_TYPE
ORDER BY
    A.ID ASC