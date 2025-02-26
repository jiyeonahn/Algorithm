-- 코드를 입력하세요
SELECT
    CONCAT('/home/grep/src/',UGF.BOARD_ID,'/',FILE_ID,FILE_NAME,FILE_EXT) AS FILE_PATH
FROM
    USED_GOODS_BOARD UGB
    INNER JOIN 
    USED_GOODS_FILE UGF 
    ON UGB.BOARD_ID = UGF.BOARD_ID
WHERE
    UGB.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY
    UGF.FILE_ID DESC