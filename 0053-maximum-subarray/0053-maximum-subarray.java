class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums){
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}
/*
-2 , 1 , -3 , 4 , -1 , 2 , 1 , -5 , 4
0 , -2 , -1, -4 ,  0 ,-1 , 1 ,  2 , -3
3 ,  2 ,  5,  1 ,  2 , 0 , -1,  4 , 0

*/