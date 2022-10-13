class Solution {
    public int maxProfit(int k, int[] prices) {
        // Integer dp[][][] = new Integer[prices.length][2][k + 1];
        // return f(prices, 0, 1, k, dp);
        
        Integer dp[][] = new Integer[prices.length][k + 1];
        return pep_MEMO(prices, prices.length - 1, k, dp);
        // int dp[][][] = new int[prices.length + 1][2][k + 1];
        // for(int i = prices.length - 1; i >= 0; i--) {
        //     for(int j = 1; j <= k; j++) {
        //         dp[i][0][j] = Math.max(prices[i] + dp[i + 1][1][j - 1], dp[i + 1][0][j]);
        //         dp[i][1][j] = Math.max(-prices[i] + dp[i + 1][0][j], dp[i + 1][1][j]);
        //     }
        // }
        // return dp[0][1][k];
    }
    
    public int pep_MEMO(int prices[], int i, int k, Integer[][] dp) {
        if(i < 0 || k == 0) {
            return 0;
        }
        if(dp[i][k] != null) return dp[i][k];
        int prevDayK = pep_MEMO(prices, i - 1, k, dp);
        int todayKth = Integer.MIN_VALUE;
        for(int idx = 0; idx < i; idx++) {
            todayKth = Math.max(todayKth, pep_MEMO(prices, idx, k - 1, dp) - prices[idx] + prices[i]);
        }
        return dp[i][k] = Math.max(prevDayK, todayKth);
    }
    
    public int pep_TAB(int[] prices, int k) {
        int dp[][] = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            for(int day = 0; day < prices.length; day++) {
                if(day == 0) {
                    dp[i][day] = 0;
                } else {
                    dp[i][day] = Math.max(dp[i][day - 1], max + prices[day]);
                }
                max = Math.max(max, dp[i - 1][day] - prices[day]);
            }
        }
        return dp[k][prices.length];
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