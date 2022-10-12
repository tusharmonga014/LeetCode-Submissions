class Solution {
    public int largestPerimeter(int[] nums) {
        int sum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--) {
            if(nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }
}