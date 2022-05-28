class Solution {
    public int missingNumber(int[] nums) {
        long osum = 0;
        for(int ele : nums) {
            osum += ele;
        }
        long sum = (nums.length * (nums.length + 1)) / 2;
        return (int)(sum - osum);
    }
}