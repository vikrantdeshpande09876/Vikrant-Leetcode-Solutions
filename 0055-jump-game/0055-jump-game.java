class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex=0, currJump=0, n=nums.length;
        if (n==1)
            return true;
        
        for (int i=0; i<n; i++){
            currJump = Math.max(currJump, nums[i]+i);
            maxIndex = Math.max(maxIndex, currJump);
            
            if (maxIndex >= n-1)
                return true;
            
            if (i >= maxIndex)
                break;
        }
        return false;
    }
}

/*
2 3 0 1 4
i        = 1
currJump = max(3,3+1)
maxIndex = max(0,2) = 2

*/