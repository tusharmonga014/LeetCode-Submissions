class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];
        int M = (int)(1e9) + 7;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0) {
                    if(j == 0)
                        dp[i][j] = 1;
                    else 
                        dp[i][j] = 0;
                }
                else if(i == j) {
                    dp[i][j] = 1;
                } else if(i > j) {
                    dp[i][j] = 0;
                } else {
                    int count = 0;
                    for(int l = 1; l <= k; l++) {
                        if(j - l >= 0)
                            count = (count + dp[i - 1][j - l]) % M;
                    }
                    dp[i][j] = count;
                }
            }
        }
        return dp[n][target];
    }
}