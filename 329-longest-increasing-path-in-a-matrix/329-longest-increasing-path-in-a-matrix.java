class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                boolean vis[][] = new boolean[matrix.length][matrix[0].length];
                vis[i][j] = true;
                int cur = helper(matrix, i, j, vis, dp);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    private int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int helper(int[][] matrix, int i, int j, boolean[][] vis,int[][] dp) {
        int max = 0;
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        for(int d = 0; d < dir.length; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && !vis[x][y] && matrix[x][y] > matrix[i][j]) {
                vis[x][y] = true;
                int cur = helper(matrix, x, y, vis, dp);
                max = Math.max(max, cur);
                vis[x][y] = false;
            }
        }
        return dp[i][j] = max + 1;
    }
}