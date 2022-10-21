class Solution {
    public int findDuplicate(int[] nums) {
        int ans = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                ans = Math.abs(nums[i]);
                break;
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return ans;
    }
}