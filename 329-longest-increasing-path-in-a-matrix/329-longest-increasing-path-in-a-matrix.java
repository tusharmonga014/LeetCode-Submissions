class Solution {
    private int dp[][];
    private int matrix[][];
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        dp = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int cur = dfs(i, j);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    private int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int dfs(int i, int j) {
        int max = 0;
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        for(int d = 0; d < dir.length; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                int cur = dfs(x, y);
                max = Math.max(max, cur);
            }
        }
        return dp[i][j] = max + 1;
    }
}