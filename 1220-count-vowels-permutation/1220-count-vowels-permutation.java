class Solution {
    public int countVowelPermutation(int n) {
        int M = (int)(1e9) + 7;
        long dp[][] = new long[n][5];
        Arrays.fill(dp[n - 1], 1);
        for(int i = n - 2; i >= 0; i--) {
            dp[i][0] = dp[i + 1][1];
            dp[i][1] = (dp[i + 1][0] + dp[i + 1][2]) % M;
            dp[i][2] = (dp[i + 1][0] + dp[i + 1][1] + dp[i + 1][3] + dp[i + 1][4]) % M;
            dp[i][3] = (dp[i + 1][2] + dp[i + 1][4]) % M;
            dp[i][4] = dp[i + 1][0];
        }
        long sum = 0;
        for(long ele : dp[0])
            sum = (sum + ele) % M;
        return (int)sum;
    }
}