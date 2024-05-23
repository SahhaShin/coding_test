-- 부모의 형질을 모두 보유
-- ID, GENOTYPE, PARENT_GENOTYPE 출력
-- ID에 대해 오름차순

SELECT child.ID, child.GENOTYPE, parent.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA child JOIN ECOLI_DATA parent ON child.PARENT_ID = parent.ID
WHERE child.GENOTYPE | parent.GENOTYPE = child.GENOTYPE
ORDER BY child.ID
