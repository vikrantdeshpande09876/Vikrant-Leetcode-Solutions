class Solution {
    public int[] hmap = new int[46];
    
    public int climbStairs(int n) {
        if (n == 0)
            return 1;
        
        if (hmap[n-1] == 0)
            hmap[n-1] += climbStairs(n-1);

        hmap[n] += hmap[n-1];
        
        if (n-1 > 0){
            if (hmap[n-2] == 0)
                hmap[n-2] += climbStairs(n-2);
            hmap[n] += hmap[n-2];
        }
        
        return hmap[n];
    }
}