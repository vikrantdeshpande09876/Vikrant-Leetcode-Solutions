class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0)
            return true;
        
        int k = 0;
        for (int i=0; i<n; i++){
            if (t.charAt(i) == s.charAt(k))
                k++;
            if (k == m)
                return true;
        }
        return false;
    }
}