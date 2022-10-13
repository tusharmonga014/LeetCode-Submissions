class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer dp[][][] = new Integer[prices.length][2][k + 1];
        return f(prices, 0, 1, k, dp);
    }
    
    private int f(int[] prices, int idx, int buy, int k, Integer[][][] dp) {
        if(idx == prices.length) {
            return 0;
        }
        
        if(k == 0) {
            return 0;
        }
        
        if(dp[idx][buy][k] != null) return dp[idx][buy][k];
        
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[idx] + f(prices, idx + 1, 0, k, dp), f(prices, idx + 1, 1, k, dp));
        } else {
            profit = Math.max(prices[idx] + f(prices, idx + 1, 1, k - 1, dp), f(prices, idx + 1, 0, k, dp));
        }
        return dp[idx][buy][k] = profit;
    }
}