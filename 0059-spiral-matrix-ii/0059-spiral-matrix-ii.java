class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top=0, bottom=0, right=0, left=0;
        int k=1;
        
        while (k <= n*n){
            for (int j=left; j<n-right; j++){       // left -> right
                // System.out.println(k+" , "+left+","+j);
                res[top][j] = k;
                k++;
            }
            top++;
            
            if (k == n*n)
                break;
            
            for (int i=top; i<n-bottom; i++){       // top -> bottom
                // System.out.println(k+" , "+i+","+right);
                res[i][n-1-right] = k;
                k++;
            }
            right++;
            
            for (int j=n-1-right; j>=left; j--){       // right -> left
                // System.out.println(k+" , "+bottom+","+j);
                res[n-1-bottom][j] = k;
                k++;
            }
            bottom++;
            
            for (int i=n-1-bottom; i>=top; i--){       // bottom -> top
                // System.out.println(k+" , "+i+","+left);
                res[i][left] = k;
                k++;
            }
            left++;
        }
        
        return res;
    }
}