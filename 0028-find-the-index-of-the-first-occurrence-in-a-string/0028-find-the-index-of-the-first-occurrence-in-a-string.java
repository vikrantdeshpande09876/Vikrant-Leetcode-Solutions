class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i=0; i<m-n+1; i++){
            int k = 0;
            while (k<n && haystack.charAt(i+k) == needle.charAt(k)){
                k++;
            }
            if (k == n)
                return i;
        }
        return -1;
    }
}