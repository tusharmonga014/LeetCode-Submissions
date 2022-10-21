class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<Integer[]> st = new Stack<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        
        st.push(new Integer[]{intervals[0][0], intervals[0][1]});
        int i = 1;
        while(i < intervals.length) {
            if(st.peek()[1] >= intervals[i][0]) {
                if(st.peek()[1] < intervals[i][1]) {
                    Integer[] interval = st.pop();
                    interval[1] = intervals[i][1];
                    st.push(interval);
                }
            }  else {
                Integer[] interval = {intervals[i][0], intervals[i][1]};
                st.push(interval);
            }
            i++;
        }
        
        int ans[][] = new int[st.size()][2];
        for(int idx = st.size() - 1; idx >= 0; idx--) {
            Integer interval[] = st.pop();
            ans[idx] = new int[]{interval[0], interval[1]};
        }
        
        return ans;
    }
}