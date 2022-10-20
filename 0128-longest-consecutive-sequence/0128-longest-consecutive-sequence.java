class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) {
            set.add(ele);
        }
        
        int range = 0;
        for(int ele : nums) {
            
            int prev = ele;
            while(set.contains(prev - 1)) {
                set.remove(prev - 1);
                prev--;
            }
            
            int next = ele;
            while(set.contains(next + 1)) {
                set.remove(next + 1);
                next++;
            }
            
            int cur_range = next - prev + 1;
            range = Math.max(range, cur_range);
        }
        
        return range;
    }
}