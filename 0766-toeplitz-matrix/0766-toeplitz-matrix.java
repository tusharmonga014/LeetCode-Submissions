class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int g = 0; g < m; g++) {
            int ele = matrix[0][g];
            for(int i = 1, j = g + 1; i < n && j < m; i++, j++) {
                if(matrix[i][j] != ele) {
                    return false;
                }
            }
        }
        
        for(int r = 1; r < n; r++) {
            int ele = matrix[r][0];
            for(int j = 1, i = r + 1; j < m && i < n; i++, j++) {
                if(matrix[i][j] != ele) {
                    return false;
                }
            }
        }
        
        return true;
    }
}