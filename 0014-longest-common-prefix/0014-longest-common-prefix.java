class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder("");
        if (strs.length == 0)
            return res.toString();
        int k = 0;
        while (k < strs[0].length()){
            char c = strs[0].charAt(k);
            for (String x : strs){
                if (k == x.length() || x.charAt(k) != c)
                    return res.toString();
            }
            res.append(c);
            k++;
        }
        return res.toString();
    }
}