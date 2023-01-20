class Solution {
    public boolean isValidWindow(Map<Character,Integer> hmap, int k, int totalChars){
        int maxFreq = 0;
        for (Character c : hmap.keySet())
            maxFreq = Math.max(maxFreq, hmap.get(c));
        return (totalChars-maxFreq) <= k;
    }
    
    public int characterReplacement(String s, int k) {
        int maxWindow = 1;
        if (s.length()==1)
            return maxWindow;
        
        int r = 1, l = 0;
        Map<Character,Integer> hmap = new HashMap<>();
        hmap.put(s.charAt(l), 1);
        hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r), 0)+1);
        while (r < s.length()-1){
            if (isValidWindow(hmap, k, r-l+1)){
                maxWindow = Math.max(maxWindow, r-l+1);
                r++;
                hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r), 0)+1);
                // System.out.println(l+" , "+r+" , "+(r-l+1));
            }
            else {
                hmap.put(s.charAt(l), hmap.get(s.charAt(l))-1);
                if (hmap.get(s.charAt(l)) <= 0)
                    hmap.remove(s.charAt(l));
                l++;
            }
        }
        if ((r == s.length()-1) && (isValidWindow(hmap, k, r-l+1)))
            maxWindow = Math.max(maxWindow, r-l+1);
        return maxWindow;
    }
}