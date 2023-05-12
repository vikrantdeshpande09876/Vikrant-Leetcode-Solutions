class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minValBuy = Integer.MAX_VALUE;
        int maxValSell = 0;
        for (int i=0; i<n; i++){
            if (prices[i] < minValBuy)
                minValBuy = prices[i];
            if (maxValSell < prices[i] - minValBuy)
                maxValSell = prices[i] - minValBuy;
        }
        
        return maxValSell;
    }
}