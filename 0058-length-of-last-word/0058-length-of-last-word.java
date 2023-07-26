class Solution {
    public int lengthOfLastWord(String s) {
        int m = s.length()-1;
        while (m >= 0){
            if (s.charAt(m) != ' ')
                break;
            m--;
        }
        

        int k = 0;
        while (m >= 0){
            if (s.charAt(m) == ' ')
                break;
            k++;
            m--;
        }
        
        return k;
    }
}