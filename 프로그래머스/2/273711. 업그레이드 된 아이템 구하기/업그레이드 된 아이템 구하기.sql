-- 코드를 작성해주세요
SELECT 
    B.ITEM_ID,
    C.ITEM_NAME,
    C.RARITY
FROM
    ITEM_INFO A,
    ITEM_TREE B,
    ITEM_INFO C
WHERE A.ITEM_ID = B.PARENT_ITEM_ID AND A.RARITY = 'RARE' AND C.ITEM_ID = B.ITEM_ID
ORDER BY 
    B.ITEM_ID DESC