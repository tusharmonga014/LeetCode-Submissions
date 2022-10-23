class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int os = 0;
        int rn = -1;
        int mn = -1;
        for(int i = 0; i < nums.length; i++) {
            os += Math.abs(nums[i]);
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                rn = Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
            }
        }
        
        mn = sum - (os - rn);
        return new int[]{rn, mn};
    }
}