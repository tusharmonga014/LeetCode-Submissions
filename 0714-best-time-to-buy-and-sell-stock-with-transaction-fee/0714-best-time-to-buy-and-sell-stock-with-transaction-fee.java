class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length + 1][2];
        for(int i = prices.length - 1; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][0] + prices[i], dp[i + 1][1]);
            dp[i][0] = Math.max(dp[i + 1][1] - prices[i] - fee, dp[i + 1][0]);
        }
        return dp[0][0];
    }
}