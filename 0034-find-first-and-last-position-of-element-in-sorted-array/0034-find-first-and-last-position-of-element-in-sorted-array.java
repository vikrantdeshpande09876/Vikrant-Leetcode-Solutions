class Solution {
    public int binSearchLeftmost(int[] nums, int x, int l, int r){
        while (l < r){
            int mid = (int) (l+r)/2;
            if (nums[mid] == x)
                r = mid;
            else if (nums[mid] < x)
                l = mid+1;
            else
                r = mid-1;
        }
        return r<0 || nums[r]!=x ? -1 : r;
    }
    
    public int binSearchRightmost(int[] nums, int x, int l, int r){
        while (l < r){
            int mid = (int) (l+r)/2;
            mid++;
            if (nums[mid] == x)
                l = mid;
            else if (nums[mid] < x)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0)
            return new int[] {-1,-1};
        if (nums.length==1)
            return nums[0] == target ? new int[] {0,0} : new int[] {-1,-1};
        
        int leftmost = binSearchLeftmost(nums, target, 0, nums.length-1);
        if (leftmost == -1)
            return new int[] {-1,-1};
        
        int rightmost = binSearchRightmost(nums, target, leftmost, nums.length-1);
        return new int[] {leftmost, rightmost};
    }
}