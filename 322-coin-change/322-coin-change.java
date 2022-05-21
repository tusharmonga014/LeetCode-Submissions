class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer dp[] = new Integer[amount + 1];
        dp[0] = 0;
        for(int t = 1; t <= amount; t++) {
            for(int i = 0; i < coins.length; i++) {
                if(coins[i] <= t) {
                    if(dp[t - coins[i]] != null)
                        if(dp[t] == null) dp[t] = dp[t - coins[i]] + 1;
                        else dp[t] = Math.min(dp[t], dp[t - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == null ? -1 : dp[amount];
    }
}