class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        revRows(matrix);
    }
    
    private void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; i + j < matrix[i].length - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix[i].length - 1 - j][matrix.length - 1 - i];
                matrix[matrix[i].length - 1 - j][matrix.length - 1 - i] = temp;
            }
        }
    }
    
    private void revRows(int[][] matrix) {
        int i = 0, j = matrix.length - 1;
        while(i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
}