class Solution {
    public int maxCoins(int[] nums) {
        // int ans = rec(nums, 0, nums.length - 1, new int[nums.length][nums.length]);
        int ans = tab(nums);
        return ans;
    }
    
    public int tab(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        for(int g = 0; g < nums.length; g++) {
            for(int i = 0, j = g; j < nums.length; i++, j++) {
                if(g == 0) { 
                    // i == j
                    int balloonOnLeft = (i == 0 ? 1 : nums[i - 1]);
                    int balloonOnRight = (i == nums.length - 1 ? 1 : nums[i + 1]);
                    dp[i][i] = balloonOnLeft * nums[i] * balloonOnRight;
                } else if(g == 1) {
                    int balloonOnLeft = (i == 0 ? 1 : nums[i - 1]);
                    int balloonOnRight = (j == nums.length - 1 ? 1 : nums[j + 1]);
                    int c1 = (balloonOnLeft * nums[i] * balloonOnRight) + dp[i + 1][j];
                    int c2 = dp[i][j - 1] + (balloonOnLeft * nums[j] * balloonOnRight);
                    dp[i][j] = Math.max(c1, c2);
                } else {
                    int max = Integer.MIN_VALUE;
                    for(int k = i; k <= j; k++) {
                        int balloonOnLeft = (i == 0 ? 1 : nums[i - 1]);
                        int balloonOnRight = (j == nums.length - 1 ? 1 : nums[j+1]);
                        int leftAns = k == i ? 0 : dp[i][k - 1];
                        int rightAns = k == j ? 0 : dp[k + 1][j];
                        int c = leftAns + (balloonOnLeft * nums[k] * balloonOnRight) + rightAns;
                        max = Math.max(max, c);
                    }
                    dp[i][j] = max;
                }
            }
        }
        
        return dp[0][nums.length - 1];
    }
    
    public int rec(int[] nums, int i, int j) {
        if(i > j) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int idx = i; idx <= j; idx++) {
            
            int left = rec(nums,  i, idx - 1);
            int right = rec(nums, idx + 1, j);
            
            int balloonLeft = i == 0 ? 1 : nums[i - 1];
            int balloonRight = j == nums.length - 1 ? 1 : nums[j + 1];
            int myValue = balloonLeft * nums[idx] * balloonRight;
            
            int cur = left + myValue + right;
            max = Math.max(max, cur);
        }
        
        return max;
    }
}