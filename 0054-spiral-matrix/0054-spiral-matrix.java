class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        
        int left=0, right=0, top=0, bottom=0;
        List<Integer> res = new ArrayList<>();
        
        while (res.size() < m*n){
            // move left  -> n-right , change cols
            for (int j=left; j<n-right; j++)
                res.add(matrix[top][j]);
            top++;

            // move top   -> m-bottom , change rows
            for (int i=top; i<m-bottom; i++)
                res.add(matrix[i][n-1-right]);
            right++;
            
            if (res.size() == m*n)
                break;
            
            // move n-right-1 -> left , change cols
            for (int j=n-1-right; j>=left; j--)
                res.add(matrix[m-1-bottom][j]);
            bottom++;

            // move m-bottom-1 -> top , change rows
            for (int i=m-1-bottom; i>=top; i--)
                res.add(matrix[i][left]);
            left++;
        }
        
        return res;
    }
}