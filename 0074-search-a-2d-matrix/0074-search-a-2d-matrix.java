class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[n - 1][m - 1]) 
            return false;
        
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(target < matrix[mid][0]) {
                hi = mid - 1;
            } else if(target > matrix[mid][0]){
                lo = mid + 1;
            } else {
                return true;
            }
        }
        
        int row = hi;
        int st = 0, end = m - 1;
        while(st <= end) {
            int mid = (st + end) / 2;
            if(target < matrix[row][mid]) {
                end = mid - 1;
            } else if(target > matrix[row][mid]) {
                st = mid + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}