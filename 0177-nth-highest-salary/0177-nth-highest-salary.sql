CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      WITH SAL_RANKS AS (
          SELECT DISTINCT 
                    E.SALARY,
                    DENSE_RANK() OVER (ORDER BY E.SALARY DESC) AS RNK
          FROM EMPLOYEE E
      )
      SELECT SR.SALARY
      FROM SAL_RANKS SR
      WHERE SR.RNK = N
  );
END