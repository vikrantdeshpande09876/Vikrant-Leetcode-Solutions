class Solution {
    public int missingNumber(int[] nums) {
        // Find cumulative expected sum: n*(n+1)/2
        // iterate over nums and subtract each num from sum
        int n = nums.length;
        int sum = (int) n*(n+1)/2;
        for (int i = 0; i < n; i++)
            sum -= nums[i];
        return sum;
    }
}