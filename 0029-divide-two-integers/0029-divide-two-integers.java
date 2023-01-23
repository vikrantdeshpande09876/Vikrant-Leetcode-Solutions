class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (dividend == divisor)
            return 1;
        
        boolean negateResult = false;
        if (divisor<0 || dividend<0)
            negateResult = !(divisor<0 && dividend<0);
        long lDivisor = Math.abs((long) divisor);
        long lDividend = Math.abs((long) dividend);
        
        long quotient = 0;
        while (lDividend >= lDivisor){
            int numShifts = 0;
            while (lDividend > (lDivisor << numShifts+1))
                numShifts++;
            
            lDividend -= (lDivisor << numShifts);
            quotient += (1 << numShifts);
        }
        return (int) (negateResult ? Math.max(Integer.MIN_VALUE, -quotient) : Math.min(Integer.MAX_VALUE, quotient));
    }
}