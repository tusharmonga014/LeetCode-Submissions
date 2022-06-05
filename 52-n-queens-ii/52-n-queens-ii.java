class Solution {
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }
        
    public int solve(int n, int r, int col, int diag, int adiag){
        
        if(r == n){
            return 1;
        }
        
        int count = 0;
        
        for(int c = 0; c < n; c++){
            int c_mask = 1 << c;
            int diag_mask = 1 << (r + c);
            int adiag_mask = 1 << (n - 1 - c + r);
            
            if((c_mask & col) == 0 && (diag_mask & diag) == 0 && (adiag_mask & adiag) == 0){
                col ^= c_mask;
                diag ^= diag_mask;
                adiag ^= adiag_mask;
                
                count += solve(n, r + 1, col, diag, adiag);
                
                col ^= c_mask;
                diag ^= diag_mask;
                adiag ^= adiag_mask;
            }
        }
        
        return count;
    }
}