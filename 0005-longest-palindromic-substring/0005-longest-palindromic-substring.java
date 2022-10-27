class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        int max = 0;
        int ansi = 0;
        int ansj = 0;
        
        for(int g = 0; g < s.length(); g++) {
            for(int i = 0, j = g; j < s.length(); i++, j++) {
                if(g == 0) {
                    dp[i][j] = true;
                } else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                
                if(dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    ansi = i;
                    ansj = j;
                }
            }
        }
        
        return max > 0 ? s.substring(ansi, ansj + 1) : "";
    }
}