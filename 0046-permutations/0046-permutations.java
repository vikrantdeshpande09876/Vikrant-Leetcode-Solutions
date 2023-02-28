class Solution {
    List<List<Integer>> res;
    
    public void backtrack(int[] nums, List<Integer> candidate, int[] visited){
        if (candidate.size() == nums.length){
            res.add(new ArrayList<Integer>(candidate));
            return;
        }
        
        for (int n : nums){
            if (visited[n+10] == 0){
                candidate.add(n);
                visited[n+10] = 1;
                backtrack(nums, candidate, visited);
                visited[n+10] = 0;
                candidate.remove(candidate.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>(), new int[21]);
        return res;
    }
}