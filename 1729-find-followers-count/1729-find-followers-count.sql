SELECT  F.USER_ID, COUNT(F.FOLLOWER_ID) FOLLOWERS_COUNT
FROM FOLLOWERS F
GROUP BY F.USER_ID
ORDER BY F.USER_ID;