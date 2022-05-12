class Solution {
    public int integerBreak(int n) {
        if(n == 1) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int li = 1;
            int ri = i - 1;
            int max = Integer.MIN_VALUE;
            while(li <= ri) {
                max = Math.max(max, Math.max(li, dp[li]) * Math.max(ri, dp[ri]));
                li++;
                ri--;
            }
            dp[i] = max;
        }
        return dp[n];
    }
}