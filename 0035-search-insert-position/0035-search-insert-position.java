class Solution {
    public int binSearchLeftMost(int[] nums, int x, int l, int r){
        while (l <= r){
            int mid = (int) (l+r)/2;
            if (nums[mid] == x)
                return mid;
            if (nums[mid] < x)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }
    
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target)
            return 0;
        if (nums[nums.length-1] < target)
            return nums.length;
        return binSearchLeftMost(nums, target, 0, nums.length-1);
    }
}