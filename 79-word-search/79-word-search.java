class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 1, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public boolean dfs(char[][] board, String word, int i, int j, int c, boolean[][] vis) {
        vis[i][j] = true;
        boolean res = false;
        if(c == word.length()) {
            return true;
        }
        for(int d = 0; d < dir.length; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == word.charAt(c) && !vis[x][y]) {
                res = res || dfs(board, word, x, y, c + 1, vis);
            }
        }
        vis[i][j] = false;
        return res;
    }
}