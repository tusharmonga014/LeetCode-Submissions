class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for(int t = 1; t <= target; t++) {
            for(int i = 0; i < nums.length; i++) {
                if(t >= nums[i]) {
                    dp[t] += dp[t - nums[i]];
                }
            }
        }
        return dp[target];
    }
}