class Solution {
    public int majorityElement(int[] nums) {
        Integer max = null;
        int count = 0;
        for(int ele : nums) {
            if(count == 0) {
                max = ele;
            }
            
            if(max == ele) count++;
            else count--;
        }
        return max;
    }
}