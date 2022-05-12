class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    
    
    public void solve(int[] nums, boolean[] vis, List<Integer> arr, List<List<Integer>> a){
        if(arr.size() == nums.length){
            List<Integer> base = new ArrayList<>();
            for(int ele : arr){
                base.add(ele);
            }
            a.add(base);
            return;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            if(!vis[i] && !set.contains(nums[i])){
                vis[i] = true;
                set.add(nums[i]);
                arr.add(nums[i]);
                solve(nums, vis, arr, a);
                arr.remove(arr.size() - 1);
                vis[i] = false;
            }
        }
    }
}