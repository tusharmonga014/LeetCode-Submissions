class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo < hi) {
                    if(lo > i + 1 && nums[lo] == nums[lo - 1]) lo++;
                    else if(nums[i] + nums[lo] + nums[hi] > 0) {
                        hi--;
                    } else if(nums[i] + nums[lo] + nums[hi] < 0) {
                        lo++;
                    } else {
                        List<Integer> sAns = new ArrayList<>();
                        sAns.add(nums[i]);
                        sAns.add(nums[lo]);
                        sAns.add(nums[hi]);
                        ans.add(sAns);
                        lo++;
                        hi--;
                    }
                }
            }
        }
        return ans;
    }
}