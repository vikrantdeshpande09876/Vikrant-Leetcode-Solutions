class Solution {
    public int binSearchRow(int[][] arr, int x, int colToSearch){
        int m = arr.length;
        if (arr[m-1][colToSearch] < x)
            return -1;
        if (arr[0][colToSearch] >= x)
            return 0;
        
        int l = 0, r = m-1;
        while (l <= r){
            int mid = (int) (l+r)/2;
            if (mid >= 1 && arr[mid-1][colToSearch] < x && x <= arr[mid][colToSearch])
                return mid;
            if (arr[mid][colToSearch] < x)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }
    
    public boolean binSearchCol(int[][] arr, int x, int rowToSearch){
        int n = arr[0].length;
        if (arr[rowToSearch][n-1] < x)
            return false;
        if (arr[rowToSearch][0] == x || arr[rowToSearch][n-1] == x)
            return true;
        
        int l = 0, r = n-1;
        while (l <= r){
            int mid = (int) (l+r)/2;
            if (arr[rowToSearch][mid] == x)
                return true;
            if (arr[rowToSearch][mid] < x)
                l = mid+1;
            else
                r = mid-1;
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // O(logmn) = O(logm + logn)
        // binsearch the last nth-column's m values:      get the row we should search
        int rowToSearch = binSearchRow(matrix, target, matrix[0].length-1);
        if (rowToSearch == -1)
            return false;
        
        // binsearch the specific ith-row's n values:    get the target value
        return binSearchCol(matrix, target, rowToSearch);
    }
}