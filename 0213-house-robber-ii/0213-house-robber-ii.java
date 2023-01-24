class Solution {
    public int accumulateRob(int[] nums, int i, int j){
        int currChosen = 0;
        int currSkipped = 0;
        for (int k=i; k<=j; k++){
            int temp = currSkipped;
            currSkipped = Math.max(currChosen, currSkipped);
            currChosen = temp + nums[k];
        }
        return Math.max(currSkipped, currChosen);
    }
    
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max( accumulateRob(nums, 0, nums.length-2) , accumulateRob(nums, 1, nums.length-1) );
    }
}