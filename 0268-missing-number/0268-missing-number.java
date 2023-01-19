class Solution {
    public int missingNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i=0; i<nums.length; i++){
            a ^= i;
            b ^= nums[i];
        }
        a ^= nums.length;
        // System.out.println(a+" , "+b+" , "+(a^b));
        return a^b;
    }
}