class Solution {
    public int[] hmap = new int[46];
    
    public int dfs(int n, int numWays){
        if (n == 0)
            return numWays+1;
        
        int res = 0;
        if (hmap[n-1] == 0)
            hmap[n-1] += dfs(n-1, numWays);
        res += hmap[n-1];
        if (n-1 > 0){
            if (hmap[n-2] == 0)
                hmap[n-2] += dfs(n-2, numWays);
            res += hmap[n-2];
        }
        hmap[n] = res;
        return res;
    }
    
    public int climbStairs(int n) {
        return dfs(n, 0);
    }
}