class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] po = new boolean[heights.length][heights[0].length];
        boolean[][] ao = new boolean[heights.length][heights[0].length];
        
        for(int i = 0; i < heights.length; i++)
            dfs(heights, i, 0, po);
        for(int j = 0; j < heights[0].length; j++)
            dfs(heights, 0, j, po);
        
        for(int i = 0; i < heights.length; i++)
            dfs(heights, i, heights[0].length - 1, ao);
        for(int j = 0; j < heights[0].length; j++)
            dfs(heights, heights.length - 1, j, ao);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(po[i][j] && ao[i][j]) {
                    List<Integer> smallAns = new ArrayList<>();
                    smallAns.add(i);
                    smallAns.add(j);
                    ans.add(smallAns);
                }
            }
        }
        
        return ans;
    }
    
    private int dir[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    private void dfs(int[][] heights, int i, int j, boolean[][] o) {
        o[i][j] = true;
        for(int d = 0; d < dir.length; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if(x >= 0 && y >= 0 && x < heights.length && y < heights[x].length && !o[x][y] && heights[i][j] <= heights[x][y]) {
                dfs(heights, x, y, o);
            }
        }
    }
}