class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i=n-1; i>=0; i--){
            if (digits[i] < 9){
                digits[i] += carry;
                carry = 0;
            }
            else{
                if (carry==1)
                    digits[i] = 0;
            }
        }
        
        if (carry == 0)
            return digits;
        
        int[] res = new int[n+1];
        res[0] = 1;
        for (int i=0; i<n; i++)
            res[i+1] = digits[i];
        return res;
    }
}
/*
9876543210 , 1
 987654311
*/