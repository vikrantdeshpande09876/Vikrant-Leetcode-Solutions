class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
            map.put(nums[i], i);
        
        for (int i=0; i<nums.length; i++){
            int n1 = nums[i];
            int n2 = target - n1;
            if (map.containsKey(n2) && map.get(n2)!=i)
                return new int[] {i, map.get(n2)};
        }
        return new int[2];
    }
}