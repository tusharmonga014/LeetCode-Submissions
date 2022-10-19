class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        
        for(int ele : nums1) {
            s1.add(ele);
        }
        
        for(int ele : nums2) {
            if(s1.contains(ele)) {
                s2.add(ele);
            }
        }
        
        int size = s2.size();
        int ans[] = new int[size];
        
        int idx = 0;
        for(int key : s2) {
            ans[idx] = key;
            idx++;
        }
        
        return ans;
    }
}