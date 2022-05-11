class Solution {
    public int countVowelStrings(int n) {
        int dp[] = new int[5];
        
        Arrays.fill(dp, 1);
        for(int i = 2; i <= n; i++) {
            dp[0] = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
            dp[1] = dp[1] + dp[2] + dp[3] + dp[4];
            dp[2] = dp[2] + dp[3] + dp[4];
            dp[3] = dp[3] + dp[4];
            dp[4] = dp[4];
        }
        
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += dp[i];
        }
        
        return sum;
    }
}