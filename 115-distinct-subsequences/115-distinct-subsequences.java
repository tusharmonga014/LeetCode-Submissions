class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j <= t.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    char ith = s.charAt(i - 1);
                    char jth = t.charAt(j - 1);
                    if (ith == jth) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
}