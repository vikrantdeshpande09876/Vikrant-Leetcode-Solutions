SELECT DISTINCT P.EMAIL
FROM PERSON P
GROUP BY P.EMAIL
HAVING COUNT(DISTINCT P.ID) > 1;