class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        int uc = 0;
        fun(nums, new ArrayList<>(), used, uc);
        return ans;
    }
    
    public List<List<Integer>> ans;
    
    public void fun(int[] nums, List<Integer> a, boolean[] used, int uc) {
        if(uc == nums.length) {
            ans.add(new ArrayList<>(a));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                a.add(nums[i]);
                fun(nums, a, used, uc + 1);
                a.remove(a.size() - 1);
                used[i] = false;
            }
        }
    }
}