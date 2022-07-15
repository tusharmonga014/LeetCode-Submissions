class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!vis[i][j]) {
                    int val = dfs(grid, vis, i, j);
                    max = Math.max(max, val);
                }
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        if(vis[i][j] || grid[i][j] == 0)
            return 0;
        
        vis[i][j] = true;
        
        int up = dfs(grid, vis, i - 1, j);
        int lt = dfs(grid, vis, i, j + 1);
        int dn = dfs(grid, vis, i + 1, j);
        int rt = dfs(grid, vis, i, j - 1);
        
        return up + lt + dn + rt + 1;
    }
}