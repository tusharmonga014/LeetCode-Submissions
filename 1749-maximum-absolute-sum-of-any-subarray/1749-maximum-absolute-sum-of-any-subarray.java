class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int psum = nums[0];
        int nsum = nums[0];
        
        int cpsum = psum;
        int cnsum = nsum;
        
        for(int i = 1; i < nums.length; i++) {
            if(cpsum >= 0) {
                cpsum += nums[i];
            } else {
                cpsum = nums[i];
            }
            
            if(cnsum <= 0) {
                cnsum += nums[i];
            } else {
                cnsum = nums[i];
            }
            
            psum = Math.max(psum, cpsum);
            nsum = Math.min(nsum, cnsum);
        }
        
        return Math.max(psum, Math.abs(nsum));
    }
}