class Solution {
    Map<Character,Integer> tMap = new HashMap<>();
    
    public boolean isValidWindow(Map<Character,Integer> windowMap){
        for (char key : this.tMap.keySet()){
            if (windowMap.getOrDefault(key, 0) < this.tMap.get(key))
                return false;
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        if (s.length() == 1)
            return t.charAt(0) == s.charAt(0) ? t : "";

        Deque<Integer> q = new ArrayDeque<>();
        Map<Character,Integer> wMap = new HashMap<>();
        
        for (char c : t.toCharArray())
            this.tMap.put(c, this.tMap.getOrDefault(c,0) + 1);
        
        int i=0, j=0;
        char cR, cL;
        for (; j < s.length(); j++){
            cR = s.charAt(j);
            if ( this.tMap.containsKey(cR) ){
                wMap.put(cR, wMap.getOrDefault(cR, 0) + 1);
                break;
            }
        }
        i = j++;
        int minL=i, minR=i, minLen = Integer.MAX_VALUE;
        
        int prevJ = -1;
        while (j < s.length()){
            cR = s.charAt(j);
            if ( this.tMap.containsKey( cR ) ){
                if (prevJ != j){
                    q.offer(j);
                    wMap.put(cR, wMap.getOrDefault(cR, 0) + 1);
                }
                if (isValidWindow(wMap)){
                    if (minLen > j-i+1){
                        minL = i;
                        minR = j;
                        minLen = j-i+1;
                    }
                    cL = s.charAt(i);
                    wMap.put(cL, wMap.getOrDefault(cL, 0) - 1);
                    i = q.poll();
                    prevJ = j--;
                }
            }
            j++;
        }
        
        if ((minL == minR) && !isValidWindow(wMap))
            return "";
        return s.substring(minL, Math.min(minR+1, s.length()));
    }
}