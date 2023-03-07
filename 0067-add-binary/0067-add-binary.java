class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int i = m-1, j = n-1, carry = 0;
        StringBuilder res = new StringBuilder("");
        
        while (i >= 0 && j >= 0){
            if (a.charAt(i) == b.charAt(j)){
                res.append(carry == 1 ? '1' : '0');
                carry = a.charAt(i)=='1' ? 1 : 0;
            }
            else {
                res.append(carry == 1 ? '0' : '1');
            }
            i--;
            j--;
        }
        
        while (i >= 0){
            if (a.charAt(i)=='1')
                res.append(carry == 1 ? '0' : '1');
            else{
                res.append(carry == 1 ? '1' : '0');
                carry = 0;
            }
            i--;
        }
        
        while (j >= 0){
            if (b.charAt(j)=='1')
                res.append(carry == 1 ? '0' : '1');
            else{
                res.append(carry == 1 ? '1' : '0');
                carry = 0;
            }
            j--;
        }
        if (carry==1)
            res.append('1');
        
        return res.reverse().toString();
    }
}