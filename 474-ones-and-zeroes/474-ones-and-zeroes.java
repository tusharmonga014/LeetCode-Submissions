class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int f[][] = new int[strs.length][2];
        for(int k = 0 ; k < strs.length; k++) {
            String s = strs[k];
            int c0 = 0;
            int c1 = 0;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '0') c0++;
                else c1++;
            }
            f[k][0] = c0;
            f[k][1] = c1;
        }
        int ans = tab(f, 0, m, n, new Integer[strs.length][m + 1][n + 1]);
        return ans;
    }
    
    public int tab(int[][] f, int i, int m, int n, Integer[][][] dp) {
        if(i == f.length || (m == 0 && n == 0)) {
            return 0;
        }
        
        if(dp[i][m][n] != null) {
            return dp[i][m][n];
        }
        
        int inc, exc;
        inc = exc = 0;
        
        if(f[i][0] <= m && f[i][1] <= n)
            inc = tab(f, i + 1, m - f[i][0], n - f[i][1], dp) + 1;
        exc = tab(f, i + 1, m, n, dp);
        
        return dp[i][m][n] = Math.max(inc, exc);
    }
}