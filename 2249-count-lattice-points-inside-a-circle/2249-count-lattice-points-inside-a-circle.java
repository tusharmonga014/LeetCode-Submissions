class Solution {
    public int countLatticePoints(int[][] circles) {
        int [][]dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        boolean present[][] = new boolean[400][400];
        boolean my[][] = new boolean[101][101];
        for(int i = 0; i < circles.length; i++) {
            my = new boolean[400][400];
            bfs(circles[i][0], circles[i][1], circles[i][2], circles[i][0], circles[i][1], present, my, dir);
        }
        int count = 0;
        for(int i = 0; i < 400; i++) {
            for(int j = 0; j < 400; j++) {
                if(present[i][j])
                    count++;
            }
        }
        return count;
    }
    // public int[][] dir;
    public void bfs(int x, int y, int r, int nx, int ny, boolean[][] pr, boolean[][] my, int dir[][]) {
        double dist = Math.sqrt((double)(Math.pow(nx - x, 2) + Math.pow(ny - y, 2)));
        if(dist > (double)(r)) {
            return;
        }
        else if(my[x][y]) {
            return;
        } else {
            pr[x][y] = true;
            my[x][y] = true;
            for(int d = 0; d < dir.length; d++) {
                bfs(x + dir[d][0], y + dir[d][1], r, nx, ny, pr, my, dir);
            }
        }
    }
}