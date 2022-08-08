class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j] && dp[i] < dp[j])
                    dp[i] = dp[j];
            }
            dp[i]++;
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}