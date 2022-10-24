class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        
        int n = s.length();
        
        st.push(-1);
        
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            max = Math.max(max, i - st.getFirst() - 1);
            
            if(c == '(') {
                
                st.addFirst(i);
                
            } else {
                
                if(st.getFirst() != -1 && s.charAt(st.getFirst()) == '(')
                    st.removeFirst();
                else
                    st.addFirst(i);
                
            }
        }
        
        max = Math.max(max, n - st.getFirst() - 1);
        
        return max;
    }
}