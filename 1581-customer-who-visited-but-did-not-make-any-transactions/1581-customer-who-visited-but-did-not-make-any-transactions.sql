SELECT V.CUSTOMER_ID, COUNT(V.VISIT_ID) COUNT_NO_TRANS
FROM VISITS V
WHERE V.VISIT_ID NOT IN (
    SELECT T.VISIT_ID
    FROM TRANSACTIONS T
)
GROUP BY V.CUSTOMER_ID;