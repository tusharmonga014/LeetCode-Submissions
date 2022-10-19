class Solution {
    public int swimInWater(int[][] grid) {
        
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> {
            int v1 = grid[a[0]][a[1]];
            int v2 = grid[b[0]][b[1]];
            
            return v1 - v2;
        });
        
        pq.add(new Integer[]{0, 0});
        
        int max = Integer.MIN_VALUE;
        
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        
        while(pq.size() != 0) {
            Integer[] hei = pq.poll();
            
            vis[hei[0]][hei[1]] = true;
            max = Math.max(max, grid[hei[0]][hei[1]]);
            
            if(hei[0] == grid.length - 1 && hei[1] == grid[0].length - 1) {
                return max;
            }
            
            for(int d = 0; d < dir.length; d++) {
                int x = dir[d][0] + hei[0];
                int y = dir[d][1] + hei[1];
                
                if(x >=0 && y >= 0 && x < grid.length && y < grid[x].length && !vis[x][y]) {
                    pq.offer(new Integer[]{x, y});
                }
            }
        }
        
        return max;
    }
}