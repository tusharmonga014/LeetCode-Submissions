class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        
        for(int ele : nums) {
            max = Math.max(max, ele);
            min = Math.min(min, ele);
        }
        
        return Math.max(0, (max - k) - (min + k));
    }
}