class Solution {
    public int lengthOfLongestSubstring(String s) {
        // a b c a b c b b
        // 0 1 2 3 4 5 6 7
        // l=2, r=5
        int n = s.length();
        if (n <= 1)
            return n;
        
        Map<Character, Integer> hmap = new HashMap<>();
        int l=0, r=0, maxLen = 1;
        while (r < n){
            char c = s.charAt(r);
            if (hmap.containsKey(c)){
                int cPrevIndex = hmap.get(c);
                while (l <= cPrevIndex)
                    hmap.remove(s.charAt(l++));
            }
            hmap.put(c, r++);
            maxLen = Math.max(maxLen, r-l);
        }
        return maxLen;
    }
}