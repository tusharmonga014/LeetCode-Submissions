class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int st = 0;
        int end = nums.length - 1;
        while(st < end) {
            while(st < end && nums[st] % 2 == 0) {
                st++;
            }
            while(st < end && nums[end] % 2 != 0) {
                end--;
            }
            if(st < end) {
                int temp = nums[st];
                nums[st] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }
}