class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        int[] res = new int[3];
        int l, r;
        for (int i=0; i<n-1; i++){
            l = i;
            r = i;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if (res[0] < r-l+1){
                    res[0] = r-l+1;
                    res[1] = l;
                    res[2] = r;
                }
                l--;
                r++;
            }
            
            l = i;
            r = (s.charAt(l)==s.charAt(l+1)) ? i+1 : i;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if (res[0] < r-l+1){
                    res[0] = r-l+1;
                    res[1] = l;
                    res[2] = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(res[1], res[2]+1);
    }
}