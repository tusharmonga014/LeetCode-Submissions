class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0) {
            if(nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        
        if(i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int j = nums.length - 1;
        int justBig = Integer.MAX_VALUE;
        int jbi = nums.length - 1;
        while(j > i) {
            if(nums[j] > nums[i] && nums[j] < justBig) {
                justBig = nums[j];
                jbi = j;
            }
            j--;
        }
        
        int temp = nums[i];
        nums[i] = nums[jbi];
        nums[jbi] = temp;
        
        reverse(nums, i + 1, nums.length - 1);
        
    }
    
    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}