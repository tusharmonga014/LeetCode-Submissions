class Solution {
    public List<List<String>> solveNQueens(int n) {
        finalAns = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, 0, 0, ans);
        return finalAns;
    }
    
    public List<List<String>> finalAns;
    
    public void solve(int n, int r, int col, int diag, int adiag, List<String> ans){
        
        if(r == n){
            List<String> base = new ArrayList<>();
            for(String s : ans)
                base.add(s);
            finalAns.add(base);
            return;
        }
        
        for(int c = 0; c < n; c++){
            int c_mask = 1 << c;
            int diag_mask = 1 << (r + c);
            int adiag_mask = 1 << (n - 1 - c + r);
            
            if((c_mask & col) == 0 && (diag_mask & diag) == 0 && (adiag_mask & adiag) == 0){
                
                col ^= c_mask;
                diag ^= diag_mask;
                adiag ^= adiag_mask;
                
                StringBuilder sb = new StringBuilder();
                for(int ch = 0; ch < n; ch++){
                    if(ch == c){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                
                String myLine = sb.toString();
                
                ans.add(myLine);
                solve(n, r + 1, col, diag, adiag, ans);
                ans.remove(ans.size() - 1);
                
                col ^= c_mask;
                diag ^= diag_mask;
                adiag ^= adiag_mask;
                                
            }
        }
    }
}