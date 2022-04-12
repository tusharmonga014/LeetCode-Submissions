class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        
        int dir[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int countLiveNei = 0;
                for(int d = 0; d < dir.length; d++) {
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];
                    
                    if(x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                        if(board[x][y] == 1)
                            countLiveNei++;
                    }
                }
                
                if(board[i][j] == 0) {
                    if(countLiveNei == 3) {
                        newBoard[i][j] = 1;
                    }
                } else {
                    if(countLiveNei < 2 || countLiveNei > 3) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
}