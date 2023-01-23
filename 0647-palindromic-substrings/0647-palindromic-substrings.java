class Solution {
    public int getNumSubstringsFromPos(String s, int l, int r, int count){
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count = 0;
        int l = 0, r = 0;
        for (int i=0; i<s.length(); i++){
            count = getNumSubstringsFromPos(s, i, i, count);
            count = getNumSubstringsFromPos(s, i, i+1, count);
        }
        return count;
    }
}