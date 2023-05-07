class Solution {
    public int numTrees(int n) {
        int[] dp = new int[20];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i=2; i<=n; i++){
            for (int currRoot=1; currRoot<=i; currRoot++){
                dp[i] += dp[i-currRoot] * dp[currRoot-1];
            }
        }
        return dp[n];
    }
}