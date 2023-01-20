class Solution {
    public boolean isValidWindow(int[] hmap, int k, int totalChars){
        int maxFreq = 0;
        for (int cnt : hmap)
            maxFreq = Math.max(maxFreq, cnt);
        return (totalChars-maxFreq) <= k;
    }
    
    public int characterReplacement(String s, int k) {
        int maxWindow = 1;
        if (s.length()==1)
            return maxWindow;
        
        int r = 1, l = 0;
        int[] hmap = new int[26];
        hmap[s.charAt(l)-'A'] = 1;
        hmap[s.charAt(r)-'A'] = hmap[s.charAt(r)-'A'] + 1;
        while (r < s.length()-1){
            if (isValidWindow(hmap, k, r-l+1)){
                maxWindow = Math.max(maxWindow, r-l+1);
                r++;
                hmap[s.charAt(r)-'A'] = hmap[s.charAt(r)-'A'] + 1;
            }
            else {
                hmap[s.charAt(l)-'A'] = hmap[s.charAt(l)-'A'] - 1;
                l++;
            }
        }
        if ((r == s.length()-1) && (isValidWindow(hmap, k, r-l+1)))
            maxWindow = Math.max(maxWindow, r-l+1);
        return maxWindow;
    }
}