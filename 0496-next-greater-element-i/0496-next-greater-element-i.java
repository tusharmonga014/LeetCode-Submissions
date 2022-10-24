class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> ngor = new HashMap<>();
        st.push(-1);
        for(int idx = 0; idx < nums2.length; idx++) {
            while(st.peek() != -1 && nums2[st.peek()] < nums2[idx])
                ngor.put(nums2[st.pop()], nums2[idx]);
            st.push(idx);
        }
        int ans[] = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = ngor.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}