class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        
        int ans = bfs(grid);
        return ans;
    }
    
    private int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    
    private class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    private int bfs(int[][] grid) {
        LinkedList<Pair> que = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        que.add(new Pair(0, 0));
        boolean reached = false;
        int level = 0;
        
        while(!que.isEmpty() && !reached) {
            int size = que.size();
            while(size-- > 0) {
                Pair rem = que.removeFirst();
                
                if(vis[rem.i][rem.j])
                    continue;
                vis[rem.i][rem.j] = true;
                
                if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1) {
                    reached = true;
                }
                
                for(int d = 0; d < dir.length; d++) {
                    int x = dir[d][0] + rem.i;
                    int y = dir[d][1] + rem.j;
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !vis[x][y] && grid[x][y] == 0) {
                        que.addLast(new Pair(x, y));
                    }
                }
            }
            level++;
        }
        
        if(reached) {
            return level;
        } else {
            return -1;
        }
    }
}