class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer dp[][][] = new Integer[m][n][maxMove + 1];
        return solve(m, n, maxMove, startRow, startColumn, dp);
    }
    private int M = (int)(1e9) + 7;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int solve(int m, int n, int maxMove, int sr, int sc, Integer[][][] dp) {
        if(sr < 0 || sc < 0 || sr >= m || sc >= n) {
            return 1;
        } else {
            if(maxMove == 0) {
                return 0;
            } else {
                if(dp[sr][sc][maxMove] != null) {
                    return dp[sr][sc][maxMove];
                }
                int count = 0;
                for(int d = 0; d < dir.length; d++) {
                    int x = sr + dir[d][0];
                    int y = sc + dir[d][1];
                    count = (count + solve(m, n, maxMove - 1, x, y, dp)) % M;
                }
                return dp[sr][sc][maxMove] = count;
            }
        }
    }
}