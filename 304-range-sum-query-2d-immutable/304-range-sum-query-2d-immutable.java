class NumMatrix {
    
    long prefixSum[][];
    
    public NumMatrix(int[][] matrix) {
        prefixSum = new long[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            prefixSum[i][0] = matrix[i][0];
            for(int j = 1; j < matrix[0].length; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        long sum = 0;
        for(int i = row1; i <= row2; i++) {
            long toSub = col1 == 0 ? 0 : prefixSum[i][col1 - 1];
            sum += prefixSum[i][col2] - toSub;
        }
        return (int)(sum);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */