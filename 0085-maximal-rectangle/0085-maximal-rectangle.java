class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int heights[] = new int[m];
                
        for(int j = 0; j < m; j++) {
            heights[j] = matrix[0][j] == '1' ? 1 : 0;
        }
        
        int max = largestAreaHistogram(heights);
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            
            int area = largestAreaHistogram(heights);
            
            max = Math.max(max, area);
        }
        
        return max;
    }
    
    public int largestAreaHistogram(int[] heights) {
        int n = heights.length;
        
        LinkedList<Integer> st = new LinkedList<>();
        
        st.push(-1);
        
        int max = 0;
        
        for(int idx = 0; idx < n; idx++) {
            while(st.getFirst() != -1 && heights[st.getFirst()] > heights[idx]) {
                int top = st.removeFirst();
                
                int w = idx - st.getFirst() - 1;
                int h = heights[top];
                int area = h * w;
                
                max = Math.max(max, area);
            }
            st.addFirst(idx);
        }
        
        while(st.getFirst() != -1) {
            int top = st.removeFirst();
            int w = n - st.getFirst() - 1;
            int area = heights[top] * w;
            
            max = Math.max(max, area);
        }
        
        return max;
    }
}