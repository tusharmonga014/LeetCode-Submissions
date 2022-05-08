class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(i < k) {
                sum += nums[i];
                left[i] = sum;
            } else {
                sum += nums[i];
                sum -= nums[i - k];
                left[i] = Math.max(left[i - 1], sum);
            }
        }
        
        sum = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(i + k >= n) {
                sum += nums[i];
                right[i] = sum;
            } else {
                sum += nums[i];
                sum -= nums[i + k];
                right[i] = Math.max(right[i + 1], sum);
            }
        }
        
        int prefixSum[] = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int midIdx = -1;
        int leftVal_AtMax = 0;
        int rightVal_AtMax = 0;
        
        int max = 0;
        for(int i = k; i <= n - (2 * k); i++) {
            int middleSum = prefixSum[i + k - 1] - prefixSum[i - 1];
            int cur = left[i - 1] + middleSum + right[i + k];
            
            if(cur > max) {
                max = cur;
                midIdx = i;
                leftVal_AtMax = left[i - 1];
                rightVal_AtMax = right[i + k];
            }
        }
        
        int[] ans = new int[3];
        for(int i = 0; i < midIdx; i++) {
            if(left[i] == leftVal_AtMax) {
                ans[0] = i - k + 1;
                break;
            }
        }
        ans[1] = midIdx;
        for(int i = midIdx + k; i < n; i++) {
            if(prefixSum[i + k - 1] - prefixSum[i - 1] == rightVal_AtMax) {
                ans[2] = i;
                break;
            }
        }
        
        return ans;
    }
}