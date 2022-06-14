class Solution {
    public int minDistance(String word1, String word2) {
        // int lcs = lcs(word1, word2, 0, 0, new Integer[word1.length()][word2.length()]);
        // return word1.length() + word2.length() - (2 * lcs);
        
        return minRemove(word1, word2, 0, 0, new Integer[word1.length()][word2.length()]);
    }
    
    public int lcs(String s1, String s2, int i, int j, Integer dp[][]) {
        if(i == s1.length() || j == s2.length())
            return 0;
        
        if(dp[i][j] != null)
            return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = lcs(s1, s2, i + 1, j + 1, dp) + 1;
        } else {
            return dp[i][j] = Math.max(lcs(s1, s2, i, j + 1, dp), lcs(s1, s2, i + 1, j, dp));
        }

    }
    
    public int minRemove(String s1, String s2, int i, int j, Integer dp[][]) {
        if(i == s1.length() && j == s2.length()) {
            return 0;
        } else if(i == s1.length()) {
            return s2.length() - j;
        } else if(j == s2.length()) {
            return s1.length() - i;
        } else {
            if(dp[i][j] != null) {
                return dp[i][j];
            }
            
            if(s1.charAt(i) == s2.charAt(j)) {
                return dp[i][j] = minRemove(s1, s2, i + 1, j + 1, dp);
            } else {
                return dp[i][j] = Math.min(minRemove(s1, s2, i + 1, j, dp), minRemove(s1, s2, i, j + 1, dp)) + 1;
            }
        }
    }
}