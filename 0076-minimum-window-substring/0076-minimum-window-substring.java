class Solution {
    int[] tMap = new int[52];
    
    public boolean isValidWindow(int[] windowMap){
        for (int i=0; i<52; i++){
            if (windowMap[i] < this.tMap[i])
                return false;
        }
        return true;
    }
    
    public int getIndexFromChar(char c){
        int index = c-'A'-6;
        if (c > 'Z')
            return index;
        return index+26;
    }
    
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        if (s.length() == 1)
            return t.charAt(0) == s.charAt(0) ? t : "";

        Deque<Integer> q = new ArrayDeque<>();
        int index;
        int[] wMap = new int[52];
        
        for (char c : t.toCharArray()){
            index = getIndexFromChar(c);
            this.tMap[index] = this.tMap[index] + 1;
        }
        
        int i=0, j=0;
        char cR, cL;
        for (; j < s.length(); j++){
            cR = s.charAt(j);
            index = getIndexFromChar(cR);
            if ( this.tMap[index] > 0 ){
                wMap[index] = wMap[index] + 1;
                break;
            }
        }
        i = j++;
        
        int minL=i, minR=i, minLen = Integer.MAX_VALUE;
        int prevJ = -1;
        
        while (j < s.length()){
            cR = s.charAt(j);
            index = getIndexFromChar(cR);
            if ( this.tMap[index] > 0 ){
                if (prevJ != j){
                    q.offer(j);
                    wMap[index] = wMap[index] + 1;
                }
                if (isValidWindow(wMap)){
                    if (minLen > j-i+1){
                        minL = i;
                        minR = j;
                        minLen = j-i+1;
                    }
                    cL = s.charAt(i);
                    index = getIndexFromChar(cL);
                    wMap[index] = wMap[index] - 1;
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