class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> resSet = new HashSet<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i=0; i<nums.length-3; i++){
            for (int j=i+1; j<nums.length-2; j++){
                int k=j+1, l=nums.length-1;
                while (k<l){
                    if ((long) nums[i] + nums[j] + nums[k] + nums[l] == (long) target){
                        // System.out.println(nums[i] +" "+ nums[j] +" "+ nums[k] +" "+ nums[l]);
                        List<Integer> quadruplet = List.of(nums[i],nums[j],nums[k],nums[l]);
                        if (!resSet.contains(quadruplet)){
                            resSet.add(quadruplet);
                            res.add(quadruplet);
                        }
                    }
                    if ((long) nums[i] + nums[j] + nums[k] + nums[l] > (long) target)
                        l--;
                    else
                        k++;
                }
            }
        }
        return res;
    }
}