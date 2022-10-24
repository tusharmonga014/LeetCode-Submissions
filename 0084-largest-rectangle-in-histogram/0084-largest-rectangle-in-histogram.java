class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int max = 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int idx = 0; idx < n; idx++) {
            while(st.peek() != -1 && heights[st.peek()] >= heights[idx]) {
                int top = st.pop();
                
                int w = idx - st.peek() - 1;
                int area = heights[top] * w;
                
                max = Math.max(max, area);
            }
            st.push(idx);
        }
        
        while(st.peek() != -1) {
            int top = st.pop();
            int w = n - st.peek() - 1;
            int area = heights[top] * w;

            max = Math.max(max, area);
        }
        
        return max;
    }
}