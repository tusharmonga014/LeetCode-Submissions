class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int st = 0;
        int psum[] = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            psum[i] += nums[i] + (i > 0 ? psum[i - 1] : 0);
            if(map.containsKey(nums[i]) && map.get(nums[i]) >= st) {
                int est = map.get(nums[i]);
                st = est + 1;
            }
            int sum = psum[i] - (st > 0 ? psum[st - 1] : 0);
            if(max < sum) {
                max = sum;
            }
            map.put(nums[i], i);
        }
        return max;
    }
}