class Solution {
    public double recPow(double x, int n){
        if (n == 0 || x == 1)   return 1;
        if (n == 1)             return x;
        
        if (n%2 == 0)
            return recPow(x * x, n/2);
        return x * recPow(x * x, n/2);
    }
    public double myPow(double x, int n) {
        if (n < 0)              return 1 / recPow(x, -n);
        return recPow(x, n);
    }
}