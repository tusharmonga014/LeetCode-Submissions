class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        
        int templ = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i < firstLen) {
                templ += nums[i];
            } else {
                templ -= nums[i - firstLen];
                templ += nums[i];
            }
            
            if(i >= firstLen - 1) {
                left[i] = Math.max(i > 0 ? left[i - 1] : 0, templ);
            }
        }
        
        int tempr = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums.length - i - 1 < firstLen) {
                tempr+= nums[i];
            } else {
                tempr -= nums[i + firstLen];
                tempr += nums[i];
            }
            
            if(nums.length - i - 1 >= firstLen - 1) {
                right[i] = Math.max(i + 1 < nums.length ? right[i + 1] : 0, tempr);
            }
        }
        
        int max = 0;
        
        int temps = 0;
        for(int i = 0; i < secondLen; i++) {
            temps += nums[i];
        }
        max = temps + right[secondLen];
        for(int i = secondLen; i < nums.length; i++) {
            temps -= nums[i - secondLen];
            temps += nums[i];
            
            int firstOnLeft = temps + left[i - secondLen];
            int firstOnRight = i + firstLen < nums.length ? temps + right[i + 1] : 0;
            
            max = Math.max(max, Math.max(firstOnRight, firstOnLeft));
        }
        
        return max;
    }
}