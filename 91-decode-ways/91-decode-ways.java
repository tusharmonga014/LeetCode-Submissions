class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        
        dp[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch != '0') {
                dp[i] = dp[i + 1];
            }
            if(i + 1 < s.length()) {
                if(ch == '1' || (ch == '2' && s.charAt(i + 1) <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        
        return dp[0];
    }
}