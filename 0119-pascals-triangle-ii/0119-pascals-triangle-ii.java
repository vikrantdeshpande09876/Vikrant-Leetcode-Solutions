class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        
        for (int i=1; i<=rowIndex; i++){
            List<Integer> prev = new ArrayList<>(res);
            res.clear();
            res.add(1);
            for (int j=1; j<i; j++){
                res.add(prev.get(j-1) + prev.get(j));
            }
            res.add(1);
        }
        
        return res;
    }
}