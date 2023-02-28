class Solution {
    public StringBuilder recSay(int n, StringBuilder cand){
        StringBuilder res = new StringBuilder("");

        if (n <= 1){
            res.append("1");
            return res;
        }
        
        StringBuilder x = recSay(n-1, cand);
        int counter = 0;
        char prev = x.charAt(0);
        
        for (int i=0; i<x.length(); i++){
            if (x.charAt(i) != prev){
                res.append(counter + "" + prev);
                prev = x.charAt(i);
                counter = 0;
            }
            counter++;
        }
        res.append(counter + "" + prev);
        return res;
    }
    
    public String countAndSay(int n) {
        return recSay(n, new StringBuilder("")).toString();
    }
}