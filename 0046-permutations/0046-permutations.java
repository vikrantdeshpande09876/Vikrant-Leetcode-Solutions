class Solution {
    List<List<Integer>> res;
    
    public void backtrack(int[] nums, List<Integer> candidate, Set<Integer> visited){
        if (candidate.size() == nums.length){
            res.add(new ArrayList<Integer>(candidate));
            return;
        }
        
        for (int i=0; i<nums.length; i++){
            if (!visited.contains(i)){
                candidate.add(nums[i]);
                visited.add(i);
                backtrack(nums, candidate, visited);
                visited.remove(i);
                candidate.remove(candidate.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>(), new HashSet<>());
        return res;
    }
}