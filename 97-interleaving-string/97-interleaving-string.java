class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean [][][]dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return solve(s1, s2, s3, 0, 0, 0, dp);
    }
    
    public boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][][]dp)     {
        if(i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        } else if(k == s3.length()) {
            return false;
        }
        if(dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        boolean res = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = res || solve(s1, s2, s3, i + 1, j, k + 1, dp);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || solve(s1, s2, s3, i, j + 1, k + 1, dp);
        }
        return dp[i][j][k] = res;
    }
}