class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int t = 1; t <= amount; t++) {
            for(int i = 0; i < coins.length; i++) {
                if(coins[i] <= t) {
                    if(dp[t - coins[i]] != Integer.MAX_VALUE)
                        dp[t] = Math.min(dp[t], dp[t - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}