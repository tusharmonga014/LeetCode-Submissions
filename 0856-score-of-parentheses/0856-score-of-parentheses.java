class Solution {
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        
        for(char c : s.toCharArray()) {
            if(st.isEmpty() || c == '(') {
                st.push(-1);
            } else if (st.peek() < 0) {
                st.pop();
                int count = 0;
                while(!st.isEmpty() && st.peek() > 0) {
                    count += st.pop();
                }
                st.push(count + 1);
            } else {
                int val = st.pop(); // (A) pop A
                st.pop(); // pop '('
                st.push(val * 2);
                int count = 0;
                while(!st.isEmpty() && st.peek() > 0) {
                    count += st.pop();
                }
                st.push(count);
            }
        }
        
        int ans = 0;
        while(st.size() != 0) {
            ans += st.pop();
        }
        
        return ans;
    }
}