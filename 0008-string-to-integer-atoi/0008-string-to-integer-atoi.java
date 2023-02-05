class Solution {
    public int myAtoi(String s) {
        int i=0, k=0, res=0, n=s.length(), digit=0;
        while (i < n && s.charAt(i) == ' ')
            i++;
        if (i == n)
            return res;
        
        boolean negative = false;
        if (s.charAt(i) == '-' || s.charAt(i) == '+'){
            negative = (s.charAt(i) == '-');
            i++;
        }
        
        while (i < n){
            if (s.charAt(i)-'0' > 9 || s.charAt(i)-'0' < 0)
                break;
            digit = s.charAt(i)-'0';
            if (res > (Integer.MAX_VALUE - digit) / 10)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res*10 + digit;
            i++;
        }
        
        return (negative) ? -res : res;
    }
}