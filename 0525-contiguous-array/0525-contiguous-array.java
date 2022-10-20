class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        
        int csum = 0;
        
        map.put(csum, -1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) csum--;
            else csum++;
            
            if(map.containsKey(csum)) {
                int cur = (i - map.get(csum)); // as both pointers are not inclusive, so not + 1
                max = Math.max(max, cur);
            } else {
                map.put(csum, i);
            }
        }
        
        return max;
    }
}