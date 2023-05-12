class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        res.add(new ArrayList<>(curr));
        curr.clear();
        
        for (int i=2; i<=numRows; i++){
            curr.add(1);
            for (int k=1; k<i-1; k++)
                curr.add(res.get(res.size()-1).get(k-1) + res.get(res.size()-1).get(k));
            curr.add(1);
            res.add(new ArrayList<>(curr));
            
            curr.clear();
        }
        
        return res;
    }
}